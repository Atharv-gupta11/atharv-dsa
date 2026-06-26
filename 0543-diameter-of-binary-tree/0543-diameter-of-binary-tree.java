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
    public int diameterOfBinaryTree(TreeNode root) {
        return dia(root);
    }

    public int height(TreeNode root){
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);

        return Math.max(lh,rh)+1;
    }

    public int dia(TreeNode root){
        if(root==null)return 0;
        int ld=dia(root.left);
        int rd=dia(root.right);
        int md=height(root.left)+height(root.right);

        return Math.max(md,Math.max(rd,ld));
    }
    
}