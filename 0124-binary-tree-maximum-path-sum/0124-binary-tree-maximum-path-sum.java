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
    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum=Integer.MIN_VALUE;

        solve(root);
        return maxsum;
    }

    int solve(TreeNode root){
        if(root==null)return 0;

        int l=solve(root.left);
        int r=solve(root.right);

        int dono_accha=l+r+root.val;
        int koi_ek_accha=Math.max(l,r)+root.val;
        int only_root_Accha=root.val;

        maxsum=Math.max(maxsum,Math.max(dono_accha,Math.max(koi_ek_accha,only_root_Accha)));

        return Math.max(only_root_Accha,koi_ek_accha);
    }
}