package ctci.chapters

/**
 * Created by joey on 5/22/17.
 */
object Chapter02 {

    /**
     * 2.1 Remove duplicates from an unsorted linked list.
     * Follow-up, temporary buffer not allowed
     */

    data class Node<T>(val data: T, var next: Node<T>? = null)

    fun removeDupes(head: Node<Int>): Node<Int> {
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

}