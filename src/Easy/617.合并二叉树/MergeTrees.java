import java.util.Stack;

public class MergeTrees {
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
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null) return root2;
//        if (root2 == null) return root1;
//        TreeNode root = new TreeNode(0);
//        root.val = root1.val + root2.val;
//        root.left = mergeTrees(root1.left,root2.left);
//        root.right = mergeTrees(root1.right,root2.right);
//        return root;
//    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 == null)
          return root2;
      if (root2 == null)
          return root1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while (!stack.isEmpty()){
            TreeNode temp1 = stack.pop();
            TreeNode temp2 = stack.pop();
            temp1.val += temp2.val;
            if (temp2.right != null && temp1.right != null){
                stack.push(temp2.right);
                stack.push(temp1.right);
            }else {
                if (temp1.right == null){
                    temp1.right = temp2.right;
                }
            }
            if (temp2.left != null && temp1.left != null){
                stack.push(temp2.left);
                stack.push(temp1.left);
            }else {
                if (temp1.left == null){
                    temp1.left = temp2.left;
                }
            }
        }
        return root1;
    }
}
