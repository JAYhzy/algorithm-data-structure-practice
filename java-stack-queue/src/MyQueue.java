import java.util.Stack;

/**
 * 用栈实现队列，力扣上的题目
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                int tmp = s1.pop();
                s2.push(tmp);
            }
            return s2.pop();
        }
        else {
            return s2.pop();
        }
    }
    
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                int tmp = s1.pop();
                s2.push(tmp);
            }
            return s2.peek();
        }
        else {
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
