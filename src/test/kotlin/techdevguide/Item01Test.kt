package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import techdevguide.Item01.isSubsequence
import techdevguide.Item01.longestWord

internal class Item01Test {
    private val exampleS = "abppplee"
    @Test
    fun examples() {
        val d = setOf("able", "ale", "apple", "bale", "kangaroo")

        val actual = longestWord(exampleS, d)
        assertEquals("apple", actual)
    }

    @Test
    fun subsequence() {
        assertTrue(isSubsequence("able", exampleS))
        assertTrue(isSubsequence("ale", exampleS))
        assertTrue(isSubsequence("apple", exampleS))
        assertFalse(isSubsequence("bale", exampleS))
        assertFalse(isSubsequence("kangaroo", exampleS))
    }
}