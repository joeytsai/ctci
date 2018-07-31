package techdevguide

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import techdevguide.Item08.canBalance

class Item08Test {
    @Test
    fun examples() {
        /*

Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.


canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([10, 10]) → true

         */

        assertTrue(canBalance(intArrayOf(1, 1, 1, 2, 1)))
        assertFalse(canBalance(intArrayOf(2, 1, 1, 2, 1)))
        assertTrue(canBalance(intArrayOf(10, 10)))
    }
}