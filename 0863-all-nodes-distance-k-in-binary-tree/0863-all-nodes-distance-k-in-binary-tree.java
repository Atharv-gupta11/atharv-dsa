/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        parent.put(root,null);

        while(!q.isEmpty()){
            int sz=q.size();

            for(int i=0;i<sz;i++){
                TreeNode par=q.remove();

                if(par.left!=null){
                    parent.put(par.left,par);
                    q.add(par.left);
                }
                
                if(par.right!=null){
                    parent.put(par.right,par);
                    q.add(par.right);
                }
            }
        }

        List<Integer> ans=new ArrayList<>();
        solve(target,k,ans,parent);
        return ans;

    }

    void solve(TreeNode target,int k,List<Integer> ans,HashMap<TreeNode,TreeNode> parent){


        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        q.add(target);
        visited.add(target);
        int dist=0;
        while(!q.isEmpty()){
            int sz=q.size();
            if(dist==k)break;

            for(int i=0;i<sz;i++){
                TreeNode node=q.remove();

                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);

                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }

                TreeNode pat=parent.get(node);
                if(pat!=null && !visited.contains(pat) ){
                    q.add(pat);
                    visited.add(pat);
                    
                }
            }
            dist++;
        }

        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }
    }
}