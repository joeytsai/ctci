package ctci.chapters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test


/**
 * Created by joey on 5/22/17.
 */
class Chapter02Test {

    private fun node(num: Int) = Chapter02.Node(num)
    private fun array2nodes(array: Array<Int>): Chapter02.Node<Int> {
        require(array.isNotEmpty())
        val nodes: Array<Chapter02.Node<Int>> = array.map { node(it) }.toTypedArray()
        nodes.indices
                .filter { it != nodes.lastIndex }
                .forEach { nodes[it].next = nodes[it + 1] }

        return nodes.first()
    }

    private fun <T> size(head: Chapter02.Node<T>): Int {
        var count = 0
        var curr: Chapter02.Node<T>? = head
        while (curr != null) {
            count += 1
            curr = curr.next
        }
        return count
    }


    val nodesWithDupes by lazy {
        array2nodes(arrayOf(1, 2, 3, 4, 4, 2))
    }

    val nodesNoDupes by lazy {
        array2nodes(arrayOf(2, 5, 6, 8, 9, 7))
    }

    @Test
    fun foo() {
        println("no dupes = $nodesNoDupes")
        println("no dupes = ${Chapter02.Node.prettyToString(nodesNoDupes)}")
        println("with dupes = $nodesWithDupes")
        println("with dupes = ${Chapter02.Node.prettyToString(nodesWithDupes)}")
        assertNotEquals(nodesNoDupes, nodesWithDupes, "these linked lists are not the same")

        val none = array2nodes(arrayOf(2, 5, 6, 8, 9, 7))
        assertEquals(none, nodesNoDupes, "these should be the same")
    }

    @Test
    fun testRemoveDupesInt() {
        val removed = array2nodes(arrayOf(1, 2, 3, 4))
        assertEquals(removed, Chapter02.removeDupesInt(nodesWithDupes), "function test")
        assertEquals(nodesNoDupes, Chapter02.removeDupesInt(nodesNoDupes), "function'll do nutting -- Conor McGregor")

        assertEquals(removed, Chapter02.removeDupes(nodesWithDupes), "function test")
        assertEquals(nodesNoDupes, Chapter02.removeDupes(nodesNoDupes), "function'll do nutting -- Conor McGregor")
    }

    @Test
    fun testRemoveDupesStrings() {
        val removeNothing = Chapter02.Node.fromList(listOf("a", "b", "C", "DE"))
        assertEquals(removeNothing, Chapter02.removeDupes(removeNothing), "remove nada")

        val removeSomething = Chapter02.Node.fromList(listOf("a", "a", "a"))
        assertEquals(Chapter02.Node("a"), Chapter02.removeDupes(removeSomething), "one element")
    }

    @Test
    fun testNoBuffer() {
        val removeNothing = Chapter02.Node.fromList(listOf("a", "b", "C", "DE"))
        Chapter02.removeDupesNoBuffer(removeNothing)
        assertEquals(4, size(removeNothing), "4 elements")

        val removeSomething = Chapter02.Node.fromList(listOf("a", "a", "a"))
        Chapter02.removeDupesNoBuffer(removeSomething)
        assertEquals(1, size(removeSomething), "one element")

        val ababacdcd = Chapter02.Node.from("a", "b", "a", "b", "a", "c", "d", "c", "d")
        assertEquals(9, ababacdcd.size, "before size")
        Chapter02.removeDupesNoBuffer(ababacdcd)
        assertEquals(4, ababacdcd.size, "before size")

    }
}