import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postoderTraversalS {
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
    /*
    递归法
    */
    /*
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postoder(result, root);
        return result;
    }
    public void postoder(List<Integer> result,TreeNode root){
        if (root == null){
            return;
        }
        postoder(result, root.left);
        postoder(result, root.right);
        result.add(root.val);
    }
    */

    //迭代遍历

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //前序遍历为中左右，后序为左右中，可以将入栈的顺序调整为中右左再将输出的数组进行反转便可以
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}
