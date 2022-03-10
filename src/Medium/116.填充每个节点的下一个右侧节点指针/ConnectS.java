import javax.print.DocFlavor;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConnectS {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {

        Queue<Node> deque = new LinkedList<>();
        if (root != null)
            deque.add(root);
        while (deque.size()!=0){
            int quesize = deque.size();
            Node tempnode = deque.poll();
            if (tempnode.left != null) deque.add(tempnode.left);
            if (tempnode.right != null) deque.add(tempnode.right);
            for (int i = 1; i < quesize; i++){
                Node next = deque.poll();
                if (next.left != null) deque.add(next.left);
                if (next.right != null) deque.add(next.right);
                tempnode.next = next;
                tempnode = next;
            }
        }
        return root;
    }
}
