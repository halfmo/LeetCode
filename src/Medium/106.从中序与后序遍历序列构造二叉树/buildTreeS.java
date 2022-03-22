public class buildTreeS {
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight){
          if (inRight - inLeft < 1){//没有元素了
              return null;
          }
          //只有一个元素
          if (inRight - inLeft == 1){
              return new TreeNode(inorder[inLeft]);
          }
          //取后续数组的最后一位即根节点
          int rootVal = postorder[postRight -1];
          TreeNode root = new TreeNode(rootVal);
          int rootIndex = 0;
          //根据根节点的值找到改制在中序数组中的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        //根据rootIndex划分左右子树
        root.left = buildTree1(inorder,inLeft,rootIndex,postorder,postLeft,
                postLeft+(rootIndex - inLeft));
        root.right = buildTree1(inorder,rootIndex+1,inRight,
                postorder,postLeft+(rootIndex-inLeft),postRight - 1);
        return root;
    }
}
