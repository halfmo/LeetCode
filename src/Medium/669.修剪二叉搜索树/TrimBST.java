/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname TrimBST
 * @Description TODO
 * @date 2022/4/18 9:02
 */
public class TrimBST {
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

  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null ) {
      return null;
    }
    if (root.val < low) {
      TreeNode right = trimBST(root.right, low, high);
      return right;
    }
    if (root.val > high) {
      TreeNode left = trimBST(root.left, low, high);
      return left;
    }
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    return root;
  }
}
