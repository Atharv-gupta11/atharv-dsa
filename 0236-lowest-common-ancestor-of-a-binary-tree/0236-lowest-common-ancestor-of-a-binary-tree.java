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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1=new ArrayList<>();
        ArrayList<TreeNode> p2=new ArrayList<>();

        getPath(root,p,p1);
        getPath(root,q,p2);

        int i = 0;

while(i < p1.size() &&
      i < p2.size() &&
      p1.get(i) == p2.get(i))
{
    i++;
}

return p1.get(i-1);
    }

    boolean getPath(TreeNode root,TreeNode dest,ArrayList<TreeNode> path){
        if(root==null)return false;

        path.add(root);
        if(root==dest){
            return true;  
        }
        
       if(getPath(root.left, dest, path) ||
       getPath(root.right, dest, path))
        return true;
        path.remove(path.size()-1);

        return false;

    }
}