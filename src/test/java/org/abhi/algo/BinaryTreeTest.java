package org.abhi.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private Consumer<Integer> consumer = value -> System.out.println("The value is : " + value);

    @Before
    public void setUp() throws Exception {
        BinaryTree.createBinaryTree(5);
        BinaryTree.addNode(4);
        BinaryTree.addNode(3);
        BinaryTree.addNode(2);
        BinaryTree.addNode(6);
        BinaryTree.addNode(7);
        BinaryTree.addNode(8);
    }

    @Test
    public void addNode() {
       BinaryTree.addNode(1);
       BinaryTree.addNode(9);
       BinaryTree.printBinaryTree(consumer, BinaryTree.TraversalMode.INORDER);
    }

    @Test
    public void findNode() {
        assertNotNull(BinaryTree.findNode(2));
        assertNull(BinaryTree.findNode(100));
    }

    @Test
    public void preOrderTraversal() {
        BinaryTree.preOrderTraversal(consumer);
    }

    @Test
    public void postOrderTraversal() {
        BinaryTree.postOrderTraversal(consumer);
    }

    @Test
    public void inOrderTraversal() {
        BinaryTree.inOrderTraversal(consumer);
    }

    @Test
    public void depthFirstTraversal() {
        BinaryTree.depthFirstTraversal(consumer);
    }

    @Test
    public void printBinaryTree() {
        BinaryTree.printBinaryTree(consumer, BinaryTree.TraversalMode.DEPTHFIRST);
    }
}