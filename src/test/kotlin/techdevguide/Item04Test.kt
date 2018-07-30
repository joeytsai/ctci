package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import techdevguide.Item04.stringSplosion

class Item04Test {
    @Test
    fun examples() {
        assertEquals("CCoCodCode", stringSplosion("Code"))
        assertEquals("aababc", stringSplosion("abc"))
        assertEquals("aab", stringSplosion("ab"))
    }
}