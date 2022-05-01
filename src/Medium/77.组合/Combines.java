import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname Combines
 * @Description TODO
 * @date 2022/4/18 13:47
 */
public class Combines {
  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
    combineHelper(n, k, 1);
    return result;
  }
  /**
   * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
   * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
   */
  public void combineHelper(int n, int k, int startIndex) {

    //当path大小与要求的长度相符时，添加到结果集，再回溯
    if (path.size() == k){
      result.add(new LinkedList<>(path));
      return;
    }
    //k- path.size() 为当前还需要的个数
    for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
      path.add(i);
      combineHelper(n, k, i + 1);
      path.removeLast();
    }
  }

}
