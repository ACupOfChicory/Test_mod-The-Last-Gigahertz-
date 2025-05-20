package net.acupofchicory.testmod.power;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;

import java.util.*;

public class NodeManager {
    private static NodeManager instance;
    private final Map<BlockPos, PowerNode> nodes = new HashMap<>();
    private final Map<Integer, PowerNetwork> networks = new HashMap<>();
    private final Map<ChunkPos, Set<BlockPos>> chunkToNodes = new HashMap<>();
    private boolean needsRebuild = true;
    private int lastNetworkId = 0;

    public static NodeManager getInstance() {
        if (instance == null) {
            instance = new NodeManager();
        }
        return instance;
    }

    public void addNode(BlockPos pos, PowerNode node) {
        nodes.put(pos, node);
        ChunkPos chunkPos = new ChunkPos(pos);
        chunkToNodes.computeIfAbsent(chunkPos, k -> new HashSet<>()).add(pos);
        needsRebuild = true;
    }

    public void removeNode(BlockPos pos) {
        PowerNode node = nodes.remove(pos);
        if (node != null) {
            ChunkPos chunkPos = new ChunkPos(pos);
            Set<BlockPos> nodesInChunk = chunkToNodes.get(chunkPos);
            if (nodesInChunk != null) {
                nodesInChunk.remove(pos);
                if (nodesInChunk.isEmpty()) {
                    chunkToNodes.remove(chunkPos);
                }
            }

            if (node.getNetwork() != null) {
                node.getNetwork().removeNode(node);
            }
            needsRebuild = true;
        }
    }

    public void onChunkLoad(ChunkPos chunkPos) {
        Set<BlockPos> nodesInChunk = chunkToNodes.get(chunkPos);
        if (nodesInChunk != null) {
            nodesInChunk.forEach(pos -> {
                PowerNode node = nodes.get(pos);
                if (node != null && node.getNetwork() == null) {
                    needsRebuild = true;
                }
            });
        }
    }

    public void onChunkUnload(ChunkPos chunkPos) {
        // При разгрузке чанка узлы остаются, но их сети могут нуждаться в перестроении
        needsRebuild = true;
    }

    public void rebuildNetworks() {
        if (!needsRebuild) return;

        // Очищаем текущие сети
        networks.values().forEach(PowerNetwork::clear);
        networks.clear();

        // Создаем временный набор для отслеживания обработанных узлов
        Set<BlockPos> processed = new HashSet<>();

        for (BlockPos pos : nodes.keySet()) {
            if (processed.contains(pos)) continue;

            PowerNode startNode = nodes.get(pos);
            if (startNode == null) continue;

            // Создаем новую сеть
            int networkId = ++lastNetworkId;
            PowerNetwork network = new PowerNetwork(networkId);
            networks.put(networkId, network);

            // Обходим все соединенные узлы
            Queue<BlockPos> queue = new LinkedList<>();
            queue.add(pos);
            processed.add(pos);

            while (!queue.isEmpty()) {
                BlockPos currentPos = queue.poll();
                PowerNode currentNode = nodes.get(currentPos);
                if (currentNode == null) continue;

                network.addNode(currentNode);

                // Проверяем соседние узлы (6 направлений)
                for (Direction direction : Direction.values()) {
                    BlockPos neighborPos = currentPos.offset(direction);
                    if (processed.contains(neighborPos)) continue;

                    PowerNode neighbor = nodes.get(neighborPos);
                    if (neighbor != null && neighbor.canConnect(currentNode)) {
                        queue.add(neighborPos);
                        processed.add(neighborPos);
                    }
                }
            }
        }

        needsRebuild = false;
    }

    public void tick() {
        if (needsRebuild) {
            rebuildNetworks();
        }

        // Параллельная обработка сетей
        networks.values().parallelStream().forEach(PowerNetwork::tick);
    }

    public int getNewNetworkId() {
        return ++lastNetworkId;
    }

    public int getNodeCount() {
        return nodes.size();
    }

    public int getNetworkCount() {
        return networks.size();
    }
}