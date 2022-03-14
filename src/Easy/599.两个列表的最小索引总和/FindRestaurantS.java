import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurantS {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {//使用哈希表来记录list1中出现的字符串
            map.put(list1[i],i);
        }
        List<String> list = new ArrayList<>();//保存结果
        int indexSum = Integer.MAX_VALUE;//添加索引值
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])){//若存在有相同的字符串（键
                int j = map.get(list2[i]);
                if (i + j < indexSum){//第一次，小于索引值就清空填入
                    list.clear();
                    list.add(list2[i]);
                    indexSum = i + j;
                }else if (i + j == indexSum){//等于索引值填入
                    list.add(list2[i]);
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
