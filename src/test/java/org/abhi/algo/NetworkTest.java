package org.abhi.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class NetworkTest {

    private Network.Node testNode;

    @Before
    public void setUp() throws Exception {
        testNode = Network.createNode("Test Node");
        Network.Node node1 = Network.createNode("Test_to_node1");
        Network.Node node2 = Network.createNode("Test_to_node2");
        Network.Node node3 = Network.createNode("node2_to_node3");
        Network.Node node4 = Network.createNode("node2_to_node4");
        Network.Node node5 = Network.createNode("node4_to_node5");

        Network.Link linkToNode1 = Network.createLink(1, testNode, node1);
        Network.Link linkToNode2 = Network.createLink(2, testNode, node2);
        Network.addLinkToNode(testNode, linkToNode1, linkToNode2);

        Network.Link linkToNode3 = Network.createLink(3, node2, node3);
        Network.Link linkToNode4 = Network.createLink(4, node2, node4);
        Network.addLinkToNode(node2, linkToNode3, linkToNode4);

        Network.Link linkToNode5 = Network.createLink(5, node4, node5);
        Network.addLinkToNode(node4, linkToNode5);

        Network.Link link5ToRoot = Network.createLink(6, node5, testNode);
        Network.addLinkToNode(node5, link5ToRoot);
    }

    @Test
    public void recursiveDepthFirstTravel() {
        Consumer<Network.Node> nodeConsumer = node ->System.out.println("Processing the node - " + node.getName());
        Network.recursiveDepthFirstTravel(testNode, nodeConsumer);
    }
}