import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderS {
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
    //先新建一个List对象用于存储所有的层节点集合（是集合的集合
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelo(root);
        return list;
    }

    //使用队列来协助解决问题
    public void levelo(TreeNode root){
        if (root == null){//节点为空的情况直接返回
            return;
        }
        //使用一个队列来存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            //使用List对象来存储每一层的节点的值
            List<Integer> qlist = new ArrayList<>();
            int len = queue.size();
            //每次循环将弹出最前的节点，并且将该节点的数值赋予List对象进行存储，再填入左右节点
            //每一次循环一层
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
