import java.util.ArrayList;

public class LongestPath {

    static class Node {
        Node left;
        Node right;
        int data;
    };

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public static void main(String[] args) {

        Node root = newNode(100);

        root.left = newNode(20);
        root.right = newNode(130);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.right.left = newNode(110);
        root.right.right = newNode(140);
        root.left.left.left = newNode(5);

        ArrayList<Integer> ans = FindPath(root);

        System.out.println(ans);
    }

    public static ArrayList<Integer> FindPath(Node root) {
        if (root == null) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            return arr;
        }

        ArrayList<Integer> rightNode = FindPath(root.right);
        ArrayList<Integer> leftNode = FindPath(root.left);

        if (rightNode.size() < leftNode.size()) {
            leftNode.add(root.data);
        } else {
            rightNode.add(root.data);
        }

        return (leftNode.size() > rightNode.size() ? leftNode : rightNode);

    }
}
