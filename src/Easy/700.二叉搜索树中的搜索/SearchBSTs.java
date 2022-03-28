public class SearchBSTs {
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
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root == null || root.val == val)
//            return root;
//        if (root.val > val) return searchBST(root.left, val);
//        if (root.val < val) return searchBST(root.right, val);
//        return null;
//    }
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if (root.val > val) root = root.left;
            else if (root.val < val) root = root.right;
            else return root;
        }
        return null;
    }
}
