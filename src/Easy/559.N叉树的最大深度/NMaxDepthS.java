import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NMaxDepthS {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();;
            while (len > 0){
                Node temp = queue.poll();
                int size = temp.children.size();
                for (int i = 0; i < size; i++) {
                    queue.offer(temp.children.get(i));
                }
                len--;
            }
            level++;
        }
        return level;
    }
}
