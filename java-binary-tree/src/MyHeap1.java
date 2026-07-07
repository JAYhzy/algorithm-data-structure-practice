/**
 * 用大根堆模拟实现优先级队列
 */
public class MyHeap1 {
    int[] elem;
    int usedSize; // 优先级队列中有效元素的个数
    MyHeap1() {
        elem = new int[10]; // 构造方法初始化一下
    }
    public void createHeap(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            elem[i] =arrays[i]; // 元素初始化
            ++usedSize;
        }
        // 注意这里是usdSize - 1 - 1,因为父亲结点的下标 = (孩子结点的下标 - 1） / 2，
        // 我们是从倒数的第一个非叶子节点的子树开始调节的，而该子树的孩子结点坐标为usedSize - 1
        for (int i = (usedSize - 1 - 1) / 2; i >= 0 ; --i) {
            shiftDown(i); // 从下面的子树一直调到上面的子树
        }
    }

    /**
     * 向下调整——使得当前子树为大根堆
     * @param root 是每棵子树的根结点的下标
     * 向下调整的时间复杂度O(log2n)（最坏情况下就是树的高度）
     */
    public void shiftDown(int root) {
        int parent = root; // 父亲结点的坐标
        int child = 2 * parent + 1; // 获取左孩子结点的坐标
        // 为什么不能child下标要小于usedSize,因为当前数组的最大下标就是usedSize - 1,如果大于或等于usedSize就越界了
        while (child < usedSize) { // 每个子树在调整的时候，是按从上到下，当child的下标小于usedSize时候就结束
            // 这一步目的是找出孩子结点最大的那个值，然后在让该值和父亲结点比较（不过先要确定孩子结点存在）
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                child = child + 1;
            }
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child; // 从上向下调整子树，更新父亲结点的下标
                child = 2 * parent + 1; // 更新左孩子孩子结点的下标
            }
            // 因为我们是从上向下调整子树，当我们在调整上面的子树时，下面的子树一定是调整好了的，如果上面都已经满足大根堆，下面也一定满足
            else {
                break; // 此时已经是大根堆了，不需要再次调整，直接退出循环接着调整下一个子树

            }
        }
    }

    /**
     * 入队，当要保证入队后仍是大根堆
     * @param val 要入队的元素
     */
    public void offerHeap(int val) {
        if (isFull()) {
            elem = new int[2 * usedSize];
        }
        else {
            elem[usedSize] = val; // 把新添加的元素放到数组中最后的位置
            ++usedSize;
            shiftUp(usedSize - 1); // 放完后就从放到位置——从下向上调整该子树
        }
    }

    /**
     * 从下向上调整子树
     * @param child 要调整子树的孩子坐标
     */
    public void shiftUp(int child) {
        int parent = (child - 1) / 2; // 通过孩子坐标得出父亲坐标
        while (child > 0) { // 当孩子坐标等于0时，说明根结点已经调整完毕，退出循环
            // 因为之前的该子树的孩子结点的值肯定满足大根堆，所以我们只用考虑新加入的孩子结点的值
            if (elem[parent] < elem[child]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                // 更新
                child = parent;
                parent = (child - 1) / 2;
            }
            else {
                break; // 因为我们是从下向上调整子树的，我们上面的结点之前是满足大根堆的，所以如果下面也满足了，说明整个子树都满足了，直接退出循环
            }
        }
    }
    // 判断当前队列是否已满
    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出队删除，每次删除的都是优先级高的元素——当前完全二叉树的根结点
     * 出队后仍要保证该二叉树是大根堆
     */
    public void pollHeap() {
        if (isEmpty()) {
            System.out.println("当前优先级队列为空！");
            return;
        }
        // 将当前的队首元素与队尾元素互换位置，然后将向下调整以队首元素为根节点的那个子树，使满足大根堆
        int tmp = elem[usedSize - 1];
        elem[usedSize - 1] = elem[0];
        elem[0] = tmp;
        --usedSize; // 既然是删除，有效元素个数要减一
        shiftDown(0);
    }
    // 判断当前优先级队列是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        if (isEmpty()) {
            System.out.println("当前优先级队列为空！");
            return -1;
        }
        return elem[0];
    }
}
