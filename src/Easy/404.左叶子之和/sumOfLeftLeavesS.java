import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class sumOfLeftLeavesS {
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
  //使用前序来进行修改
    public int sumOfLeftLeaves(TreeNode root) {
         int lsum = 0;
         if (root == null)
             return 0;
         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);
         while (!stack.isEmpty()){
             TreeNode node = stack.pop();
             if (node.left != null && node.left.left==null&&node.left.right==null) lsum+=node.left.val;
             if (node.right!= null)
                 stack.push(node.right);
             if (node.left != null){
                 stack.push(node.left);
             }
         }
         return lsum;
    }

    //递归
//        public int sumOfLeftLeaves(TreeNode root) {
//           return root != null ? dfs(root) : 0;
//        }
//        public int dfs(TreeNode root){
//            int ans = 0;
//            if (root.left != null){
//                ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
//            }
//            if (root.right != null){
//                ans += dfs(root.right);
//            }
//            return ans;
//        }
//        public boolean isLeafNode(TreeNode node){
//         return node.left == null && node.right == null;
//        }


}
