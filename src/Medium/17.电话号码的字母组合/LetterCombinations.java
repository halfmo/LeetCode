import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname LetterCombinations
 * @Description TODO
 * @date 2022/4/19 9:49
 */
public class LetterCombinations {
  List<String> result = new LinkedList<>();
  StringBuilder temp = new StringBuilder();

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return result;
    }
    //定义每个数字键对应的字符组合
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //调用回溯方法
    letterCombinationsHelper(digits, numString, 0);
    return result;
  }

  /**
   *
   * @param digits 输入数组
   * @param numString 对应的字符
   * @param index 当前是第几个数字
   */
  public void letterCombinationsHelper(String digits, String[] numString, int index) {
    //当现在的数字是最后一个，即添加当前的字符串并返回当前的结果
    if (index == digits.length()) {
      result.add(temp.toString());
      return;
    }
    //获取当前第index个数字所对应的字符串组合
    String str = numString[digits.charAt(index) - '0'];
    //循环将不断的组合，循环三或四次
    for (int i = 0; i < str.length(); i++) {
      //将所对应的字符添加进字符串temp
      temp.append(str.charAt(i));
      //对下一个进行查找组合
      letterCombinationsHelper(digits, numString, index + 1);
      //在获取返回值后返回上一步
      temp.deleteCharAt(temp.length() - 1);
    }


  }
}
