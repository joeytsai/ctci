package com.googlejobapp.questions

import org.junit.Assert
import org.junit.Test
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
            Assert.assertEquals("input=$input expected=$expected", expected, Chapter01.allUnique(input))
        }
    }

    @Test
    fun testAllUnique2() {
        for ((input, expected) in uniqueTests) {
            Assert.assertEquals("input=$input expected=$expected", expected, Chapter01.allUnique2(input))
        }
    }

    @Test
    fun testAllUnique3() {
        for ((input, expected) in uniqueTests) {
            Assert.assertEquals("input=$input expected=$expected", expected, Chapter01.allUnique3(input))
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
            Assert.assertEquals("input=$k expected=$v", v, Chapter01.checkPermutation(one, two))
        }
    }
}