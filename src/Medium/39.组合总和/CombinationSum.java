import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname CombinationSum
 * @Description TODO
 * @date 2022/4/19 15:38
 */
public class CombinationSum {
  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    combinationSumHelper(candidates,target,0,0);
    return result;
  }
  public void combinationSumHelper(int[] candidates,int target,int index,int sum){
    //剪枝
    if (sum > target) {
       return;
    }
    if (sum == target) {
      result.add(new LinkedList<>(path));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (sum + candidates[i] > target) {
        break;
      }
      path.add(candidates[i]);
      combinationSumHelper(candidates,target,i,sum + candidates[i]);
      path.removeLast();
    }
  }
}
