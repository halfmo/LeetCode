/**
 * @author half_m
 * @Package PACKAGE_NAME
 * @ClassName SwapNumbers
 * @Description TODO
 * @data 2022/4/3 9:42
 */
public class SwapNumbers {
  public int[] swapNumbers(int[] numbers) {
    numbers[0] = numbers[0] ^ numbers[1];
    numbers[1] = numbers[0] ^ numbers[1];
    numbers[0] = numbers[0] ^ numbers[1];
    return numbers;
  }
}
