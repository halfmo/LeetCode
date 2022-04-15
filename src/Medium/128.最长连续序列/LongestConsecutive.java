import java.util.HashSet;
import java.util.Set;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname LongestConsecutive
 * @Description TODO
 * @date 2022/4/15 13:01
 */
public class LongestConsecutive {
  /**
   * 通过使用哈希表来解决
   * 时间复杂度为 n
   * @param nums 输入的数组
   * @return 返回最长连续数组长度
   */
  public int longestConsecutive(int[] nums) {
    //先使用了哈希来记录下存在的数字
    Set<Integer> numSet = new HashSet<Integer>();
    for (int num : nums) {
      numSet.add(num);
    }
    //结果
    int result = 0;
    //对于每个存在与哈希表中的数字，先查找是否存在有比这个数小一的，也就是是否有前缀
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        //若没有前缀，记录下当前的数字
        int currentNum = num;
        int currentStreak = 1;
        //若有后缀，则一直往后查。查到断开为止
        while (numSet.contains(currentNum + 1)) {
          currentNum += 1;
          currentStreak += 1;
        }
        result = Math.max(result,currentStreak);
      }
    }
    return result;
  }
}
