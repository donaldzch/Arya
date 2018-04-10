package binary.tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root != null)
            preorder(root, new StringBuilder());
        return result;
    }

    private void preorder(TreeNode node, StringBuilder sb) {

    }
}
