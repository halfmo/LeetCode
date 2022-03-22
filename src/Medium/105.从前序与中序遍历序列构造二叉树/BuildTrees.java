public class BuildTrees {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,
                inorder,0,inorder.length);
    }
    public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inoder, int inLeft, int inRight){
          if (inLeft > inRight || preLeft > preRight) return null;

          //val 为前序遍历的第一个值，也就是根节点的值
        //index 是根节点下标
          int index = inLeft, val = preorder[preLeft];
          TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if (inoder[i] == val){
                index = i;
                break;
            }
        }

        root.left = helper(preorder,preLeft + 1,preLeft + (index - inLeft),
                inoder, inLeft, index - 1);
        root.right = helper(preorder, preLeft + (index - inLeft) + 1, preRight,
                inoder, index + 1, inRight);
        return root;
    }
}
