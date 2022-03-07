import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    Deque<Integer> que;

    public MyStack() {
        que = new ArrayDeque<>();
    }

    public void push(int x) {
        que.offer(x);
    }

    public int pop() {
        int size = que.size();
        size--;
        while (size-- > 0){
            que.offer(que.peek());
            que.poll();
        }
        int x = que.poll();
        return x;

    }

    public int top() {
        return que.peekLast();
    }

    public boolean empty() {
        return que.isEmpty();
    }
}
