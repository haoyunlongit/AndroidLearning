package java.tree

import java.base.TreeNode
import java.util.*


class TwoTreeToAllElements {
    fun getAllElements(root1: TreeNode?): List<Int?> {
        val list: MutableList = LinkedList<Any?>()
        val stack = Stack<TreeNode>()
        if (root == null) {
            return list
        }
        var tempNode: TreeNode? = root
        while (!stack.isEmpty() || tempNode != null) {
            if (tempNode != null) {
                stack.push(tempNode)
                tempNode = tempNode.left
            } else {
                tempNode = stack.pop()
                list.add(tempNode.`val`)
                tempNode = tempNode.right
            }
        }
        return list

    }
}

fun main() {

}