/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname InsertIntoBST
 * @Description TODO
 * @date 2022/4/11 16:08
 */
public class InsertIntoBST {
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

  /**
   *
   * @param root
   * @param val
   * @return
   */
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      TreeNode node = new TreeNode(val);
      return node;
    }
    if (root.val > val) {
      root.left = insertIntoBST(root.left, val);
    } else if (root.val < val) {
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }

  /**
   *
   * @param root
   * @param val
   * @return
   */
  public TreeNode insertIntoBST2(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode newRoot = root;
    TreeNode pre = root;
    while (root != null) {
      pre = root;
      if (root.val > val) {
        root = root.left;
      }else if (root.val < val) {
        root = root.right;
      }
    }
    if (pre.val > val) {
      pre.left = new TreeNode(val);
    }else {
      pre.right = new TreeNode(val);
    }
    return newRoot;
  }
}
