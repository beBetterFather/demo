package tree;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            //默认每个新创建为红色
            color = RED;
        }
    }

    private Node root;
    private int size;

    //构造函数
    public RBTree(){
        root = null;
        size = 0;
    }

    //左旋转
    private Node leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    //右旋转

}
