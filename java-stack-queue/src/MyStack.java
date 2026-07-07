
public class MyStack {
    public int[] elem;
    public int usedSize;
    MyStack() { // 栈的初始化
        elem = new int[]{1, 2, 3, 4};
        usedSize = elem.length;
    }
    public void push(int val) { // 默认相当于是尾插, 来入栈
        elem[usedSize] = val;
        ++usedSize;
    }
    public void pop() { // 出栈
        if (empty()) {
            System.out.println("当前栈为空，你的操作不合法！");
            return;
        }
        --usedSize;
    }
    // 判断栈是否为空, 空则返回true，非空则返回false
    public boolean empty() {
        if (usedSize == 0) return true;
        return false;
    }
    // 获取栈中元素的个数
    public int size() {
        return usedSize;
    }
    // 顺序打印当前栈中的所有元素
    public void printMyStack(){
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}
