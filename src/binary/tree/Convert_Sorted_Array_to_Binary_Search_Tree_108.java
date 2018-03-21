package binary.tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int low , int high) {
        if (low >high)
            return null;

        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createTree(nums, low, mid - 1);
        node.right = createTree(nums, mid + 1, high);
        return node;
    }

}
