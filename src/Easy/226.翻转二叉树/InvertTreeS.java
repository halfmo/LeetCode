import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InvertTreeS {
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
    public TreeNode invertTree(TreeNode root) {

         if (root == null) return root;
        //递归
//         swap(root);
//         invertTree(root.left);
//         invertTree(root.right);


        //迭代法
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                TreeNode temp = deque.poll();
                swap(temp);
                if (temp.left != null) deque.offer(temp.left);
                if (temp.right != null) deque.offer(temp.right);
            }
        }
         return root;
    }

    public void swap(TreeNode root){
         TreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;
    }
}
