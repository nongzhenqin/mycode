package redblacktree;

/**
 * 红黑树
 *
 * @param <T>
 * @author nong
 */
public class RBTree<T extends Comparable> {

    private RBTNode<T> rootNode;// 根节点

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable> {
        boolean color; // 颜色
        T key; // 关键字（键值）
        RBTNode<T> left; // 左孩子
        RBTNode<T> right; // 右孩子
        RBTNode<T> parent; // 父节点

        public RBTNode(T key, boolean color, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
