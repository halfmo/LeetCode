public class TreeNode<E> {
    E e;
    TreeNode<E> left;
    TreeNode<E> right;
    public TreeNode(E e){
        this.e = e;
    }
    public static void main(String[] args){
        TreeNode<String> root = new TreeNode<>("A");
        root.left = new TreeNode<>("B");
        root.right = new TreeNode<>("E");
        root.left.left = new TreeNode<>("C");
        root.left.right = new TreeNode<>("D");
        root.right.right = new TreeNode<>("F");
        System.out.println("debug");
        qian_test(root);
        System.out.println();
        zhong_test(root);
        System.out.println();
        hou_test(root);
        System.out.println();
    }
    private static void qian_test(TreeNode<String> root){//前序
        if(root == null) return;
        System.out.print(root.e + " ");
        qian_test(root.left);
        qian_test(root.right);
    }
    private static void zhong_test(TreeNode<String> root){//中序
        if(root == null) return;
        zhong_test(root.left);
        System.out.print(root.e + " ");
        zhong_test(root.right);
    }
    private static void hou_test(TreeNode<String> root){//后序
        if(root == null) return;
        hou_test(root.left);
        hou_test(root.right);
        System.out.print(root.e + " ");
    }
}
