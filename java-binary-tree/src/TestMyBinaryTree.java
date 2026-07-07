import java.util.Arrays;
import java.util.List;

public class TestMyBinaryTree {
    public static void shiftGrid(int[][] grid) {
        int len1 = grid.length, len2 = grid[0].length;
        int[][] tmp = new int[len1][len2];
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                tmp[i][j] = grid[i][j];
        for (int i = 0; i < grid.length; ++i) {
            if (i != 0) grid[i][0] = tmp[i - 1][tmp[i - 1].length - 1];
            for (int j = 1; j < grid[i].length; ++j) {

                    if (j + 1 == grid[i].length) {
                        if (i  + 1 == grid.length) grid[0][0] = tmp[i][j];
                    }
                    else grid[i][j] = tmp[i][j - 1];
            }

            if (len2 != 1)
                grid[i][grid[i].length - 1] = tmp[i][tmp[i].length - 2];
            else grid[0][0] = tmp[grid.length - 1][grid[0].length - 1];
        }
    }

    public static void main(String[] args) {
        int[][] grad = {{1}, {2}, {3}, {4}, {5}};
        shiftGrid(grad);
        for (int i = 0; i < grad.length; i++) {
            System.out.println(Arrays.toString(grad[i]));
        }

        MyBinaryTree myBinaryTree = new MyBinaryTree();
        MyBinaryTree.TreeNode root = myBinaryTree.createBinaryTree();
        myBinaryTree.size2(root);
        System.out.println(MyBinaryTree.nodeSize);

        System.out.print("前序遍历的结果是：");
        myBinaryTree.preOrder1(root); // 前序遍历
        System.out.println();

        System.out.print("中序遍历的结果是：");
        myBinaryTree.inOrder1(root);   // 中序遍历
        System.out.println();



        System.out.print("后序遍历的结果是：");
        myBinaryTree.postOrder1(root); // 后序遍历
        System.out.println();

        System.out.println("=========我是分割线=========");
        System.out.println("在树中，对B的查找结果是：" + myBinaryTree.find(root, 'B'));
        System.out.println("在树中，对d的查找结果是：" + myBinaryTree.find(root, 'd'));
        System.out.println("当前树中的最大深度为：" + myBinaryTree.getHeight(root));

        System.out.println("=========我是分割线=========");
        System.out.println("当前树中的结点个数是：" + myBinaryTree.size(root));
        System.out.println("当前树中的叶子结点个数：" + myBinaryTree.getLeafNodeCount1(root));
        System.out.println("当前树中第2层的结点个数为：" + myBinaryTree.getKLevelNodeCount(root, 2));
        System.out.print("层序遍历的结果为：");
        myBinaryTree.levelOrder(root);
    }
}