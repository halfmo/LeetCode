import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname SubsetsWithDup
 * @Description TODO
 * @date 2022/5/2 16:05
 */
public class SubsetsWithDup {

  List<List<Integer>> result = new LinkedList<>();
  LinkedList<Integer> path = new LinkedList<>();
  boolean[] used;

  /**
   * 基本的判断 调用下面的方法
   * @param nums
   * @return
   */

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums.length == 0) {
      result.add(path);
      return result;
    }
    Arrays.sort(nums);
    used = new boolean[nums.length];
    subsertWithDupHelper(nums, 0);
    return result;
  }

  /**
   * 辅助递归类
   * @param nums
   * @param index
   */
  public void subsertWithDupHelper(int[] nums, int index) {
    result.add(new ArrayList<>(path));
    if (index >= nums.length) {
      return;
    }
    for (int i = index; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      path.add(nums[i]);
      used[i] = true;
      subsertWithDupHelper(nums, i + 1);
      path.removeLast();
      used[i] = false;
    }
  }
}
