package ctci.chapters

/**
 * Created by joey on 5/22/17.
 */
object Chapter02 {

    /**
     * 2.1 Remove duplicates from an unsorted linked list.
     * Follow-up, temporary buffer not allowed
     */

    // made a data class for auto-toString()
    data class Node<T>(val data: T, var next: Node<T>? = null) {
        companion object {
            fun <T> toArrayList(head: Node<T>): ArrayList<T> {
                val list = ArrayList<T>()
                var curr: Node<T>? = head
                while (curr != null) {
                    list.add(curr.data)
                    curr = curr.next
                }
                return list
            }

            fun <T> prettyToString(head: Node<T>) = toArrayList(head).joinToString(separator = " -> ")

            fun <T> fromList(list: List<T>): Node<T>? {
                if (list.isEmpty()) return null
                val nodes: Array<Node<T>> = list.map { Node(it) }.toTypedArray()
                nodes.forEachIndexed { index, node ->
                    if (index != list.lastIndex) {
                        node.next = nodes[index + 1]
                    }
                }
                return nodes.first()
            }

        }
    }

    // first naive version, uses a set and copies return linked list of ints
    fun removeDupesInt(head: Node<Int>): Node<Int> {
        val set = LinkedHashSet<Int>()
        val list = Node(head.data)
        var ptr: Node<Int> = list
        var curr: Node<Int>? = head.next
        while (curr != null) {
            if (curr.data !in set) {
                set.add(curr.data)
                val new = Node(curr.data)
                ptr.next = new
                ptr = new
            }
            curr = curr.next
        }
        return list
    }

    // first naive version, uses a set and copies return linked list of ints
    fun <T> removeDupes(head: Node<T>): Node<T> {
        val set = LinkedHashSet<T>()
        val list = Node(head.data)
        set.add(head.data)
        var ptr: Node<T> = list
        var curr: Node<T>? = head.next
        while (curr != null) {
            if (curr.data !in set) {
                set.add(curr.data)
                val new = Node(curr.data)
                ptr.next = new
                ptr = new
            }
            curr = curr.next
        }
        return list
    }
}