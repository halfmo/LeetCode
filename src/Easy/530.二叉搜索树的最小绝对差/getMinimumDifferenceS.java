import java.util.Stack;

public class getMinimumDifferenceS {
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
//    TreeNode pre;
//    int result = Integer.MAX_VALUE;
//    public int getMinimumDifference(TreeNode root) {
//        if (root == null) return 0;
//        traversal(root);
//        return result;
//    }
//    public void traversal(TreeNode root){
//        if (root == null)return;
//        //左
//        traversal(root.left);
//        //中
//        if(pre != null){
//            result = Math.min(result, root.val - pre.val);
//        }
//        pre = root;
//        //右
//        traversal(root.right);
//    }
        TreeNode pre;
        Stack<TreeNode> stack;
        public int getMinimumDifference(TreeNode root) {
            if (root == null) return 0;
            stack = new Stack<>();
            TreeNode cur = root;
            int result = Integer.MAX_VALUE;
            while (cur != null || !stack.isEmpty()){
                if (cur != null){
                    stack.push(cur); //存入当前节点
                    cur = cur.left; //左
                }else {
                    cur = stack.pop();
                    if (pre != null){ //中
                        result = Math.min(result, cur.val - pre.val);
                    }
                    pre = cur;
                    cur = cur.right; //右
                }
            }
            return result;
        }
}
