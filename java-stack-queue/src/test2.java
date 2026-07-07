public class test2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(); // 初始化一个栈
        myStack.printMyStack();
        myStack.pop(); // 出栈
        System.out.println("====================");
        myStack.printMyStack();
        myStack.push(77); // 入栈
        System.out.println("====================");
        myStack.printMyStack();
        System.out.println("栈中的元素个数是：" + myStack.size());
    }
}