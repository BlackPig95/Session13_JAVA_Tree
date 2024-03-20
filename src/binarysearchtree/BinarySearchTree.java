package binarysearchtree;

public class BinarySearchTree
{
    Node root;

    private Node addRecursive(Node current, int value)
    {
        if (current == null)// Node gốc
        {
            return new Node(value);//Thêm mới Node và trả về chính Node đó
        }
        if (value < current.value)
        {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value)
        {
            current.right = addRecursive(current.right, value);
        } else
        {
            return current;
        }
        return current;
    }

    private boolean searchRecursive(Node current, int value)
    {
        if (current == null)
            return false;
        if (current.value == value)
            return true;
        return current.value > value
                ? searchRecursive(current.left, value)
                : searchRecursive(current.right, value);
    }

    public void add(int value)
    {
        this.root = addRecursive(root, value);
    }

    public boolean contains(int value)
    {
        return searchRecursive(root, value);
    }
}
