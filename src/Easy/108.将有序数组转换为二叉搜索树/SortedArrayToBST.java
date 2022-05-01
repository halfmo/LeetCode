import java.util.LinkedList;
import java.util.Queue;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname SortedArrayToBST
 * @Description TODO
 * @date 2022/4/18 9:33
 */
public class SortedArrayToBST {
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
   * 迭代
   * @param nums
   * @return
   */
  public TreeNode sortedArrayToBSTx(int[] nums) {
    return sortedArray(nums, 0, nums.length);
  }
  public TreeNode sortedArray(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }
    if (right - left == 1) {
      return new TreeNode(nums[left]);
    }
    int mid = left + (right - left)/2;
    TreeNode temp = new TreeNode(nums[mid]);
    temp.left = sortedArray(nums, left, mid);
    temp.right = sortedArray(nums, mid+1, right);
    return temp;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    //根节点初始化
    TreeNode root = new TreeNode(-1);
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<Integer> leftQueue = new LinkedList<>();
    Queue<Integer> rightQueue = new LinkedList<>();

    // 根节点入队列
    nodeQueue.offer(root);
    // 0为左区间下标初始位置
    leftQueue.offer(0);
    // nums.size() - 1为右区间下标初始位置
    rightQueue.offer(nums.length - 1);

    while (!nodeQueue.isEmpty()) {
      TreeNode currNode = nodeQueue.poll();
      int left = leftQueue.poll();
      int right = rightQueue.poll();
      int mid = left + ((right - left) >> 1);

      // 将mid对应的元素给中间节点
      currNode.val = nums[mid];

      // 处理左区间
      if (left <= mid - 1) {
        currNode.left = new TreeNode(-1);
        nodeQueue.offer(currNode.left);
        leftQueue.offer(left);
        rightQueue.offer(mid - 1);
      }

      // 处理右区间
      if (right >= mid + 1) {
        currNode.right = new TreeNode(-1);
        nodeQueue.offer(currNode.right);
        leftQueue.offer(mid + 1);
        rightQueue.offer(right);
      }
    }
    return root;
  }
}
