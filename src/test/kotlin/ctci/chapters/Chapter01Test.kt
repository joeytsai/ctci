package ctci.chapters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Created by joeyt on 8/19/16.
 */
class Chapter01Test {

    val uniqueTests = HashMap<String, Boolean>().apply {
        put("blah", true)
        put("foo", false)
        put("", true)
        put("abcdefghijkl", true)
        put("hamburge", true)
        put("hamburger", false)
    }

    @Test
    fun testAllUnique() {
        for ((input, expected) in uniqueTests) {
            assertEquals(expected, Chapter01.allUnique(input), "input=$input expected=$expected")
        }
    }

    @Test
    fun testAllUnique2() {
        for ((input, expected) in uniqueTests) {
            assertEquals(expected, Chapter01.allUnique2(input), "input=$input expected=$expected")
        }
    }

    @Test
    fun testAllUnique3() {
        for ((input, expected) in uniqueTests) {
            assertEquals(expected, Chapter01.allUnique3(input), "input=$input expected=$expected")
        }
    }

    val permutationTests = HashMap<Pair<String, String>, Boolean>().apply {
        put("foo" to "ofo", true)
        put("" to "1", false)
        put("aaah" to "aaai", false)
    }

    @Test
    fun testCheckPermutation() {
        for ((k, v) in permutationTests) {
            val (one, two) = k
            assertEquals(v, Chapter01.checkPermutation(one, two), "input=$k expected=$v")
        }
    }
}