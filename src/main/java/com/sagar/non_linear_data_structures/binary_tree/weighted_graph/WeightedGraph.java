package com.sagar.non_linear_data_structures.binary_tree.weighted_graph;

import java.util.*;

public class WeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from.label + " -> " + to.label + " (" + weight + ")";
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalStateException();

        // Weighted Directed Graph
        fromNode.addEdge(toNode, weight);
        // Weighted Un-Directed graph
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var neighbours = node.getEdges();
            if (!neighbours.isEmpty())
                System.out.println(node + " -> " + neighbours);
        }
    }

    // ----------------------------------- Dijkstra's Algorithm --------------------------------------------------------

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalStateException();

        Map<Node, Integer> distances = new HashMap<>();

        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);

        distances.replace(fromNode, 0);

        Map<Node, Node> previousNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                // distance of current point from starting point and plus edge weight
                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(toNode, previousNodes);
    }

    private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);

        var previous = previousNodes.get(toNode);

        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty()) {
            path.add(stack.pop().label);
        }
        return path;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values()) {
            if (!visited.contains(node))
                if (hasCycle(node, null, visited))
                    return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for (var edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to))
                return true;
            var result = hasCycle(edge.to, node, visited);

            if (result)
                return true;
        }
        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        var tree = new WeightedGraph();

        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();

            if (tree.containsNode(minEdge.to.label))
                continue;

            tree.addNode(minEdge.to.label);
            tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);

            for (var edge : minEdge.to.getEdges())
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }
        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }
}
