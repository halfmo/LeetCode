import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname CombinationSum2
 * @Description TODO
 * @date 2022/4/19 16:46
 */
public class CombinationSum2 {
  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    boolean[] flag = new boolean[candidates.length];
    combinationSum2Helper(candidates, target,0,0,flag);
    return result;
  }
  public void combinationSum2Helper(int[] candidates, int target, int index, int sum,boolean[] flag){

    if (sum == target) {
      result.add(new LinkedList<>(path));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (sum + candidates[i] > target) {
        break;
      }
      if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i-1]) {
        continue;
      }
      flag[i] =true;
      sum+=candidates[i];
      path.add(candidates[i]);
      combinationSum2Helper(candidates,target,i+1,sum,flag);
      path.removeLast();
      flag[i] = false;
      sum-=candidates[i];
    }
  }
}
