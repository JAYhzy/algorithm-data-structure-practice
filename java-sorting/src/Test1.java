import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 各种排序方法测试
public class Test1 {
    /**
     * 直接插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j  = i - 1;
            for (; j >= 0; --j) {
                // [32、56、12、23],i指向12，j一开始指向56，我们就是借助tmp和j的变化，把32、56向后移动一位，把12放到他们前面
                // 这个过程就像把array[i](tmp)插入到数组，放到数组中合适的位置，保证放完后数组是升序（所以才要a[j + 1] = a[j]不断的移动a[j]的位置
                if (tmp < array[j]) {
                    array[j + 1] = array[j]; // 如果a[j]的值大于a[i](tmp),说明a[i]应该放到a[j]前面——a[j]应该向后移动
                }
                else {
                    break; // 此时说明a[j]已经在合适的位置了，不用再次移动了
                }
            }
            array[j + 1] = tmp; //  注意这里不能等于array[i]，因为经过上面array[j+1] = array[j]数组的移动，array[i]已经发生了变化
        }
    }
    // 希尔排序——预排序（gap，表示分的组数）
    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j  = i - gap;
            for (; j >= 0; j = j - gap) {
                if (tmp < array[j]) {
                    array[j + gap] = array[j]; // 如果a[j]的值大于a[i](tmp),说明a[i]应该放到a[j]前面——a[j]应该向后移动
                }
                else {
                    break; // 此时说明a[j]已经在合适的位置了，不用再次移动了
                }
            }
            array[j + gap] = tmp; //  注意这里不能等于array[i]，因为经过上面array[j+gap] = array[j]数组的移动，array[i]已经发生了变化
        }
    }
    /**
     * 希尔排序——直接插入排序的优化
     * @param array
     */
    public static void shellSort(int[] array) {
        for (int i =array. length / 3 + 1; i > 1; i = i / 3 + 1) {
            shell(array, i); // 预排序,让我们排序的这个数组接近有序，这样下面的直接插入排序shell(array,1)时间效率才会高
        }
        shell(array, 1); // 这个相当于把数组分成一组，其实就是我们上面写的直接插入排序
    }
    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) { // 注意这里不能是array[i] < array[j]因为j在这个循环里是静态的，我们排序要求是动态的
                    minIndex = j; // 比如[1、34、56、12、23], i下标所对应的数组的值一开始等于34，j -> 12是满足条件，minIndex更新，等于12所对应的下标
                    // 但如果是array[i] < array[j]，此时array[j]还等于34，等于遇到23，条件仍然满足，minIndex又更新了，但其实这个时候不应该更新，因为刚才的12就是从i下标往后的数组中最小的值了
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }
    // 向下调整,保证是大根堆
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
   // 堆的创建
    public static void createHeap(int[] array) { // 大根堆的创建
        for (int i = (array.length - 1 - 1) / 2; i >= 0; --i) {
            shiftDownBig(array, i, array.length);
        }
    }
    /**
     * 堆排序，从小到大排序——建立大根堆（原地排序，在数组本身排序）
     * @param
     */
    public static void heapSort(int[] array) {
        // 1、先建立一个大根堆
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
    }

    /**
     * topK问题，找出数组中最大的k个元素， 但这不是最优的解决方案
     * 时间复杂度：O(N * logn), 想一下他的空间复杂度的是多少，是O(n)吗？
     * @param array
     * @return 前k个元素所组成的数组
     */
    public static int[] topK1(int[] array, int k) {
        IntCmp intCmp = new IntCmp(); // 自定义的比较器，用来实现大根堆（因为PriorityQueue的排序方法默认实现小根堆）
        // 创建具有默认初始容量的 PriorityQueue ，并根据指定的比较器对其元素进行排序。
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(intCmp);
        for (int i = 0; i < array.length; i++) {
            priorityQueue.offer(array[i]); // 每插入一个元素就要向上调整一次，时间复杂度：n * logn
        }
        // 程序走到这里我们已经构建了一个大根堆
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll(); // 每弹出一个堆顶元素就要向下调整一次，时间复杂度：n * logn
        }
        return ret;
    }

    /**
     * topK问题，最优解法
     * @return 堆中前k个最大的元素所组成的数组
     */
    public static int[] topK(int[] array, int k) {
        // 要求堆中前k个最大元素，先将数组中前k个元素建成小根堆（如果要求堆中前k个最小元素，先将数组中前k个元素建成大根堆，正好是反过来的）
        // 创建一个PriorityQueue ，具有默认的初始容量（11），根据它们的natural ordering对其元素进行排序 。默认的排序方法建成的是小根堆）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(array[i]);
        }
        // 遍历剩下的array.length - k个元素，从数组的第k + 1个元素开始，剩下的每个元素都和当前堆顶元素进行比较
        // 如果当前i下标的元素比堆顶元素大，就删除堆顶元素，并把i下标的元素放到堆中
        for (int i = k; i < array.length; ++i) {
            if (array[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
    // 获取当前数组中第K大的元素
    public static int getK(int[] array, int k) {
        // 要求堆中前k个最大元素，先将数组中前k个元素建成小根堆（如果要求堆中前k个最小元素，先将数组中前k个元素建成大根堆，正好是反过来的）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(array[i]);
        }
        // 遍历剩下的array.length - k个元素，从数组的第k + 1个元素开始，剩下的每个元素都和当前堆顶元素进行比较
        // 如果当前i下标的元素比堆顶元素大，就删除堆顶元素，并把i下标的元素放到堆中
        for (int i = k; i < array.length; ++i) {
            if (array[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        // 程序运行到了这里，我们的优先级队列里（堆中）存放的就是堆中前k个最大的元素，此时堆顶元素就是第k大的元素
        return priorityQueue.peek();
    }
    public static void main(String[] args) {
        int[] a = {23, 42, 23, 32, 12};
        int[] ret = topK(a,2);
        System.out.println(Arrays.toString(ret));
        //System.out.println(getK(a, 5));
        // heapSort(a);
//        shellSort(a);
//        System.out.println(Arrays.toString(a));
        // heapSort(a);
        // System.out.println(Arrays.toString(a));

    }
}
// 自定义了一个比较器对象，完成大根堆的构建
class IntCmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}