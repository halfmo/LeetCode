import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValueS {
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
//    public int findBottomLeftValue(TreeNode root) {
//        if (root == null)
//            return 0;
//        int result = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode tempNode = queue.poll();
//                if (i == 0)
//                    result = tempNode.val;
//                if (tempNode.left != null) queue.offer(tempNode.left);
//                if (tempNode.right != null) queue.offer(tempNode.right);
//            }
//
//        }
//        return result;
//    }
    private int Deep = -1;
     private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }
    public void findLeftValue(TreeNode root, int deep){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (deep > Deep){
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep+1);
    }

}
