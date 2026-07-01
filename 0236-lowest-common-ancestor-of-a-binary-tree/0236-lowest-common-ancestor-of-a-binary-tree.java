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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }

    TreeNode solve(TreeNode root,TreeNode p, TreeNode q){
        if(root==null)return null;

        

        TreeNode l=solve(root.left,p,q);
        TreeNode r=solve(root.right,p,q);
        
        if(root==p || root==q)return root;
        if(l==null && r==null)return null;
        if(l==null)return r;
        if(r==null)return l;
        return root;
    }
}