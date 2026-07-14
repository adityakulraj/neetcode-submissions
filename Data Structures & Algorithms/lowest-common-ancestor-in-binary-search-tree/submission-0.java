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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
        return null;

        int curr = root.val;
        int l = Math.min(p.val, q.val);
        int r = Math.max(p.val, q.val);

        if(l == r)
        return p;


        if(curr >= l && curr <= r) {
            return root;
        }
        else if(curr >= l && curr >=r)
         return lowestCommonAncestor(root.left, p,q);

        else 
        return lowestCommonAncestor(root.right, p,q);

        


    }
}
