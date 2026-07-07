/**
 * 这里的队列是用数组来实现的，即是循环队列，在这个队列中因为要不断的出队和入队，所以表示对头的下标和表示队尾的下标都是在不断变化着的
 */
class MyCircularQueue {
    int[] elem;
    int front; // 表示队头的下标
    int rear; // 表示队尾的下标
/**
* 构造方法
* @param k K个大小
*/
public MyCircularQueue(int k) {
    elem = new int[k];
}

/**
* 入队
* @param value
* @return
*/
public boolean enQueue(int value) {
    if (isFull()) {
        return false;
    }
    else {
        elem[rear] = value;
        rear = (rear + 1) % elem.length; // 注意这里，防止数组越界
    }
    return true;

}

/**
* 出队
* @return
*/
public boolean deQueue() {
    if (isEmpty()) {
        return false;
    }
    else {
        front = (front + 1) % elem.length; // 数组的长度是有限的，注意不要让数组越界
    }
    return true;
}

/**
* 得到队头元素
* @return
*/
public int Front() {
    if (isEmpty()) {
        return -1;
    }
    return elem[front];
}

/**
* 得到队尾元素
* @return
*/
public int Rear() {
    if (isEmpty()) return -1;

    int index = rear == 0 ? elem.length - 1 : rear - 1;

    return elem[index];
}

/**
* 当前循环队列是否为空
* @return
*/
public boolean isEmpty() {
    if (rear == front) return true; // 他们相遇证明是空的
    return false;
}

/**
* 判断当前队列是否为满
* @return
*/
public boolean isFull() {
    if ((rear + 1) % elem.length == front) { // 空一个格子
        return true;
    }

    return false;
}
}


