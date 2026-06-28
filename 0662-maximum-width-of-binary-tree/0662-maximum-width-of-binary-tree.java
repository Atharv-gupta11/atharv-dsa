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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Info> q=new LinkedList<>();
        if(root==null)return 0;
        q.add(new Info(root,0));
        int mw=0;
        while(!q.isEmpty()){
            int sz=q.size();
            int s=-1;
            int e=-1;
            int min=q.peek().idx;
            for(int i=0;i<sz;i++){
                Info r=q.remove();
                int curr=r.idx-min;
                if(i==0){
                    s=r.idx-min;
                }
                if(i==sz-1){
                    e=r.idx-min;
                }
                TreeNode n=r.node;
                if(n.left!=null){
                    q.add(new Info(n.left,2*curr+1));
                }
                if(n.right!=null){
                    q.add(new Info(n.right,2*curr+2));
                }
            }
            mw=Math.max(mw,e-s+1);
        }
        return mw;
    }

    class Info{
        TreeNode node;
        int idx;

        public Info(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
}