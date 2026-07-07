public class BinarySearchTree {


   static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int key) {
            this.key = key;
        }

    }
    public TreeNode root;
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
        }
        else {
            TreeNode parent = null;
            TreeNode cur = root;
            TreeNode node = new TreeNode(key);
            while (cur != null) {
                // 为什么不在while循环了出现node,因为对于二叉搜索树来说，我们都是在叶子结点的位置插入元素，你想想后面的元素是要先遍历到叶子结点，然后在插入
                // 因为每次插入新结点都要从上到下遍历一遍二叉树，不能在中间就把结点盲目的插入了，这样不符合二叉搜索树的要求
                if (cur.key > key) {
                    parent = cur;
                    cur = cur.left;
                }
                else if (cur.key < key) {
                    parent = cur;
                    cur = cur.right;
                }
                else {
                    return; // 插入元素的值不能相同，二叉搜索树的要求
                }
            }
            // 当程序走到这，cur == null
            if (parent.key > key) {
                parent.left = node;
            }
            else {
                parent.right = node;
            }
        }
    }
    // 如果是二叉搜索树，中序遍历的值就是有序的
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
    // 二叉搜索树的查找
    public TreeNode search(int key) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key < key) {
                cur = cur.right;
            }
            else if (cur.key > key) {
                cur = cur.left;
            }
            else {
                return cur;
            }
        }

        return null;
    }
    // 二叉搜索树的删除操作
    public boolean remove(int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            }
            else if (cur.key < key) {
                parent = cur;
                cur = cur.right;
            }
            else {
                removeKey(parent, cur);
                return true;
            }
        }
        return false;
    }
    // 删除结点的具体操作
    public void removeKey(TreeNode parent, TreeNode cur) {
        if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }
            if (parent.key < cur.key) {
                parent.right = cur.left;
            }
            else {
                parent.left = cur.left;
            }
        }
        else if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }
            if (parent.key < cur.key) {
                parent.right = cur.right;
            }
            else {
                parent.left = cur.right;
            }
        }
        else {  // 当要删除结点的左右子结点都不为空的时候
            TreeNode targetParent = cur;
            TreeNode target = cur.right; // 我们所寻找的target就是要删除结点cur的右子树的最小值
            // 寻找要删除结点cur的右子树的最小值，将该最小值所对应的结点的值覆盖掉要删除的结点的值，
            // 此时要删除的结点就相当于是删除了，并且此时满足二叉搜索树的性质（不要忘了把最小值的原位置结点给删除）
            // 对于最小值结点来说，他的左子结点一定为空（删除方法和我们上面的方法是一样的）
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            // 此时的target要删除结点cur的右子树的最小值所对应的结点
            cur.key = target.key;  // 用target的值覆盖掉要删除结点cur的值
            // 覆盖掉后把target结点删除， 对于最小值结点来说，他的左子结点一定为空（删除方法和我们上面的方法是一样的）
            if (targetParent.key > target.key) {
                targetParent.left = target.right;
            }
            else {
                targetParent.right = target.right;
            }
        }
    }
}
