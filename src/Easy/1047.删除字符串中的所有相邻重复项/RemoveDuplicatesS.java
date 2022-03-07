import java.util.Stack;

public class RemoveDuplicatesS {
    public String removeDuplicates(String s) {
        Stack<Character> stackIn = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stackIn.isEmpty() || stackIn.peek() != ch)
                stackIn.push(ch);
            else
                stackIn.pop();
        }
        String str = "";
        while(!stackIn.isEmpty()){
            str = stackIn.pop() + str;
        }
        return str;
    }
    /*官方题解会更快但是内存消耗差不多
         StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
     */
}
