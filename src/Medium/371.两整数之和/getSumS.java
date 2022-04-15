/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName getSumS
 * @Description TODO
 * @data 2022/4/3 8:56
 */
public class getSumS {
  @SuppressWarnings("checkstyle:WhitespaceAround")
  public int getSum(int a, int b) {
    while (b != 0) {
      int carry = (a & b) << 1;
      a = a ^ b;
      b = carry;
    }
    return a;
  }
}
