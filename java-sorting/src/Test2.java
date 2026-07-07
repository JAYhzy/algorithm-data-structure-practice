import java.util.Arrays;

// 向上调整建立小根堆的两种方法
public class Test2 {
    private  int[] array;
    private  int usedSize; // 当前堆中的有效元素个数
    Test2() {
        array = new int[10]; // 通过构造方法给数组分配空间
    }
    // 向上调整保证是小根堆：时间复杂度是O(log以2为底的N)---log2N
    public  void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (this.array[child] < this.array[parent]) {
                int tmp = this.array[child];
                this.array[child] = array[parent];
                this.array[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }
            else {
                break;
            }
        }
    }

    // 向堆中插入元素
    public  void offerHeap(int val) {
        if (this.usedSize >= this.array.length) {
            System.out.println("数组已满，插入失败！");
        }
        else {
            this.array[usedSize] = val;
            shiftUp(usedSize);  // 插入数据后进行向上调整确保为小堆
            ++usedSize;         // 堆中有效元素加一个
        }
    }
    // 建立小根堆的方法一：
    // 向上调整建立小根堆，时间复杂度是O(n * log2N)
    public void createHeapUp1() {
        int[] a = {4, 2, 7, 8, 5, 1, 0, 6};
        // 遍历a数组，将a数组中的元素一个一个的插入堆中
        for (int i = 0; i < a.length; i++) {
            offerHeap(a[i]);
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] a =  {4, 2, 7, 8, 5, 1, 0, 6};
        test2.createHeapUp2(a);
        // 现在a数组储存的就是一个小根堆
        System.out.println(Arrays.toString(a));
    }
    // 向上调整保证是小根堆：时间复杂度是O(log以2为底的N)---log2N
    public  void shiftUp(int[] array, int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (array[child] < array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }
            else {
                break;
            }
        }
    }
    // 建立小根堆的方法二：
    // 向上调整建立小根堆，时间复杂度是O(n * log2N)
    public  void createHeapUp2(int[] array) {
        for (int i = array.length - 1; i > 0; --i) {
            shiftUp(array, i); // 对数组的每一个元素进行向上调整，从堆的最后一个叶子结点开始——既然是从下向上调整自然要从下面开始呀！
        }
    }
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (tmp > array[j]) {
                    array[j + 1] = array[j];
                }
                else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
    public static void insertSortGap(int[] array, int gap) {
        for (int i = gap; i < array.length; ++i) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (tmp < array[j]) {
                    array[j + gap] = array[i];
                }
                else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }
}
