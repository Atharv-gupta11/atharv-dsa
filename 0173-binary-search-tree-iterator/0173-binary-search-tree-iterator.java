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
class BSTIterator {
    ArrayList<Integer> inorder;
    int idx;
    public BSTIterator(TreeNode root) {
        inorder=new ArrayList<>();
        idx=-1;
        solve(root);
    }

    void solve(TreeNode root){
        if(root==null)return;
        solve(root.left);
        inorder.add(root.val);
        solve(root.right);
    }
    
    public int next() {
        idx++;
        if(idx<inorder.size())return inorder.get(idx);
        return -1;
    }
    
    public boolean hasNext() {
        return idx<inorder.size()-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */