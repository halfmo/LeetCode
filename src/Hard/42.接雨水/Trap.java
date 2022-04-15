/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname Trap
 * @Description TODO
 * @date 2022/4/10 7:59
 */
public class Trap {
  /**
   要看能接多少水，可以看这个点的左右两边的最高位中的小的一边
   */
  public int trap(int[] height) {
    int max = 0;
    int size = height.length;
    for (int i = 0; i < size - 1; i++) {
      int maxLeft = 0, maxRight = 0;
      for (int j = i; j >= 0; j--) {
        maxLeft = Math.max(maxLeft, height[j]);
      }
      for (int j = i; j < size; j++) {
        maxRight = Math.max(maxRight, height[j]);
      }
      max += Math.min(maxLeft, maxRight) - height[i];
    }
    return max;
  }
}
