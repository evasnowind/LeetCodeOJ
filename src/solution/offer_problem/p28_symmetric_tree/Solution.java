package solution.offer_problem.p28_symmetric_tree;

public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (null == root) {
      return true;
    }

    return isSubSymmetric(root.left, root.right);
  }

  public boolean isSubSymmetric(TreeNode left, TreeNode right) {
    if (null != left && null == right) {
      return false;
    } else if (null == left && null != right) {
      return false;
    } else if (null == left && null == right) {
      return true;
    }

    if (left.val == right.val) {
      return isSubSymmetric(left.left, right.right) && isSubSymmetric(left.right, right.left);
    } else {
      return false;
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}