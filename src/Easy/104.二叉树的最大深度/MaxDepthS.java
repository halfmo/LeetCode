import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthS {
      class TreeNode {
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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                len--;
            }
            level++;
        }

        return level;
    }
}
