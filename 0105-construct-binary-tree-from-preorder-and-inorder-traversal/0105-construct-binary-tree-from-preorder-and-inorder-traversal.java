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
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //root left right preorder
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int n=inorder.length;
        idx=0;
        return solve(map,preorder,inorder,0,n-1);
    }
    
    TreeNode solve(HashMap<Integer,Integer> map,int []preorder,int []inorder,int start,int end){
        if(start>end)return null;


        int rootval=preorder[idx];
        TreeNode root=new TreeNode(preorder[idx]);
        int rootidx=map.get(rootval);
        idx++;

        root.left=solve(map,preorder,inorder,start,rootidx-1);
        root.right=solve(map,preorder,inorder,rootidx+1,end);
        return root;
    }
}