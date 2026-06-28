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
    class Node {
        int d;
        int row;
        int col;

        public Node(int d, int row, int col) {
            this.d = d;
            this.row = row;
            this.col = col;
        }
    }

    HashMap<Integer, List<Node>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, 0, 0);
        System.out.println(map);

        Map<Integer, List<Node>> sortedMap = new TreeMap<>(map);

        for (int k : sortedMap.keySet()) {
            List<Node> list = sortedMap.get(k);
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row)
                    return a.row - b.row; // row ascending

                return a.d - b.d; // same row -> value ascending
            });

            List<Integer> temp = new ArrayList<>();

            for (Node node : list)
                temp.add(node.d);

            ans.add(temp);
        }
        return ans;
    }

    void solve(TreeNode root, int col, int row) {
        if (root == null) {
            return;
        }
        if (map.containsKey(col)) {
            List<Node> l = map.get(col);
            Node nn = new Node(root.val, row, col);
            l.add(nn);
            map.put(col, l);
        } else {
            List<Node> l = new ArrayList<>();
            Node nn = new Node(root.val, row, col);
            l.add(nn);
            map.put(col, l);
        }
        solve(root.left, col - 1, row + 1);
        solve(root.right, col + 1, row + 1);
    }
}