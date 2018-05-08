package rando

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Techiedelight_quoraKtTest {
    @Test
    fun testArraySum() {
        val array = intArrayOf(1, 2, 3, 4)
        val pair24 = `find pair with given sum in the array`(array, 6)
        assertEquals(Pair(2, 4), pair24)

    }
}