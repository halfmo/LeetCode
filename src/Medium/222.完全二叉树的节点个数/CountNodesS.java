import java.util.LinkedList;
import java.util.Queue;

public class CountNodesS {
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
  //递归
//    public int countNodes(TreeNode root) {
//        return count(root);
//    }
//    public int count(TreeNode root){
//        if (root == null){
//            return 0;
//        }
//        int leftNum = count(root.left);
//        int rightNum = count(root.right);
//        int treeNum = leftNum + rightNum + 1;
//        return treeNum;
//    }

    //层序遍历
//    public int countNodes(TreeNode root) {
//         if (root == null){
//             return 0;
//         }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int num = 0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size -- > 0){
//                TreeNode temp = queue.poll();
//                num++;
//                if (temp.left != null)
//                    queue.offer(temp.left);
//                if (temp.right != null)
//                    queue.offer(temp.right);
//            }
//        }
//        return num;
//    }
    public int countNodes(TreeNode root){
         if (root == null)
             return 0;
         int leftDepth = getDepth(root.left);
         int rightDepth = getDepth(root.right);
         if (leftDepth == rightDepth){
             return (1 << leftDepth) + countNodes(root.right);
         }else {
             return (1 << rightDepth) + countNodes(root.left);
         }
    }
    public int getDepth(TreeNode root){
         int depth = 0;
         while(root != null){
             root = root.left;
             depth++;
         }
         return depth;
    }

}
