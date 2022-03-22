import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumS {
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
    List<List<Integer>> list;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new LinkedList<>();
        path = new LinkedList<>();
        travesal(root,targetSum);
        return list;
    }
    public void travesal(TreeNode root, int count){
        if (root == null)
            return ;
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0) {
            list.add(new LinkedList<>(path));
        }
        travesal(root.left, count);
        travesal(root.right, count);
        path.removeLast();
    }
}
