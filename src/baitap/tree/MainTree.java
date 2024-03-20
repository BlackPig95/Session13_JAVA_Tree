package baitap.tree;

public class MainTree
{
    public static void main(String[] args)
    {
        Tree treeTest = new Tree();
        treeTest.addNode(50);
        treeTest.addNode(101);
        treeTest.addNode(35);
        treeTest.addNode(34);
        treeTest.addNode(40);
        treeTest.addNode(53);
        treeTest.addNode(25);
        treeTest.addNode(55);
        treeTest.addNode(52);
        treeTest.traverseTree();
        System.out.println(treeTest.findElement(40));
        System.out.println(treeTest.findElement(10000));
        treeTest.deleteElement(35);
        treeTest.deleteElement(1000);
        treeTest.traverseTree();
    }
}
