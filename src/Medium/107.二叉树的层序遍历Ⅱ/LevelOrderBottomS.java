import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottomS {
      class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {};
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
      }

      /*
        107的层序遍历其实就是在102的层序遍历代码的基础上添加了一行
        Collections.reverse()，使用了这个方法，将102中的从上至下的遍历结果进行反转
        便可以得到自底向上的层序遍历结果
       */
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelo(root);
        Collections.reverse(list);
        return list;
    }

    //使用队列
    public void levelo(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> qlist = new ArrayList<>();
            int len = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                qlist.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                len--;
            }
            list.add(qlist);
        }
    }
}
