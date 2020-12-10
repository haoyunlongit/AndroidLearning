package java.tree;

import java.base.ListNode;
import java.base.TreeNode;
import java.util.LinkedList;

//给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
//
//添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
//
//将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
//
//如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树
//
public class Solution {
    /**
     * 没考虑到的地方
     * 1 ：第一次出错，多遍历了一层
     * 2 ：第二次出错，因为数组可以添加空元素
     */

    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if(d < 1) {
            return null;
        }

        if (d == 1) {
            TreeNode rootNode = new TreeNode(v);
            rootNode.left = root;
            return rootNode;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        for (int i = 0; i < d - 2; i++) {
            LinkedList<TreeNode> currentListNode = new LinkedList<TreeNode>();
            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    currentListNode.add(node.left);
                }

                if (node.right != null) {
                    currentListNode.add(node.right);
                }
            }
            nodeList.clear();
            nodeList.addAll(currentListNode);
        }

        for (TreeNode listNode : nodeList) {
            TreeNode left = listNode.left;
            listNode.left = new TreeNode(v);
            listNode.left.left = left;

            TreeNode right = listNode.right;
            listNode.right = new TreeNode(v);
            listNode.right.right = right;
        }

        return root;
    }

    //递归方式
    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        if(d < 1) {
            return null;
        }

        if (d == 1) {
            TreeNode rootNode = new TreeNode(v);
            rootNode.left = root;
            return rootNode;
        }

        findTreeNode(root, v, d - 1);
        return root;
    }

    public void findTreeNode(TreeNode node, int v ,int d) {
        if (node == null) {
            return;
        }

        if (d == 0) {
            TreeNode left = node.left;
            node.left = new TreeNode(v);
            node.left.left = left;

            TreeNode right = node.right;
            node.right = new TreeNode(v);
            node.right.right = right;
            return;
        }
        findTreeNode(node.left, v, d-1);
        findTreeNode(node.right, v, d-2);
    }

    public static void main(String[] args) {

    }
}
