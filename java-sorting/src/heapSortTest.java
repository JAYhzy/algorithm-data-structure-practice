import java.util.Arrays;
// 堆排序完整代码测试
public class heapSortTest {
    // 向下调整为大根堆
    public static void shiftDownBig(int[] array, int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            }
            else {
                break;
            }

        }
    }
    // 大根堆的创建（这里我们用到是向下调整建立大根堆，时间复杂度O(n)——如果是向上调整建立大根堆堆，时间复杂度是O(n * log2N)
    public static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; --i) {
            shiftDownBig(array, i, array.length);
        }
    }
    /**
     * 堆排序，从小到大排序——建立大根堆（原地排序，在数组本身排序）
     * @param
     */
    public static void heapSort(int[] array) {
        // 1、先建立一个大根堆，建堆的时间复杂度为O(n)因为我们是通过向下调整来建堆的
        createHeap(array);
        // 2、将当前堆顶元素(array[0])与堆中end下标的元素互换位置，然后向下调整，保证仍为大根堆——这样堆顶元素仍旧是当前数组中最大的元素
        // end从堆中最后一个元素开始，保证堆中（数组）的最大值在堆中最后一个元素的位置，然后倒数第二大、第三大元素接着从array.length - 2开始向前排
        for (int end = array.length - 1; end > 0; --end) {
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            // 调整0下标这棵树仍为大根堆
            shiftDownBig(array, 0, end);
            // 保证调整完后是大根堆,注意这里的结束位置是end，end后面是用到存放数组前k个元素的，如果结束位置是array.length,那么我们之前放到数组array.length - 1下标的数组最大值就又被调整了
        }
        // 具体堆排的时间复杂度为 O(n * logn)--总的时间复杂度就是(n + n * logn)即O(n * log以2为底的n)
    }

    public static void main(String[] args) {
        int[] array = {23, 42, 13, 12, 28};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    // 向上调整保证是大根堆：时间复杂度是O(log以2为底的N)---log2N
    public static void shiftUp(int[] array, int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (array[child] > array[parent]) {
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
    // 向上调整建立大根堆堆，时间复杂度是O(n * log2N)
    public static void createHeapUp(int[] array) {
        for (int i = array.length - 1; i > 0; --i) {
            shiftUp(array, i);
        }
    }
}
