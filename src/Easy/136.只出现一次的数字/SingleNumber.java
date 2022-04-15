/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName SingleNumber
 * @Description TODO
 * @data 2022/4/3 9:46
 */
public class SingleNumber {
  public int singleNumber(int[] nums) {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++){
      result ^= nums[i];
    }
    return result;
  }
}
