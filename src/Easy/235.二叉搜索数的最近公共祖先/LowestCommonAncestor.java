/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname LowestCommonAncestor
 * @Description TODO
 * @date 2022/4/11 13:41
 */

public class LowestCommonAncestor {
   class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  /**
   * 递归
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }

  /**
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (root.val > p.val && root.val > q.val) {
        root = root.left;
      }else if (root.val < p.val && root.val < q.val) {
        root = root.right;
      }else {
        break;
      }
    }
    return root;
  }
}
