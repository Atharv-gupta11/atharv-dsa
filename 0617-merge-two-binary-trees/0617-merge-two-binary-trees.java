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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        root=solve(root1 , root2);
        return root;
    }
    TreeNode root;
    boolean first=true;

    TreeNode solve(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null)return null;

        if(r1==null){
            return r2;
        }
        if(r2==null){
            return r1;
        }

        int sum=r1.val+r2.val;
        TreeNode nn=new TreeNode(sum);
        if(first){
            root=nn;
            first=false;
        }
        nn.left=solve(r1.left,r2.left);
        nn.right=solve(r1.right,r2.right);
        return nn;
    }

}