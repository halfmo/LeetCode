import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class LargestValuesS {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null)
            return list;
        deque.offer(root);

        while (!deque.isEmpty()){
            int queSize = deque.size();
            List<Integer> vals = new ArrayList<>();

            while (queSize > 0){
                TreeNode tempNode = deque.poll();
                vals.add(tempNode.val);
                if (tempNode.left != null) deque.add(tempNode.left);
                if (tempNode.right != null) deque.add(tempNode.right);
                queSize--;
            }
            list.add(Collections.max(vals));
        }
        return list;
    }
}
