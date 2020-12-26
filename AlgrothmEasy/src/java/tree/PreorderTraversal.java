package java.tree;

import java.base.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new LinkedList<Integer>();
        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                resultList.add(root.value);
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
        return resultList;

    }
}
