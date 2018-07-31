package techdevguide

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import techdevguide.Compression.decompress

class CompressionTest {

    @Test
    fun examples() {
        assertAll(
                { assertEquals("abcabcabcababababc", decompress("3[abc]4[ab]c")) },
                { assertEquals("aaaaaaaaaa", decompress("10[a]")) },
                { assertEquals("aaabaaab", decompress("2[3[a]b]")) }
        )
    }

    @Test
    fun compressionFun() {
        println("foo13[aa]5[x3[y]2[zz]]->${decompress("foo13[aa]5[x3[y]2[zz]]")}")
    }
}