import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversalS {
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
    /*
    递归法
     */
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inoder(result, root);
        return result;
    }
    public void inoder(List<Integer> result, TreeNode root){
        if (root == null)
            return;
        inoder(result, root.left);
        result.add(root.val);
        inoder(result, root.right);
    }*/
    //迭代遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
