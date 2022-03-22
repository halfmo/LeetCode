import java.util.Stack;

public class isValidBST {
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
//    TreeNode max;
//    public boolean isValidBST(TreeNode root) {
//        if (root == null)
//            return true;
//
//        boolean left = isValidBST(root.left);
//        if (!left){
//            return false;
//        }
//        if (max != null && root.val <= max.val)
//            return false;
//        max = root;
//        boolean right = isValidBST(root.right);
//        return right;
//
//    }
    /* 简洁版递归
    public boolean isValidBST(TreeNode root){
      return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    boolean validBST(long lower, long upper, TreeNode root){
        if (root == null)
            return true;
        if (root.val <= lower || root.val >= upper)
            return false;
        return validBST(lower,root.val,root.left) && validBST(root.val,upper,root.right);
    }
     */

//    public boolean isValidBST(TreeNode root){
//        if (root == null)
//            return true;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode pre = null;
//        while (root != null || !stack.isEmpty()){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            TreeNode pop = stack.pop();
//            if (pre != null && pop.val <= pre.val){
//                return false;
//            }
//            pre = pop;
//            root = pop.right;
//        }
//        return true;
//
//    }
    private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= prev)
            return false;
        prev = root.val;
        return isValidBST(root.right);
    }
}
