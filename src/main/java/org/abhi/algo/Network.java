package org.abhi.algo;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Network {

    public static Node createNode(String name) {
        return new Node(name);
    }

    public static Link createLink(Integer cost, Node source, Node destination) {
        Node[] nodes = new Node[2];
        nodes[0] = source;
        nodes[1] = destination;
        return new Link(cost, nodes);
    }

    public static void addLinkToNode(Node source, Link... links) {
        if(validateLinks(source, links) == Boolean.FALSE) {
            throw new IllegalArgumentException("links are not valid for this source");
        }
        else {
            for(Link link : links) {
                source.addLink(link);
            }
        }
    }

    public static void recursiveDepthFirstTravel(Node startNode, Consumer<Node> nodeConsumer) {
        startNode.setVisited(true);
        nodeConsumer.accept(startNode);
        for (Link link: startNode.getLinks()) {
            Node nextNode = link.getNodes()[1];
            if(!nextNode.isVisited()) {
                recursiveDepthFirstTravel(link.getNodes()[1], nodeConsumer);
            }
            else {
                System.out.println("Ignoring the visited Node - " + nextNode);
            }
        }
    }

    public static void nonRecursiveDepthFirstTravel(Node startNode, Consumer<Node> nodeConsumer) {
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(startNode);
        while (!nodeStack.empty()) {
            Node node = nodeStack.pop();
            node.setVisited(true);
            nodeConsumer.accept(node);
            for (Link link: node.getLinks()) {
                Node nextNode = link.getNodes()[1];
                if(!nextNode.isVisited()) {
                    nodeStack.push(nextNode);
                }
                else {
                    System.out.println("Ignoring the visited Node - " + nextNode);
                }
            }
        }
    }

    public static void nonRecursiveBreadthFirstTravel(Node startNode, Consumer<Node> nodeConsumer) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(startNode);
        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            node.setVisited(true);
            nodeConsumer.accept(node);
            for (Link link: node.getLinks()) {
                Node nextNode = link.getNodes()[1];
                if(!nextNode.isVisited()) {
                    nodeQueue.offer(nextNode);
                }
                else {
                    System.out.println("Ignoring the visited Node - " + nextNode);
                }
            }
        }
    }

    private static boolean validateLinks(Node source, Link[] links) {
        boolean isValidLink = true;
        for (Link link: links) {
            isValidLink = isValidLink && (source.getName().equalsIgnoreCase(link.getNodes()[0].getName()));
        }
        return isValidLink;
    }

    public static class Node {
        private final String name;
        private boolean isVisited = false;
        private List<Link> links = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public List<Link> getLinks() {
            return links;
        }

        public void addLink(Link link) {
            links.add(link);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", isVisited=" + isVisited +
                    ", links=" + links +
                    '}';
        }
    }

    public static class Link {
        private final Integer cost;
        private final Node[] nodes;
        public Link(Integer cost, Node[] nodes) {
            this.cost = cost;
            this.nodes = nodes;
        }

        public Integer getCost() {
            return cost;
        }

        public Node[] getNodes() {
            return nodes;
        }

        @Override
        public String toString() {
            String nodeNames = Arrays.stream(getNodes()).map(Node::getName).collect(Collectors.joining(" , "));
            return "Link{" +
                    "cost=" + getCost() +
                    " and connected nodes=" + nodeNames +
                    '}';
        }
    }
}
