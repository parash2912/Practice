/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> inorderTrav(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }
        ret.addAll(inorderTrav(root.left));
        ret.add(root.val);
        ret.addAll(inorderTrav(root.right));
        return ret;
    }
    
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = inorderTrav(root);
        int min_diff = Integer.MAX_VALUE;
        for(int i = 0; i < inorder.size() - 1; ++i) {
            int abs_diff = Math.abs(inorder.get(i) - inorder.get(i+1));
            if(abs_diff < min_diff) {
                min_diff = abs_diff;
            }
        }
        return min_diff;
    }
}
