import java.util.*;

// 树类
public class MyBinaryTree {
    // 结点类
    class TreeNode {
        public char val;  // 储存该结点的数值
        public TreeNode left; //左孩子的引用,即该结点的左子结点
        public TreeNode right; //右孩子的引用

        // 三种对树的结点的构造方法（每一种方法所传参数都是不同的）
        TreeNode() {
        }
        // 其实我们接下来用到的都是这一种构造方法，因为接下来我们只是在构造方法中给该结点赋值，至于该结点的左右子结点，我们是手动给他们建立联系的
        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override  // 重写toString方法，一般接下来能够之间打印树的结点
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    // 其实这不是二叉树真正的构建方式，但我们的目的是快速构建一个二叉树，学习的二叉树的一些方法（这是我们的侧重点）
    // 至于真正的构建方法，我们之后的博客会讲到，本篇博客我们重点了解二叉树所对应的各种独特的方法
    public TreeNode createBinaryTree(){
        TreeNode node1 = new TreeNode('A');
        TreeNode node2 = new TreeNode('B');
        TreeNode node3 = new TreeNode('C');
        TreeNode node4 = new TreeNode('D');
        TreeNode node5 = new TreeNode('E');
        TreeNode node6 = new TreeNode('F');
        TreeNode root = node1;  // 我们采用了穷举法来快速的构建一棵二叉树
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        return root;            // 返回我们构建树的根结点
    }
    // 前序遍历——》根->左子树->右子树
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        postOrder(root.left);
        postOrder(root.right);
    }
    // 前序遍历——非递归
    public void preOrder1(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    // 中序遍历——》左子树—>根->右子树
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 中序遍历——非递归
    public void inOrder1(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 后续遍历——》左子树->右子树—>根
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 后序遍历——非递归
    public void postOrder1(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right) {
                TreeNode tmp = stack.pop();
                System.out.print(tmp.val + " ");
                prev = tmp;
            }
            else {
                cur = top.right;
            }
        }
    }

    // 获取树的结点的个数，遍历
    public static int nodeSize;
    void size2(TreeNode root) {
        if (root == null) return;
        ++nodeSize;
        size2(root.left);
        size2(root.right);
    }
    // 获取树中节点的个数，子问题求解
    int size(TreeNode root) {
        if (root == null) return 0;
        int leftSize = size(root.left);  // 递归到root.left == null 开始返回:return 0;
        int rightSize = size(root.right);
        // 当leftSize和rightSize都第一次递归结束（即道理叶结点出，此时叶子结点的左右子节点都为空之间返回0，但你能说结点为0吗
        // 肯定不能虽然当前结点的左右子结点数目都为0，但别忘了当前结点也是算一个结点呀！！！所以要+1
        return leftSize + rightSize + 1;
    }

    // 遍历思路—获取叶子节点的个数
    public static int leafSize;
    // 因为getLeafNodeCount1函数中有递归，所以我们的nodeSize不能定义到函数里
    // （因为递归不断调用我们的函数，相当于会给nodeSize不断的赋初始值，所以我们对nodeSize累加的值会被冲掉
    int getLeafNodeCount1(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            ++leafSize;
        }
        getLeafNodeCount1(root.left); // 其实遍历也离不开递归
        getLeafNodeCount1(root.right);
        return leafSize;
    }
    // 子问题思路-求叶子结点个数
    int getLeafNodeCount2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right); // 返回左子树的叶子结点的个数 + 右子树叶子结点的个数
    }

    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) return 0;
        if (k == 1) return 1;
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    // 获取二叉树的高度——时间复杂度O(N)
    int getHeight(TreeNode root) {
        if (root == null) return 0;
        // 下面这样写虽然对，但应为多递归了一次；在oj上可能超时
        //return (getHeight(root.left) > getHeight(root.right)) ? getHeight(root.left) + 1 : getHeight(root.right) + 1;
        // 所以这样写，用变量把我们递归的结果保存下来，这样在三目运算符？后就不用在重复的调用递归求高度了
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
        // 做左右子树的最大深度加1
    }

    // 检测值为value的元素是否存在——转换为子问题
    TreeNode find(TreeNode root, char val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode treeNode1 = find(root.left, val);
        TreeNode treeNode2 = find(root.right, val);
        if (treeNode1 == null) return treeNode2;
        else return treeNode1;
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
//        if(root == null) return;
//        Queue<TreeNode> queue = new LinkedList<>(); // 我们需要借助一个队列，
//        queue.offer(root); // 先把根结点放到队列中，根结点相当于是第一层
//        while (!queue.isEmpty()) {
//            // 借助tmp来把当前结点的左右子树给放到队列中
//            // 注意随着队列元素的不断弹出，tmp是在动态变化的，所以才能变量完——整棵二叉树
//            TreeNode tmp = queue.poll();  // 因为这一层的元素入队列的时候，是通过上一层元素的对左右子树操作来实现的，入队列是一层一层入的
//            System.out.print(tmp.val + " ");
//            if (tmp.left != null) {
//                queue.offer(tmp.left);  // 把当前从队列中弹出的结点的左子结点放到队列中
//            }
//            if (tmp.right != null) {
//                queue.offer(tmp.right); // 右子结点
//            }
//        }

        if (root == null) return;
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp = queue.poll();
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            if (tmp.left != null){
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
            tmp = queue.poll();
        }
    }

    // 力扣oj题目——层序遍历，因为要求不同所以我们的具体做法有些不一样，但基本的思想相同
    public List<List<Character>> levelOrder1(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) return ret; //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 首先根结点先入队
        while (!queue.isEmpty()) {
            int size = queue.size(); // 第一层的size = 1;
            List<Character> ans = new ArrayList<>();
            while (size != 0) {
                TreeNode tmp = queue.poll();
                ans.add(tmp.val); // 把当前从栈中出来的元素放到我们定义的List中，因为是同一层的，在一个循环里的
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                --size;
            }
            ret.add(ans);
        }
        return ret;
    }
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
       return false;
    }

}
