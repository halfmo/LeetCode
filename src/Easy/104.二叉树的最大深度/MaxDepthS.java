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
    //递归方式
//    public int maxdepth(TreeNode root){
//          if (root == null){
//              return 0;
//          }
//          int leftdepth = maxdepth(root.left);
//          int rightdepth = maxdepth(root.right);
//          return Math.max(leftdepth,rightdepth)+1;
//
//    }

    /*
    int result;
    void getDepth(TreeNode node, int depth){
        result = depth > result? depth : result;//中

        if(node.left == null && node.right == null) return;
        if(node.left){
            depth++;
            getDepth(node.left,depth);
            depth--;
        }
        if(node.right){
            depth++;
            getDepth(node.right, depth);
            depth--;
        }
        return ;
    }
    int maxDepth(TreeNode* root) {
        result = 0;
        if (root == NULL) return result;
        getDepth(root, 1);
        return result;
    }
};
     */
}
