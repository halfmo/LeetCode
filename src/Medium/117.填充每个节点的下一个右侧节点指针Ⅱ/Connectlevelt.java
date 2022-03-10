import java.util.LinkedList;
import java.util.Queue;

public class Connectlevelt {
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
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node node = null;
            Node nodepre = null;
            for (int i = 0; i < size; i++){
                if (i == 0){
                    nodepre = queue.poll();// 取出本层头一个节点
                    node = nodepre;
                }else {
                    node = queue.poll();
                    nodepre.next = node;// 本层前一个节点 next 指向当前节点
                    nodepre = nodepre.next;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            nodepre.next = null;// 本层最后一个节点 next 指向 null
        }
        return root;
    }
}
