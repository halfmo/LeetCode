import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname FindMode
 * @Description TODO
 * @date 2022/4/10 8:57
 */
public class FindMode {

  static class TreeNode {
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

  List<Integer> list;
  public int maxCount;
  public int count;
  TreeNode pre;

  /**
   *
   * @param root x
   * @return  xx
   */
  public int[] findMode(TreeNode root) {
    list = (List<Integer>) new ArrayList<Integer>();
    maxCount = 0;
    count = 0;
    pre = null;
    findModex(root);
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }

  /**
   * 递归函数用于求出众数，反复与前一个元素对比，如果不同就为一，相同就自增。
   * 在每一次元素对比后会对最多数的数量和当前的数出现的次数做比较，如果当前的更大就清除list中的数据，再填；如果都一样大就加一个
   * @param root 传参
   */
  public void findModex(TreeNode root) {
    if (root == null) {
      return;
    }
    findModex(root.left);
    int rootValue = root.val;

    if (pre == null || rootValue != pre.val) {
      count = 1;
    }else {
      count++;
    }
    if (count > maxCount) {
      list.clear();
      list.add(rootValue);
      maxCount = count;
    }else if (count == maxCount) {
      list.add(rootValue);
    }
    pre = root;
    findModex(root.right);
  }
  /** 迭代
   * class Solution {
   *     public int[] findMode(TreeNode root) {
   *         TreeNode pre = null;
   *         Stack<TreeNode> stack = new Stack<>();
   *         List<Integer> result = new ArrayList<>();
   *         int maxCount = 0;
   *         int count = 0;
   *         TreeNode cur = root;
   *         while (cur != null || !stack.isEmpty()) {
   *             if (cur != null) {
   *                 stack.push(cur);
   *                 cur =cur.left;
   *             }else {
   *                 cur = stack.pop();
   *                 // 计数
   *                 if (pre == null || cur.val != pre.val) {
   *                     count = 1;
   *                 }else {
   *                     count++;
   *                 }
   *                 // 更新结果
   *                 if (count > maxCount) {
   *                     maxCount = count;
   *                     result.clear();
   *                     result.add(cur.val);
   *                 }else if (count == maxCount) {
   *                     result.add(cur.val);
   *                 }
   *                 pre = cur;
   *                 cur = cur.right;
   *             }
   *         }
   *         return result.stream().mapToInt(Integer::intValue).toArray();
   *     }
   * }
   */
}
