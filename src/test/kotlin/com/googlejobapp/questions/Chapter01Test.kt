package com.googlejobapp.questions

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by joeyt on 8/19/16.
 */
class Chapter01Test {

    val tests = HashMap<String, Boolean>().apply {
        put("blah", true)
        put("foo", false)
        put("", true)
        put("abcdefghijkl", true)
        put("hamburge", true)
        put("hamburger", false)
    }
    @Test
    fun testAllUnique() {
        for ((input, expected) in tests) {
            Assert.assertEquals("input=$input expected=$expected", expected, Chapter01.allUnique(input))
        }
    }

    @Test
    fun testAllUnique2() {
        for ((input, expected) in tests) {
            Assert.assertEquals("input=$input expected=$expected", expected, Chapter01.allUnique2(input))
        }
    }
}