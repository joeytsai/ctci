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


    val nodesWithDupes by lazy {
        array2nodes(arrayOf(1, 2, 3, 4, 4, 2))
    }

    val nodesNoDupes by lazy {
        array2nodes(arrayOf(2, 5, 6, 8, 9, 7))
    }

    @Test
    fun foo() {
        println("no dupes = $nodesNoDupes")
        println("with dupes = $nodesWithDupes")
        Assert.assertNotEquals("these linked lists are not the same", nodesNoDupes, nodesWithDupes)

        val none = array2nodes(arrayOf(2, 5, 6, 8, 9, 7))
        Assert.assertEquals("these should be the same", none, nodesNoDupes)
    }

    @Test
    fun testRemoveDupes() {
        val removed = array2nodes(arrayOf(1, 2, 3, 4))
        Assert.assertEquals("function test", removed, Chapter02.removeDupes(nodesWithDupes))
        Assert.assertEquals("function'll do nutting -- Conor McGregor", nodesNoDupes, Chapter02.removeDupes(nodesNoDupes))
    }
}