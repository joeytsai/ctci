package ctci.chapters

import org.junit.Assert
import org.junit.Test

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
        Assert.assertNotEquals("these linked lists are not the same", nodesNoDupes, nodesWithDupes)

        val none = array2nodes(arrayOf(2, 5, 6, 8, 9, 7))
        Assert.assertEquals("these should be the same", none, nodesNoDupes)
    }

    @Test
    fun testRemoveDupesInt() {
        val removed = array2nodes(arrayOf(1, 2, 3, 4))
        Assert.assertEquals("function test", removed, Chapter02.removeDupesInt(nodesWithDupes))
        Assert.assertEquals("function'll do nutting -- Conor McGregor", nodesNoDupes, Chapter02.removeDupesInt(nodesNoDupes))

        Assert.assertEquals("function test", removed, Chapter02.removeDupes(nodesWithDupes))
        Assert.assertEquals("function'll do nutting -- Conor McGregor", nodesNoDupes, Chapter02.removeDupes(nodesNoDupes))
    }

    @Test
    fun testRemoveDupesStrings() {
        val removeNothing = Chapter02.Node.fromList(listOf("a", "b", "C", "DE")) ?: throw IllegalArgumentException("fromList() returned null")
        Assert.assertEquals("remove nada", removeNothing, Chapter02.removeDupes(removeNothing))

        val removeSomething = Chapter02.Node.fromList(listOf("a", "a", "a")) ?: throw IllegalArgumentException("no null")
        Assert.assertEquals("one element", Chapter02.Node("a"), Chapter02.removeDupes(removeSomething))
    }

    @Test
    fun testNoBuffer() {
        val removeNothing = Chapter02.Node.fromList(listOf("a", "b", "C", "DE")) ?: throw IllegalArgumentException("fromList() returned null")
        Chapter02.removeDupesNoBuffer(removeNothing)
        Assert.assertEquals("4 elements", 4, size(removeNothing))

        val removeSomething = Chapter02.Node.fromList(listOf("a", "a", "a")) ?: throw IllegalArgumentException("no null")
        Chapter02.removeDupesNoBuffer(removeSomething)
        Assert.assertEquals("one element", 1, size(removeSomething))
    }
}