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
    class Info {
        TreeNode n;
        int row;

        public Info(TreeNode n, int r) {
            this.n = n;
            this.row = r;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int j = 0; j < sz; j++) {
                Info i = q.remove();
                TreeNode node = i.n;
                int r = i.row;
                int val = node.val;

                map.put(r, val);

                if (node.left != null) {
                    q.add(new Info(node.left, r + 1));
                }
                if (node.right != null) {
                    q.add(new Info(node.right, r + 1));
                }
            }
        }

        for (int k : map.keySet()) {
            ans.add(map.get(k));
        }
        return ans;
    }
}