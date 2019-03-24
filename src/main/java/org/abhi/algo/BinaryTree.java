package org.abhi.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTree {

    private static Node rootNode = null;

    public enum TraversalMode {
        PREORDER, INORDER, POSTORDER, DEPTHFIRST
    }

    public static Node createBinaryTree(Integer nodeValue) {
        rootNode = new Node(nodeValue);
        return rootNode;
    }

    public static void addNode(Integer nodeValue) {
        addNodeHelper(nodeValue, rootNode);
    }

    public static Node findNode(Integer nodeValue) {
        return findNodeHelper(nodeValue, rootNode);
    }

    public static void preOrderTraversal(Consumer<Integer> action) {
        preOrderTraversalHelper(action, rootNode);
    }

    public static void postOrderTraversal(Consumer<Integer> action) {
        postOrderTraversalHelper(action, rootNode);
    }

    public static void inOrderTraversal(Consumer<Integer> action) {
        inOrderTraversalHelper(action, rootNode);
    }

    public static void depthFirstTraversal(Consumer<Integer> action) {
        depthFirstTraversalHelper(action, rootNode);
    }

    public static void printBinaryTree(Consumer<Integer> nodeConsumer, TraversalMode traversalMode) {

        switch (traversalMode) {
            case INORDER:
                inOrderTraversal(nodeConsumer);
                break;
            case PREORDER:
                preOrderTraversal(nodeConsumer);
                break;
            case POSTORDER:
                postOrderTraversal(nodeConsumer);
                break;
            case DEPTHFIRST:
                depthFirstTraversal(nodeConsumer);
                break;
            default:
                throw new IllegalArgumentException("Traversal Mode not implemented");
        }
    }

    private static void addNodeHelper(Integer nodeValue, Node startingNode) {
        if(nodeValue < startingNode.nodeValue) {
            if(isNull(startingNode.leftChild)) {
                startingNode.leftChild = new Node(nodeValue);
            }
            else {
                BinaryTree.addNodeHelper(nodeValue, startingNode.leftChild);
            }
        }
        else {
            if(isNull(startingNode.rightChild)) {
                startingNode.rightChild = new Node(nodeValue);
            }
            else {
                BinaryTree.addNodeHelper(nodeValue, startingNode.rightChild);
            }
        }
    }

    private static Node findNodeHelper(Integer nodeValue, Node startingNode) {
        if(startingNode.nodeValue == nodeValue) {
            return startingNode;
        }
        if(nodeValue < startingNode.nodeValue) {
            if(isNull(startingNode.leftChild)) {
                return null;
            }
            else {
                return BinaryTree.findNodeHelper(nodeValue, startingNode.leftChild);
            }
        }
        else {
            if(isNull(startingNode.rightChild)) {
                return null;
            }
            else {
                return BinaryTree.findNodeHelper(nodeValue, startingNode.rightChild);
            }
        }
    }

    private static void preOrderTraversalHelper(Consumer<Integer> action, Node startingNode) {
        action.accept(startingNode.nodeValue);
        if(nonNull(startingNode.leftChild)) {
            BinaryTree.preOrderTraversalHelper(action, startingNode.leftChild);
        }
        if(nonNull(startingNode.rightChild)) {
            BinaryTree.preOrderTraversalHelper(action, startingNode.rightChild);
        }
    }

    private static void postOrderTraversalHelper(Consumer<Integer> action, Node startingNode) {
        if(nonNull(startingNode.leftChild)) {
            BinaryTree.postOrderTraversalHelper(action, startingNode.leftChild);
        }
        if(nonNull(startingNode.rightChild)) {
            BinaryTree.postOrderTraversalHelper(action, startingNode.rightChild);
        }
        action.accept(startingNode.nodeValue);
    }

    private static void inOrderTraversalHelper(Consumer<Integer> action, Node startingNode) {
        if(nonNull(startingNode.leftChild)) {
            BinaryTree.inOrderTraversalHelper(action, startingNode.leftChild);
        }
        action.accept(startingNode.nodeValue);
        if(nonNull(startingNode.rightChild)) {
            BinaryTree.inOrderTraversalHelper(action, startingNode.rightChild);
        }
    }

    private static void depthFirstTraversalHelper(Consumer<Integer> action, Node startingNode) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(startingNode);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            action.accept(node.nodeValue);
            if(nonNull(node.leftChild)) {
                nodeQueue.offer(node.leftChild);
            }
            if(nonNull(node.rightChild)) {
                nodeQueue.offer(node.rightChild);
            }
        }
    }

    public static class Node {
        final Integer nodeValue;
        Node leftChild;
        Node rightChild;

        public Node(Integer nodeValue) {
            this.nodeValue = nodeValue;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "nodeValue=" + nodeValue +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

}
