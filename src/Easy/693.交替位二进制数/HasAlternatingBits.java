/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName HasAlternatingBits
 * @Description TODO
 * @data 2022/4/3 10:01
 */
public class HasAlternatingBits {
  public boolean hasAlternatingBits(int n) {
    while (n != 0) {
      if ((n & 3) == 3 || (n & 3) == 0) {
        return false;
      }
      n >>= 1;
    }
    return true;
  }
}
