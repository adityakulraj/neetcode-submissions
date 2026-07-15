/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int lvl = -1;
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        rightSideHelper(root, ans, 0);

        return ans;

        
    }

    public void rightSideHelper(TreeNode root, List<Integer> ans, int lev) {

        if(root == null)
        return;

        if(lev > lvl) {
            ans.add(root.val);
            lvl++;
        }

        rightSideHelper(root.right, ans, lev+1);
        rightSideHelper(root.left, ans,lev+1);


    }
}
