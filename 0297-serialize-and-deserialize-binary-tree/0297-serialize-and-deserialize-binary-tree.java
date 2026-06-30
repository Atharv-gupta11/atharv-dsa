/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode node = q.remove();

                if (node == null) {
                    sb.append('#');
                    sb.append(",");
                } else {
                    sb.append(node.val);

                    sb.append(",");

                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        String[] arr = data.split(",");
        
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));

        q.add(root);

        for(int i=1;i<arr.length;i++){
            TreeNode parent=q.remove();
            if(!arr[i].equals("#")){
                //left
                parent.left=new TreeNode(Integer.parseInt(arr[i]));
                q.add(parent.left);
            }
            if(!arr[++i].equals("#")){
                parent.right=new TreeNode(Integer.parseInt(arr[i]));
                q.add(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));