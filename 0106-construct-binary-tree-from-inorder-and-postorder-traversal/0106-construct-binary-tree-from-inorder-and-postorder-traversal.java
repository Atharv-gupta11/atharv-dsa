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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return solve(map,inorder,postorder,0,n-1,0,n-1);
    }

    public TreeNode solve(HashMap<Integer,Integer>map,int inorder[],int postorder[],int instart,int inend,int poststart,int postend){
        if(instart>inend || poststart>postend)return null;

        int rootval=postorder[postend];
        int inrootidx=map.get(rootval);
        int lsize=inrootidx-instart; 
        int rsize=inend-inrootidx;

        TreeNode root=new TreeNode(rootval);

        root.left=solve(map,inorder,postorder,instart,inrootidx-1,poststart,poststart+lsize-1);
        root.right=solve(map,inorder,postorder,inrootidx+1,inend,postend-rsize,postend-1);
        return root;
    }
}