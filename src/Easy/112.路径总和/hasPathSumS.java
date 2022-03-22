import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class hasPathSumS {
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
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null)
//            return false;
//        targetSum -= root.val;
//        if (root.left == null && root.right == null)
//            return targetSum == 0;
//        if (root.left != null){
//            boolean left = hasPathSum(root.left, targetSum);
//            if (left)
//                return true;
//        }
//        if (root.right != null){
//            boolean right = hasPathSum(root.right, targetSum);
//            if (right)
//                return true;
//        }
//        return false;
//    }

    /*
    public boolean hasPathSum(TreeNode root, int targetsum) {

        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetsum;

        // 求两侧分支的路径和
        return haspathsum(root.left, targetsum - root.val) || haspathsum(root.right, targetsum - root.val);
    }
     */
    public boolean hasPathSum(TreeNode root, int targetsum){
        if (root == null)
            return false;
        Queue<TreeNode> queue =new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queue.offer(root);
        queueVal.offer(root.val);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int tem = queueVal.poll();
            if (temp.left == null && temp.right ==null){
                if (tem == targetsum)
                    return true;
                continue;
            }
            if (temp.left != null) {
                queue.offer(temp.left);
                queueVal.offer(temp.left.val + tem);
            }
            if (temp.right != null){
                queue.offer(temp.right);
                queueVal.offer(temp.right.val + tem);
            }
        }
        return false;
    }
}
