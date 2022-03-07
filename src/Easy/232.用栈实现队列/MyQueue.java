import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    int front;
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        if (stackIn.empty())
            front = x;
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()) stackOut.push(stackIn.pop());
        }
        return stackOut.pop();

    }

    public int peek() {
        if (!stackOut.isEmpty()) return stackOut.peek();
        return front;
    }

    public boolean empty() {
        return stackIn.isEmpty()&&stackOut.isEmpty();
    }
}