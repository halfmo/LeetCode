import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class averageOfLevelsS {
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
  和层序遍历类似，在层序遍历的基础上进行修改，添加一些用于记录和计算的值便可
   */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null)
            return list;
        deque.offerLast(root);

        while(!deque.isEmpty()){
            int levelsize = 0;
            Double average = 0.0;

            int queSize = deque.size();
            while (queSize > 0){
                TreeNode tempNode = deque.poll();
                levelsize++;
                average += tempNode.val;
                if(tempNode.left != null) deque.offer(tempNode.left);
                if (tempNode.right != null) deque.offer(tempNode.right);
                queSize--;
            }
            average = average/levelsize;
            list.add(average);
        }
        return list;
    }
}
