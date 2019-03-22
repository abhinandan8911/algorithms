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

    public static void printBinaryTree(Consumer<Integer> nodeConsumer, TraversalMode traversalMode) {

        switch (traversalMode) {
            case INORDER:
                rootNode.inOrderTraversal(nodeConsumer, rootNode);
                break;
            case PREORDER:
                rootNode.preOrderTraversal(nodeConsumer, rootNode);
                break;
            case POSTORDER:
                rootNode.postOrderTraversal(nodeConsumer, rootNode);
                break;
            case DEPTHFIRST:
                rootNode.depthFirstTraversal(nodeConsumer, rootNode);
                break;
            default:
                throw new IllegalArgumentException("Traversal Mode not implemented");
        }
    }

    public static class Node {
        final Integer nodeValue;
        Node leftChild;
        Node rightChild;

        public Node(Integer nodeValue) {
            this.nodeValue = nodeValue;
        }

        public void addNode(Integer nodeValue) {
            if(nodeValue < this.nodeValue) {
                if(isNull(leftChild)) {
                    leftChild = new Node(nodeValue);
                }
                else {
                    leftChild.addNode(nodeValue);
                }
            }
            else {
                if(isNull(rightChild)) {
                    rightChild = new Node(nodeValue);
                }
                else {
                    rightChild.addNode(nodeValue);
                }
            }
        }

        public Node findNode(Integer nodeValue) {
            if(this.nodeValue == nodeValue) {
                return this;
            }
            if(nodeValue < this.nodeValue) {
                if(isNull(leftChild)) {
                    return null;
                }
                else {
                    return leftChild.findNode(nodeValue);
                }
            }
            else {
                if(isNull(rightChild)) {
                    return null;
                }
                else {
                    return rightChild.findNode(nodeValue);
                }
            }
        }

        public void preOrderTraversal(Consumer<Integer> action, Node startingNode) {
            action.accept(startingNode.nodeValue);
            if(nonNull(startingNode.leftChild)) {
                startingNode.leftChild.preOrderTraversal(action, startingNode.leftChild);
            }
            if(nonNull(startingNode.rightChild)) {
                startingNode.rightChild.preOrderTraversal(action, startingNode.rightChild);
            }
        }

        public void postOrderTraversal(Consumer<Integer> action, Node startingNode) {
            if(nonNull(startingNode.leftChild)) {
                startingNode.leftChild.postOrderTraversal(action, startingNode.leftChild);
            }
            if(nonNull(startingNode.rightChild)) {
                startingNode.rightChild.postOrderTraversal(action, startingNode.rightChild);
            }
            action.accept(startingNode.nodeValue);
        }

        public void inOrderTraversal(Consumer<Integer> action, Node startingNode) {
            if(nonNull(startingNode.leftChild)) {
                startingNode.leftChild.inOrderTraversal(action, startingNode.leftChild);
            }
            action.accept(startingNode.nodeValue);
            if(nonNull(startingNode.rightChild)) {
                startingNode.rightChild.inOrderTraversal(action, startingNode.rightChild);
            }
        }

        public void depthFirstTraversal(Consumer<Integer> action, Node startingNode) {
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
