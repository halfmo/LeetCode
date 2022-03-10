import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideViewS {
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
  使用广度优先搜素算法将每一层的最后一个元素记录
   */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null)
            return list;
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int levelSize = deque.size();

            for (int i = 0; i < levelSize; i++){
                TreeNode tempNode = deque.poll();
                if (tempNode.left != null)
                    deque.addLast(tempNode.left);
                if (tempNode.right != null)
                    deque.addLast(tempNode.right);
                if (i == levelSize - 1)
                    list.add(tempNode.val);
            }
        }
        return list;
    }
}
