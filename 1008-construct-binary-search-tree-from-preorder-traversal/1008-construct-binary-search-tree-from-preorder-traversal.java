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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        return buildBST(preorder,min,max);
    }

    public TreeNode buildBST(int []preorder,int min,int max){
        if(i>=preorder.length)return null;
        if(preorder[i]<min || preorder[i]>max)return null;

        TreeNode root=new TreeNode(preorder[i]);
        i++;
        root.left=buildBST(preorder,min,root.val);
        root.right=buildBST(preorder,root.val,max);
        return root;
    }

    
}