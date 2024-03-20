package baitap.tree;

import baitap.Utility;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree
{
    Node root;

    public void addNode(int value)
    {
        this.root = addRecursive(this.root, value);
    }

    private Node addRecursive(Node current, int value)
    {
        if (current == null) //Base case, khi node là null thì khởi tạo node mới tại vị trí đó
            return new Node(value);

        if (value < current.value)//Nếu value truyền vào nhỏ hơn node hiện tại => Xét tiếp về bên trái
            current.left = addRecursive(current.left, value);
        else if (value > current.value)//Value > node hiện tại => Xét tiếp về bên phải
            current.right = addRecursive(current.right, value);
        else return current;//Giá trị đã tồn tại

        return current;//=> giá trị của node mới sẽ được set = node current.left hoặc current.right ở trên
    }

    public void traverseTree()
    {
        System.out.println("Nhập số để chọn cách duyệt cây");
        System.out.println("1. In Order: Node trái => Node hiện tại => Node phải");
        System.out.println("2. Pre Order: Node hiện tại => Node trái => Node phải");
        System.out.println("3. Post Order: Node trái => Node phải => Node hiện tại");
        System.out.println("4. Level Order: Duyệt từng tầng của cây");
        int choice = Integer.parseInt(Utility.scanner.nextLine());
        switch (choice)
        {
            case 1:
                traverseInOrder(root);
                break;
            case 2:
                traversePreOrder(root);
                break;
            case 3:
                traversePostOrder(root);
                break;
            case 4:
                traverseLevelOrder();
                break;
            default:
                break;
        }
    }

    public boolean findElement(int value)
    {   //Bắt đầu duyệt từ root node
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value)
    {
        if (current == null)//=> Đã chạy đến hết cây mà không tìm thấy
            return false;
        if (current.value == value)//Giá trị bằng nhau => Có tồn tại phần tử
            return true;

        return value > current.value //value > current.value => giá trị này có thể nằm ở right subtree
                ? containsRecursive(current.right, value)
                : containsRecursive(current.left, value);//Nếu không thì có thể là ở left subtree
    }

    public void deleteElement(int value)
    {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value)
    {
        if (current == null)//Chạy hết cây mà không tìm thấy
            return null;
        if (value == current.value)
        {   //Node lá => Chỉ cần set chính node này thành null
            if (current.left == null && current.right == null)
                return null;
            //Node chỉ có left subtree => set chính node này thành node left subtree của nó
            if (current.right == null)
                return current.left;
            //Node chỉ có right subtree => set chính node này thành node right subtree của nó
            if (current.left == null)
                return current.right;
            //Nếu tìm thấy node cần xóa mà có 2 node child => tìm giá trị nhỏ nhất của
            //right sub tree để thay thế vào node cần xóa => Đảm bảo tính chất của BST
            int smallestRightSubTreeValue = findSmallestRightNode(current.right);
            //Thay thế giá trị nhỏ nhất ở right subtree vào node cần xóa
            current.value = smallestRightSubTreeValue;
            //Xóa đi giá trị của node nhỏ nhất ở right sub tree để không bị trùng lặp giá trị nữa
            //lúc này gọi hàm deleteRecursive ở right sub tree của node hiện tại (node bị xóa)
            //sẽ chắc chắn tìm ra node nhỏ nhất ở right sub tree => Xóa nó
            // (node này chắc chắn là 1 node lá hoặc chỉ có 1 node right) => Đã có điều kiện ở trên
            current.right = deleteRecursive(current.right, smallestRightSubTreeValue);
            return current;//Sau khi thay thế và xóa xong node nhỏ nhất, trả về chính node hiện tại này
            //để gán lại giá trị cho các node ở trên => giá trị của root vẫn được giữ nguyên vì các node
            //bên dưới ngoại trừ node bị xóa đều được giữ nguyên giá trị
        }
        if (value > current.value)//Nếu > => tìm tiếp ở bên phải
        {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        current.left = deleteRecursive(current.left, value);//Không thì tìm ở bên trái
        return current;
    }

    private int findSmallestRightNode(Node current)
    {
        return current.left == null ? current.value : findSmallestRightNode(current.left);
    }

    //Depth-first search
    private void traverseInOrder(Node node)  //In-Order = left => root => right
    {                   //Phải có tham số node để gọi đệ quy
        if (node != null)//Khi gặp node null => Đã đi hết về bên trái của cây => Bắt đầu quay lại
        {
            traverseInOrder(node.left);//Liên tục đi về bên trái của node (duyệt bên trái)
            //Khi lời gọi hàm ở trên kết thúc => return lại đây thì bắt đầu in ra giá trị của node này
            //Node này chính là left subtree của node đã gọi hàm traverseInOrder(node.left) trước đó
            System.out.println(" " + node.value);
            //Sau khi đã đệ quy hết các node bên trái thì xét về bên phải
            //đây chính là gọi vào right subtree của node hiện tại
            traverseInOrder(node.right); //(duyệt bên phải)
        }
    }

    private void traversePreOrder(Node node)//Pre-Order = root => left => right
    {
        if (node != null)
        {
            System.out.println(" " + node.value);//Duyệt node hiện tại
            traversePreOrder(node.left);//Duyệt left-subtree
            traversePreOrder(node.right);//Duyệt right-subtree
        }
    }

    private void traversePostOrder(Node node)//Post-order = left => right => root
    {
        if (node != null)
        {
            traversePostOrder(node.left);//Duyệt left-subtree
            //khi duyệt hết left subtree thì ngay lập tức duyệt đến right subtree
            traversePostOrder(node.right);//Duyệt right-subtree
            //Khi đạt đến node null thì quay lại và in
            // ra value của node hiện tại, chính là left-subtree của node cao hơn
            // đã gọi hàm traversePostOrder(node.left) trước đó
            System.out.println(" " + node.value);
        }
    }

    //Breadth-first search
    private void traverseLevelOrder()
    {
        if (root == null)//Tránh null pointer
            return;
        //Có thể dùng linkedlist hoặc arraydequeue để lưu trữ dạng fifo theo insertion order
        Queue<Node> nodeList = new LinkedList<>();
        nodeList.add(root);//Thêm node root vào queue trước
        while (!nodeList.isEmpty())
        {   //liên tục lấy ra phần tử đầu tiên và đọc giá trị của nó
            Node tempNode = nodeList.poll();//lưu đệm node để đọc ra giá trị và duyệt các subtree
            //Ở vòng lặp đầu tiên sẽ in ra giá trị root node trước,
            //các vòng lặp tiếp theo sẽ liên tục thêm vào queue các
            //subtree của các node ở dưới, trong khi tiếp tục đọc ra từng node một theo thứ tự đã lưu
            System.out.println(" " + tempNode.value);
            //Các node sẽ được đọc từ trái sang phải theo từng level nhờ tính chất fifo của queue
            if (tempNode.left != null)
                nodeList.add(tempNode.left);
            if (tempNode.right != null)
                nodeList.add(tempNode.right);
        }
    }

    private class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value)
        {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
