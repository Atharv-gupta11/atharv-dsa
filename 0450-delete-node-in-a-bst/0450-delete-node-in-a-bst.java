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
    public TreeNode deleteNode(TreeNode root, int key) {
        return solve(root,key);
    }

    TreeNode solve(TreeNode root,int key){
        if(root==null)return null;
        if(root.val==key){
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            TreeNode max=getmaxofleft(root.left);
            root.val=max.val;
            root.left = solve(root.left, max.val);
        }
        else if(root.val<key){
            root.right=solve(root.right,key);
        }
        else{
            root.left=solve(root.left,key);
        }
        return root;
    }


    TreeNode getmaxofleft(TreeNode root){
        if(root==null)return null;
        while(root.right!=null)root=root.right;
        return root;
    }
}