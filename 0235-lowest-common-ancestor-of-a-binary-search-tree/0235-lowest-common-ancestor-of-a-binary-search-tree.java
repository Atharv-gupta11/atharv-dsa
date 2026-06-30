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
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }

    TreeNode solve(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return null;
        //both same side 
        if(root==p || root==q)return root;
        if(root.val<p.val && root.val<q.val){
            return solve(root.right,p,q);
        }
        if(root.val>p.val && root.val>q.val){
        return  solve(root.left,p,q);
        }
        return root;
    }
}