package java.tree;

import java.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        int num = 0;
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        nextLevel(root, num, result);
        return result;
    }

    private void nextLevel(TreeNode root, int num, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        List<Integer> list;
        if (result.size() > num) {
            list = result.get(num);
        } else {
            list = new LinkedList<Integer>();
            result.add(num, list);
        }
        list.add(root.value);
        nextLevel(root.left, num + 1, result);
        nextLevel(root.right, num + 1, result);
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode tempNote = root;
        while (list.size() != 0) {
            
        }
        return result;
    }
}
