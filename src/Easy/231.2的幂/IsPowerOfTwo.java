/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName IsPowerOfTwo
 * @Description TODO
 * @data 2022/4/3 9:10
 */


public class IsPowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    return (n > 0)&& (n & (n - 1) ) == 0;
  }
}
