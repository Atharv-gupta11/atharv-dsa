class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return ans;
        q.add(root);
        int idx=1;
        while(!q.isEmpty()){
            
            int sz=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode curr=q.remove();
            if (idx % 2 != 0) {
                l.addLast(curr.val);
            } else {
                l.addFirst(curr.val);
            }
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                
                
            }
            idx++;
            ans.add(l);
        }
        return ans;
    }
}
