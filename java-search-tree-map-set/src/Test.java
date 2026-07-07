import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Character> set = new TreeSet<>();
        set.add('e');
        boolean tmp = set.add('e');
    }
    public static void main2(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("xixi", 23);
        map.put("what", 34);
        System.out.println(map.size());
    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {12, 32, 2, 43, 21, 14};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        // 如果TreeNode不是静态内部类需要这样实例化——BinarySearchTree.TreeNode treeNode = binarySearchTree.new TreeNode(12);
        // 静态内部类直接— BinarySearchTree.TreeNode treeNode = new BinarySearchTree.TreeNode(12);
        BinarySearchTree.TreeNode ret = binarySearchTree.search(423);
        try {
            System.out.println(ret.key);
        } catch (NullPointerException e) {
            System.out.println("该二叉搜索树中没有你要查找的结点");
            //e.printStackTrace();
        }
        System.out.println("==========================");
        binarySearchTree.remove(32);
        binarySearchTree.inorder(binarySearchTree.root);// 二叉搜索树的中序遍历是有序的
    }
}
