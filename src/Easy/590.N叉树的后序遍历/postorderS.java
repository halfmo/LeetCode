import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postorderS {
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
    public List<Integer> postorder(Node root) {
        //前序遍历为中左右，后序为左右中，可以将入栈的顺序调整为中右左再将输出的数组进行反转便可以
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            list.add(temp.val);
            int size = temp.children.size();
            for (int i = 0; i < size; i++) {
                stack.push(temp.children.get(i));
            }
        }
        Collections.reverse(list);

        return list;
    }
    /*
    官方递归
     */
//public List<Integer> postorder(Node root) {
//    List<Integer> res = new ArrayList<>();
//    helper(root, res);
//    return res;
//}
//
//    public void helper(Node root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        for (Node ch : root.children) {
//            helper(ch, res);
//        }
//        res.add(root.val);
//    }
    /*
    官方迭代

     */
//    class Solution {
//        public List<Integer> postorder(Node root) {
//            List<Integer> res = new ArrayList<Integer>();
//            if (root == null) {
//                return res;
//            }
//            Map<Node, Integer> map = new HashMap<Node, Integer>();
//            Deque<Node> stack = new ArrayDeque<Node>();
//            Node node = root;
//            while (!stack.isEmpty() || node != null) {
//                while (node != null) {
//                    stack.push(node);
//                    List<Node> children = node.children;
//                    if (children != null && children.size() > 0) {
//                        map.put(node, 0);
//                        node = children.get(0);
//                    } else {
//                        node = null;
//                    }
//                }
//                node = stack.peek();
//                int index = map.getOrDefault(node, -1) + 1;
//                List<Node> children = node.children;
//                if (children != null && children.size() > index) {
//                    map.put(node, index);
//                    node = children.get(index);
//                } else {
//                    res.add(node.val);
//                    stack.pop();
//                    map.remove(node);
//                    node = null;
//                }
//            }
//            return res;
//        }
//    }

}
