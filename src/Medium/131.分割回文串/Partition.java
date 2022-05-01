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
  LinkedList<String> path = new LinkedList<>();
  public List<List<String>> partition(String s) {

    partitionHelper(s,0);
    return result;
  }
  public void partitionHelper(String s, int index) {

  }
}
