package java.tree;

import java.base.AlgorithmBase;
import java.base.TreeNode;

/**
 * 找出克隆二叉树中的相同节点
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 *
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 *
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyTree extends AlgorithmBase {
    @Override
    protected void doExecute() {

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || target == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode resultNode = null;
        resultNode = getTargetCopy(original.left, cloned.left, target);
        if (resultNode == null) {
            resultNode = getTargetCopy(original.right, cloned.right, target);
        }
        return resultNode;
    }
}
