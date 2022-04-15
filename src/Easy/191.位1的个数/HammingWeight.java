 /**
  * @author half_m
  * @Package PACKAGE_NAME
  * @ClassName HammingWeight
  * @Description TODO
  * @data 2022/4/3 9:25
  */
public class HammingWeight {
  /**
   * you need to treat n as an unsigned value
   */
  public int hammingWeight(int n) {
    int c = 0;
    while (n != 0) {
      n &= (n - 1);
      ++c;
    }
    return c;
  }
}
