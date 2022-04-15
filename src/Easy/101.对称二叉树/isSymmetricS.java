import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isSymmetricS {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left, TreeNode right){
          if (left == null && right != null) {
              return false;
          } else if(left != null && right == null) {
              return false;
          } else if(left == null && right == null) {
              return true;
          } else if (left.val != right.val) {
              return false;
          }
          //左右节点都不为空，并且数据相同时
          boolean outside = compare(left.left,right.right);
          boolean inside = compare(left.right,right.left);
          boolean isSame = outside && inside;
          return isSame;
    }
//    boolean isSymmetric(TreeNode root) {
//        if (root == NULL) return true;
//        Queue<TreeNode> que;
//        que.push(root.left);   // 将左子树头结点加入队列
//        que.push(root.right);  // 将右子树头结点加入队列
//
//        while (!que.empty()) {  // 接下来就要判断这两个树是否相互翻转
//            TreeNode* leftNode = que.front(); que.pop();
//            TreeNode* rightNode = que.front(); que.pop();
//            if (!leftNode && !rightNode) {  // 左节点为空、右节点为空，此时说明是对称的
//                continue;
//            }
//
//            // 左右一个节点不为空，或者都不为空但数值不相同，返回false
//            if ((!leftNode || !rightNode || (leftNode->val != rightNode->val))) {
//                return false;
//            }
//            que.push(leftNode.left);   // 加入左节点左孩子
//            que.push(rightNode.right); // 加入右节点右孩子
//            que.push(leftNode.right);  // 加入左节点右孩子
//            que.push(rightNode.left);  // 加入右节点左孩子
//        }
//        return true;
//    }

}
