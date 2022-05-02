import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname Partition
 * @Description TODO
 * @date 2022/4/21 16:11
 */
public class Partition {
  List<List<String>> result = new LinkedList<>();
  Deque<String> path = new LinkedList<>();
  public List<List<String>> partition(String s) {

    partitionHelper(s,0);
    return result;
  }
  public void partitionHelper(String s, int index) {
    //若起始位置就大于字符串的长度的话就返回，也就是找到了一组合理的分割方案
    if (index >= s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index; i < s.length(); i++){
      //如果是回文子串记录
      if (isPalindrome(s, index, i)) {
        String str = s.substring(index, i + 1);
        path.addLast(str);
      }else {
        continue;
      }
      //递归并且回溯
      partitionHelper(s ,i + 1);
      path.removeLast();
    }
  }
  //判定是不是回文
  public boolean isPalindrome(String s, int index, int end) {
    for (int i = index, j = end; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)){
        return false;
      }
    }
    return true;
  }

}
