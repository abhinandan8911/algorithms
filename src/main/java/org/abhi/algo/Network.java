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

    public static void recursiveBreadthFirstTravel(Node startNode, Consumer<Node> nodeConsumer) {
        startNode.setVisited(true);
        nodeConsumer.accept(startNode);
        for (Link link: startNode.getLinks()) {
            Node nextNode = link.getNodes()[1];
            if(!nextNode.isVisited()) {
                recursiveBreadthFirstTravel(link.getNodes()[1], nodeConsumer);
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

    public static boolean isConnected(Node node) {
        nonRecursiveBreadthFirstTravel(node, System.out::println);
        List<Node> allNodes = getAllNodes(node);
        for(Node singleNode :allNodes) {
            if(!singleNode.isVisited()) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateLinks(Node source, Link[] links) {
        boolean isValidLink = true;
        for (Link link: links) {
            isValidLink = isValidLink && (source.getName().equalsIgnoreCase(link.getNodes()[0].getName()));
        }
        return isValidLink;
    }

    public static List<Node> getAllNodes(Node startNode) {
        Stack<Node> nodeStack = new Stack<>();
        List<Node> nodeList = new ArrayList<>();
        nodeStack.push(startNode);
        while (!nodeStack.empty()) {
            Node node = nodeStack.pop();
            node.setVisited(true);
            nodeList.add(node);
            for(Link link : node.getLinks()) {
                Node nextNode = link.getNodes()[1];
                link.setVisited(true);
                if(!nextNode.isVisited()) {
                    nodeStack.push(nextNode);
                }
            }
        }
        return nodeList;
    }

    public static List<Node> createSpanningTree(Node startNode) {
        Stack<Node> nodeStack = new Stack<>();
        List<Node> nodeList = new ArrayList<>();
        nodeStack.push(startNode);
        while(!nodeStack.empty()) {
            Node node = nodeStack.pop();
            node.setVisited(true);
            nodeList.add(node);
            for(Link link : node.getLinks()) {
                link.setVisited(true);
                Node nextNode = link.getNodes()[1];
                if(!nextNode.isVisited()) {
                    nodeStack.push(nextNode);
                    nextNode.setFromNode(node);
                }
            }
        }
        return nodeList;
    }

    public static List<Node> createMinimalSpanningTree(Node startNode) {
        List<Node> minimalTreeList = new ArrayList<>();
        List<Link> candidateList = new ArrayList<>();
        minimalTreeList.add(startNode);
        startNode.setVisited(true);
        candidateList.addAll(startNode.getLinks());
        while (!candidateList.isEmpty()) {
            int minCost = Integer.MAX_VALUE;
            Node possibleNode = null;
            Link matchingLink = null;
            Link markForRemoval = null;
            for(Link link : candidateList) {
                Node nextNode = link.getNodes()[1];
                if(nextNode.isVisited()) {
                    markForRemoval = link;
                }
                if(link.getCost() < minCost) {
                    if(!minimalTreeList.contains(nextNode) && !nextNode.isVisited()) {
                        minCost = link.getCost();
                        possibleNode = nextNode;
                        matchingLink = link;
                    }
                }
            }
            if(Objects.nonNull(possibleNode)) {
                possibleNode.setVisited(true);
                minimalTreeList.add(possibleNode);
                System.out.println("Cost of the added Node is - " + matchingLink.getCost());
                candidateList.addAll(possibleNode.getLinks());
                if(Objects.nonNull(matchingLink)) {
                    candidateList.remove(matchingLink);
                }
            }
            if(Objects.nonNull(markForRemoval)) {
                candidateList.remove(markForRemoval);
            }
        }
        return minimalTreeList;
    }

    public static class Node {
        private final String name;
        private boolean isVisited = false;
        private Node fromNode;
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

        public Node getFromNode() {
            return fromNode;
        }

        public void setFromNode(Node fromNode) {
            this.fromNode = fromNode;
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
        private boolean isVisited = false;
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

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
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
