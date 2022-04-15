/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname NumberOfLines
 * @Description TODO
 * @date 2022/4/15 12:52
 */
public class NumberOfLines {
  public int[] numberOfLines(int[] widths, String s) {
    int length=0;
    int maxLength=100;
    int high=1;
    for (int i=0; i < s.length(); i++){
      int temp=widths[s.charAt(i) - 'a'];
      length+=temp;
      if (length>maxLength){
        length=temp;
        high++;
      }

    }
    int[] res={high,length};
    return res;
  }
}
