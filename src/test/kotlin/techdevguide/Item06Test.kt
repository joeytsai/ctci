package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import techdevguide.Item06.withoutString

class Item06Test {
    @Test
    fun example() {
        /*

Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".


withoutString("Hello there", "llo") → "He there"
withoutString("Hello there", "e") → "Hllo thr"
withoutString("Hello there", "x") → "Hello there"
         */
        assertEquals("He there", withoutString("Hello there", "llo"))
        assertEquals("Hllo thr", withoutString("Hello there", "e"))
        assertEquals("Hello there", withoutString("Hello there", "x"))
    }
}