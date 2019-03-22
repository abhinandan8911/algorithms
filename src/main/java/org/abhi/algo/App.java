package org.abhi.algo;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        BigInteger resultFactorial = TailRecursiveFactorial.calculateFactorial(100);
//
//        System.out.println("Factorial Result is " + resultFactorial);

//        Integer resultFibonacci = TailRecursiveFibonacci.fibonacci(15);
//
//        System.out.println("Fibonacci Result is " + resultFibonacci);
//
//        BinaryTree.Node rootNode = BinaryTree.createBinaryTree(5);
//        rootNode.addNode(4);
//        rootNode.addNode(3);
//        rootNode.addNode(2);
//        rootNode.addNode(1);
//        rootNode.addNode(6);
//        rootNode.addNode(7);
//        rootNode.addNode(8);
//        rootNode.addNode(9);
//        rootNode.addNode(10);
//
//        System.out.println("Entire tree is - " + rootNode);
//
//        Consumer<Integer> nodeConsumer = value -> System.out.println("Node value is - " + value);
//        BinaryTree.printBinaryTree(nodeConsumer, BinaryTree.TraversalMode.DEPTHFIRST);
//
//        BinaryTree.Node nodeFound = rootNode.findNode(3);
//        System.out.println("Found Node is - " + nodeFound);
//
//        System.out.println("Ascending Order - " + DecisionTree.sortedList(DecisionTree.list, true));
//        System.out.println("Descending Order - " + DecisionTree.sortedList(DecisionTree.list, false));
//        System.out.println("Integer Difference - " + DecisionTree.absIntegerDifference(new Integer(99), new Integer(100)));
//
//        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4 , 5, 5);
//        DecisionTree.divideListToTwoEqualSets(list);
//        DecisionTree.printSets();

//        Integer[] inputArray = new Integer[] {5, 4, 3, -5, -4, -3, 1, 2, 3, 4, 5};
//        List<Integer> largestList = DecisionTree.partitionBasedOnTarget(5, inputArray);
//        System.out.println("The largest list is : " + DecisionTree.printList(largestList));

        List<Integer> maxContigousList = Subsets.maxContiguousSum(-2, 1, -3, 4, -1, 2, 1, -5);
        System.out.println("The Max Contigous subset is : " + ListUtilities.printList(maxContigousList));

        List<Integer> targettedSubsetImproved = Subsets.partitionBasedOnTarget(0,-2, 1, -3, 4, -1, 2, 1, -5);
        System.out.println("The targetted subset improved is : " + ListUtilities.printList(targettedSubsetImproved));

        List<List<Integer>> subsets = Subsets.getContiguousSubsets(1, 2, 3);
        subsets.forEach(subset -> System.out.println("Subsets are : " + ListUtilities.printList(subset)));
        System.out.println("Subset count is : " + subsets.size());
    }
}
