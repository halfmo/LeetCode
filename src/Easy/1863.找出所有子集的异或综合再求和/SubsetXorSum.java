/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName SubsetXorSum
 * @Description TODO
 * @data 2022/4/3 10:09
 */
public class SubsetXorSum {
  public int subsetXORSum(int[] nums) {
    int sum = 0;
    int ans;
    for (int i = 0; i < (1 << nums.length); ++i) {
      ans = 0;
      for (int j = 0; j < nums.length; ++j) {
        if ((i & (1<< j)) != 0) {
          ans ^= nums[j];
        }
      }
      sum += ans;
    }
      return sum;
  }
}
