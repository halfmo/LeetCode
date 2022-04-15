/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname CountNumbersWithUniqueDigits
 * @Description TODO
 * @date 2022/4/11 13:35
 */
public class CountNumbersWithUniqueDigits {

  /**
   * 统计各位数字都不同的数字个数
   * @param n 输入数据
   * 0 <= n <= 8 ; 0 <= x < 10^n
   * @return 返回 res 也就是
   */
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 10;
    }
    int res = 10, cur = 9;
    for (int i = 0; i < n - 1; i++) {
      cur *= 9 - i;
      res += cur;
    }
    return res;
  }
}
