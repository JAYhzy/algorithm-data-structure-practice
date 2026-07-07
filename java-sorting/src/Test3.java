import java.util.Arrays;
// 向下调整建立小根堆
public class Test3 {
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

    public static void main(String[] args) {
        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        shellSort(a);
        System.out.println("排序后的数组为：" + Arrays.toString(a));
    }
    public void createHeap(int[] arrays) {
        // 倒数的第一个非叶子节点的子树开始调节，一直调节到根结点（根节点在数组中的下标为0）
        // 注意这里是usdSize - 1 - 1,因为父亲结点的下标 = (孩子结点的下标 - 1） / 2，
        // 我们是从倒数的第一个非叶子节点的子树开始调节的，而该子树的孩子结点坐标为arrays.length - 1
        for (int i = (arrays.length - 1 - 1) / 2; i >= 0 ; --i) {
            shiftDown(arrays, i); // 从下面的子树一直调到上面的子树
        }
    }

    /**
     * 向下调整——使得当前子树为小根堆
     * @param root 是每棵子树的根结点的下标
     * 向下调整的时间复杂度O(log2n)（最坏情况下就是树的高度）
     */
    public void shiftDown(int[] arrays, int root) {
        int parent = root; // 父亲结点的坐标
        int child = 2 * parent + 1; // 获取左孩子结点的坐标
        // 为什么不能child下标要小于usedSize,因为当前数组的最大下标就是usedSize - 1,如果大于或等于usedSize就越界了
        while (child < arrays.length) { // 每个子树在调整的时候，是按从上到下，当child的下标小于usedSize时候就结束
            // 这一步目的是找出孩子结点最小的那个值，然后在让该值和父亲结点比较（不过先要确定孩子结点存在）
            if (child + 1 < arrays.length - 1 && arrays[child] > arrays[child + 1]) {
                child = child + 1;
            }
            if (arrays[child] < arrays[parent]) {
                int tmp = arrays[child];
                arrays[child] = arrays[parent];
                arrays[parent] = tmp;
                parent = child; // 从上向下调整子树，更新父亲结点的下标
                child = 2 * parent + 1; // 更新左孩子孩子结点的下标
            }
            // 因为我们是从上向下调整子树，当我们在调整上面的子树时，下面的子树一定是调整好了的，如果上面都已经满足小根堆，下面也一定满足
            else {
                break; // 此时已经是小根堆了，不需要再次调整，直接退出循环接着调整下一个子树
            }
        }
    }

    public static void main1(String[] args) {
        Test3 test3 = new Test3();
        int[] a = {4, 2, 7, 8, 5, 1, 0, 6};
        test3.createHeap(a);
        // 注意我们建立的小根堆没有储存在a数组中，而是储存在Test3类中的elem数组中
        System.out.println(Arrays.toString(a));
    }
}