import java.util.ArrayList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname RestoreIpAddresses
 * @Description TODO
 * @date 2022/5/2 13:31
 */
public class RestoreIpAddresses {
  List<String> result = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    if (s.length() > 12) {
      return result;
    }
    restoreIpHelper(s,0,0);
    return result;
  }

  public void restoreIpHelper(String s, int index, int num) {
    if (num == 3) {
      if (isValid(s, index, s.length() - 1)) {
        result.add(s);
      }
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (isValid(s, index, i)) {
        s = s.substring(0,i + 1) + "." + s.substring(i + 1);
        num++;
        restoreIpHelper(s, i + 2, num);
        num--;
        s = s.substring(0, i + 1) + s.substring(i+2);
      }else {
        break;
      }
    }
  }

  /**
   * 判断是不是合法的地址码
   * 1.不能以0开头
   * 2.不能有非正整数
   * 3.不能大于255
   * @param s
   * @param index
   * @param end
   * @return
   */
  public boolean isValid(String s,int index,int end) {
    if (index > end) {
      return false;
    }
    if (s.charAt(index) == '0' && index != end) {
      return false;
    }
    int num = 0;
    for (int i = index; i <= end; i++) {
      if (s.charAt(i) > '9' || s.charAt(i) < '0') {
        return false;
      }
      num = num * 10 + (s.charAt(i) - '0');
      if (num > 255) {
        return false;
      }
    }

    return true;
  }
}
