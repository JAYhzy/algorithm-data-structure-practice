import java.util.Arrays;

public class MyHeap {
    int[] elem;   // 我们说过堆可以用数组来存放
    int usedSize; // 优先级队列中有效元素的个数
    MyHeap() {
        elem = new int[10]; // 构造方法初始化一下，堆（数组）的容量
    }
    public void createHeap(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            elem[i] =arrays[i]; // 元素初始化，给堆中元素赋值
            ++usedSize;
        }
        // 倒数的第一个非叶子节点的子树开始调节，一直调节到根结点（根节点在数组中的下标为0）
        // 注意这里是usdSize - 1 - 1,因为父亲结点的下标 = (孩子结点的下标 - 1） / 2，
        // 我们是从倒数的第一个非叶子节点的子树开始调节的，而该子树的孩子结点坐标为usedSize - 1
        for (int i = (usedSize - 1 - 1) / 2; i >= 0 ; --i) {
            shiftDown(i); // 从下面的子树一直调到上面的子树
        }
    }

    /**
     * 向下调整——使得当前子树为小根堆
     * @param root 是每棵子树的根结点的下标
     * 向下调整的时间复杂度O(log2n)（最坏情况下就是树的高度）
     */
    public void shiftDown(int root) {
        int parent = root; // 父亲结点的坐标
        int child = 2 * parent + 1; // 获取左孩子结点的坐标
        // 为什么不能child下标要小于usedSize,因为当前数组的最大下标就是usedSize - 1,如果大于或等于usedSize就越界了
        while (child < usedSize) { // 每个子树在调整的时候，是按从上到下，当child的下标小于usedSize时候就结束
            // 这一步目的是找出孩子结点最大的那个值，然后在让该值和父亲结点比较（不过先要确定孩子结点存在）
            if (child + 1 < usedSize && elem[child] > elem[child + 1]) {
                child = child + 1;
            }
            if (elem[child] < elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child; // 从上向下调整子树，更新父亲结点的下标
                child = 2 * parent + 1; // 更新左孩子孩子结点的下标
            }
            // 因为我们是从上向下调整子树，当我们在调整上面的子树时，下面的子树一定是调整好了的，如果上面都已经满足小根堆，下面也一定满足
            else {
                break; // 此时已经是小根堆了，不需要再次调整，直接退出循环接着调整下一个子树

            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 10, 3, 15, 8, 2};
        MyHeap myHeap = new MyHeap();
        myHeap.createHeap(array);
        System.out.println(Arrays.toString(myHeap.elem));
    }
}