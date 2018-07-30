package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import techdevguide.Item05.maxSpan

class Item05Test {

    @Test
    fun example() {
        assertEquals(4, maxSpan(intArrayOf(1, 2, 1, 1, 3)))
        assertEquals(6, maxSpan(intArrayOf(1, 4, 2, 1, 4, 1, 4)))
        assertEquals(6, maxSpan(intArrayOf(1, 4, 2, 1, 4, 4, 4)))
    }
}