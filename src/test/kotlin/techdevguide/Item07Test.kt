package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import techdevguide.Item07.sumNumbers

class Item07Test {
    @Test
    fun examples() {
        /*
        Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)


sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18

         */

        assertEquals(123, sumNumbers("abc123xyz"))
        assertEquals(44, sumNumbers("aa11b33"))
        assertEquals(18, sumNumbers("7 11"))
    }
}