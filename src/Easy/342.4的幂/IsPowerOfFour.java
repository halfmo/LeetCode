/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName IsPowerOfFour
 * @Description TODO
 * @data 2022/4/3 9:21
 */
public class IsPowerOfFour {
  public boolean isPowerOfFour(int n) {
    return (n > 0)  && (n & (n - 1)) == 0 && (n % 3 == 1);
  }
}
