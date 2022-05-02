import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname Subsets
 * @Description TODO
 * @date 2022/5/2 14:38
 */
public class Subsets {

  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) {
      result.add(new ArrayList<>());
      return result;
    }
    subsetsHelper(nums, 0);
    return result;
  }

  public void subsetsHelper(int[] nums, int index) {
    result.add(new LinkedList<>(path));
    if (index >= nums.length) {
      return;
    }
    for (int i = index; i < nums.length; i++) {
      path.add(nums[i]);
      subsetsHelper(nums, i + 1);
      path.removeLast();
    }
  }
}
