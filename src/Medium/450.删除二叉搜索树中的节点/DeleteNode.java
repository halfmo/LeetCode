/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname DeleteNode
 * @Description TODO
 * @date 2022/4/15 13:52
 */
public class DeleteNode {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  /**
   * @param root
   * @param key
   * @return
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    //当该值不存在
    if (root == null) {
      return root;
    }
    //存在并找到
    if (root.val == key) {
      //当前节点的左子树为空
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        //右子树为空
        return root.left;
      } else {
        TreeNode cur = root.right;
        while (cur.left != null) {
          cur = cur.left;
        }
        cur.left = root.left;
        root = root.right;
        return root;
      }
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    }
    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    }
    return root ;
  }
}
