import java.util.Deque;
import java.util.LinkedList;

public class evalRPNS {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])){
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(tokens[i])){
                stack.push(-stack.pop() + stack.pop());
            }else if ("*".equals(tokens[i])){
                stack.push(stack.pop() * stack.pop());
            }else if ("/".equals(tokens[i])){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
