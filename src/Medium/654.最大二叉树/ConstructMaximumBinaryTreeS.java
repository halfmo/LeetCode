public class ConstructMaximumBinaryTreeS {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }
    public TreeNode helper(int[] nums, int leftIndex, int rightIndex){
      if (rightIndex - leftIndex < 1){
          return null;
      }
      if (rightIndex - leftIndex == 1){
          return new TreeNode(nums[leftIndex]);
      }
      int maxIndex = leftIndex;
      int maxVal = nums[maxIndex];
      for (int i = leftIndex + 1; i < rightIndex; i++){
          if (nums[i] > maxVal){
              maxIndex = i;
              maxVal = nums[i];
          }
      }
      TreeNode root = new TreeNode(maxVal);
      root.left = helper(nums,leftIndex,maxIndex);
      root.right = helper(nums,maxIndex + 1, rightIndex);
      return root;
    }
}
