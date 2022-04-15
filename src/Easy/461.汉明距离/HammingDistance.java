/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName HammingDistance
 * @Description TODO
 * @data 2022/4/3 9:52
 */
public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int z = x ^ y;
    int c = 0;
    while (z != 0) {
      z &= (z - 1);
      ++c;
    }
    return c;
  }
}
