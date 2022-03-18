import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePathsS {
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
  //回溯
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        if (root == null){
//            return res;
//        }
//        List<Integer> paths = new ArrayList<>();
//        traversal(root, paths, res);
//
//        return res;
//    }
//    public void traversal(TreeNode root, List<Integer> paths, List<String> res){
//          paths.add(root.val);
//          //叶子节点
//          if (root.left == null && root.right == null){
//              //输出
//              StringBuilder sb = new StringBuilder();
//              for (int i = 0; i < paths.size() - 1; i++){
//                  sb.append(paths.get(i)).append("->");
//              }
//              sb.append(paths.get(paths.size() - 1));
//              res.add(sb.toString());
//              return;
//          }
//          if (root.left != null){
//              traversal(root.left, paths, res);
//              paths.remove(paths.size() - 1);//回溯
//          }
//          if (root.right != null){
//              traversal(root.right, paths, res);//回溯
//              paths.remove(paths.size() - 1);//回溯
//          }
//    }

    //迭代
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
