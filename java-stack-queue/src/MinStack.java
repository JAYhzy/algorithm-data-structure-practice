import java.util.LinkedList;
import java.util.Stack;
// 最小栈的实现
class MinStack {
    Stack<Integer> s1;
    Stack<Integer> minStack;

    public MinStack() {
        s1 = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        s1.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        }
        else if (val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (s1.pop() == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        if (!minStack.empty()){
            return minStack.peek();
        }
        return -1;
    }
}