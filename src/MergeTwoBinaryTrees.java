import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class MergeTwoBinaryTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Stack<TreeNode[]> treeNodes = new Stack<>();
        treeNodes.push(new TreeNode[]{t1, t2});

        while (!treeNodes.empty()) {
            TreeNode[] nodes = treeNodes.pop();
            if (nodes[0] == null || nodes[1] == null) {
                continue;
            }
            nodes[0].val += nodes[1].val;
            if (nodes[0].left == null) {
                nodes[0].left = nodes[1].left;
            } else {
                treeNodes.push(new TreeNode[] {nodes[0].left, nodes[1].left});
            }
            if (nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            } else {
                treeNodes.push(new TreeNode[] {nodes[0].right, nodes[1].right});
            }
        }
        return t1;
    }

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode newNode = new TreeNode(0);

        Stack<TreeNode[]> treeNodes = new Stack<>();
        treeNodes.push(new TreeNode[]{t1, t2, newNode});

        while (!treeNodes.empty()) {
            TreeNode[] nodes = treeNodes.pop();
            if (nodes[0] == null) {
                nodes[2] = nodes[1];
                continue;
            } else if (nodes[1] == null) {
                nodes[2] = nodes[0];
                continue;
            }
            nodes[2].val = nodes[0].val + nodes[1].val;
            if (nodes[0].left == null) {
                nodes[2].left = nodes[1].left;
            } else if (nodes[1].left == null) {
                nodes[2].left = nodes[0].left;
            } else {
                nodes[2].left = new TreeNode(0);
                treeNodes.push(new TreeNode[] {nodes[0].left, nodes[1].left, nodes[2].left});
            }

            if (nodes[0].right == null) {
                nodes[2].right = nodes[1].right;
            } else if (nodes[1].right == null) {
                nodes[2].right = nodes[0].right;
            } else {
                nodes[2].right = new TreeNode(0);
                treeNodes.push(new TreeNode[] {nodes[0].right, nodes[1].right, nodes[2].right});
            }
        }
        return newNode;
    }

    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }


        public static TreeNode stringToTreeNode(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return null;
            }

            String[] parts = input.split(",");
            String item = parts[0];
            TreeNode root = new TreeNode(Integer.parseInt(item));
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);

            int index = 1;
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int leftNumber = Integer.parseInt(item);
                    node.left = new TreeNode(leftNumber);
                    nodeQueue.add(node.left);
                }

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int rightNumber = Integer.parseInt(item);
                    node.right = new TreeNode(rightNumber);
                    nodeQueue.add(node.right);
                }
            }
            return root;
        }

        public static String treeNodeToString(TreeNode root) {
            if (root == null) {
                return "[]";
            }

            String output = "";
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();

                if (node == null) {
                    output += "null, ";
                    continue;
                }

                output += String.valueOf(node.val) + ", ";
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
            }
            return "[" + output.substring(0, output.length() - 2) + "]";
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                TreeNode t1 = stringToTreeNode(line);
                line = in.readLine();
                TreeNode t2 = stringToTreeNode(line);

                TreeNode ret = new MergeTwoBinaryTrees().mergeTrees1(t1, t2);

                String out = treeNodeToString(ret);

                System.out.print(out);
            }
        }

}
