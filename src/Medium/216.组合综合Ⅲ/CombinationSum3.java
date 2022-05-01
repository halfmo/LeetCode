import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname CombinationSum3
 * @Description TODO
 * @date 2022/4/18 16:51
 */
public class CombinationSum3 {
  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();
  public List<List<Integer>> combinationSum3(int k, int n) {
    combinaHelper(n, k, 1,0);
    return result;
  }
  public void combinaHelper(int targetSum, int k, int startIndex,int sum) {
    //剪枝
    if (sum > targetSum) {
      return;
    }
    if (path.size() == k ) {
      if (sum == targetSum) {
        result.add(new LinkedList<>(path));
      }
      return;
    }
    //剪枝
    for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
      path.add(i);
      sum+=i;
      combinaHelper(targetSum, k, i + 1, sum);
      //回溯
      path.removeLast();
      sum-=i;
    }
  }
}
