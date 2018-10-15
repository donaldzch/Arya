package binary.tree;

public class Serialize_and_Deserialize_BST_449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return null;
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;

            sb.append(root.val).append(" ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0)
                return null;

            int[] index = new int[]{0};
            String[] nodes = data.split(" ");
            return deserialize(nodes, index, Integer.MAX_VALUE);
        }

        private TreeNode deserialize(String[] nodes, int[] index, int upperBound) {
            int pos = index[0];
            if (pos >= nodes.length)
                return null;

            int val = Integer.valueOf(nodes[pos]);

            if (val > upperBound)
                return null;

            TreeNode node = new TreeNode(val);
            index[0]++;
            node.left = deserialize(nodes, index, val);
            node.right = deserialize(nodes, index, upperBound);

            return node;
        }
    }
}
