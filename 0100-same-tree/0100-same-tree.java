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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p,q);
    }

    boolean solve(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;

        if(root1!=null && root2!=null){
            int v1=root1.val;
            int v2=root2.val;
            if(v1!=v2)return false;
            else{
                if(!solve(root1.left,root2.left))return false;
                if(!solve(root1.right,root2.right))return false;
            }
        } 
        return true;

    }
}