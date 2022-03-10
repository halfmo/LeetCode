
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NlevelOrderS {
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
    /*
    和一般的层序遍历差不多
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listN = new ArrayList<>();
        if (root == null)
            return listN;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> qlist = new ArrayList<>();
            int len = queue.size();
            while (len > 0){
                Node tempnode = queue.poll();
                qlist.add(tempnode.val);
                int childlen = tempnode.children.size();
                for (int i = 0; i < childlen; i++) {
                    queue.add(tempnode.children.get(i));
                }
                len--;
            }
        listN.add(qlist);

        }
        return listN;
    }
}
