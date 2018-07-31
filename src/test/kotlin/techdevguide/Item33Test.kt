package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import techdevguide.Item33.Coord
import techdevguide.Item33.Mineboard

class Item33Test {
    val exampleBoard = Mineboard(setOf(Coord(3, 1), Coord(5, 2)), 7, 5)
    @Test
    fun tryitout() {
        /**
        0  0  0  0  0
        0  0  0  0  0
        1  1  1  0  0
        1  9  1  0  0
        1  2  2  1  0
        0  1  9  1  0
        0  1  1  1  0
         */
        println(exampleBoard)
    }

    @Test
    fun tryConnected() {
        val one = exampleBoard.connected(Coord(3, 1))
        assertEquals(1, one.size)

        val two = exampleBoard.connected(Coord(5, 0))
        assertEquals(2, two.size)

        val twotwo = exampleBoard.connected(Coord(4, 1))
        assertEquals(2, twotwo.size)

        val zeros = exampleBoard.connected(Coord(0, 0))
        println(zeros)
        assertEquals(17, zeros.size)
    }
}