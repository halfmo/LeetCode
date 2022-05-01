/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname ConvertBST
 * @Description TODO
 * @date 2022/4/18 10:05
 */
public class ConvertBST {
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
   int sum;
  public TreeNode convertBST(TreeNode root) {
    sum = 0;
    convertBST1(root);
    return root;
  }
  public void convertBST1(TreeNode root) {
    if (root == null) {
      return;
    }
    convertBST1(root.right);
    sum+=root.val;
    root.val = sum;
    convertBST1(root.left);
  }
}
