package techdevguide

object Compression {
    /*
    The Challenge
In this exercise, you're going to decompress a compressed string.

Your input is a compressed string of the format number[string] and the decompressed output form should be the
string written number times. For example:

The input

3[abc]4[ab]c

Would be output as

abcabcabcababababc

Other rules
Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa

One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab

Characters allowed as input include digits, small English letters and brackets [ ].

Digits are only to represent amount of repetitions.

Letters are just letters.

Brackets are only part of syntax of writing repeated substring.

Input is always valid, so no need to check its validity.

Learning objectives
This question gives you the chance to practice with strings, recursion, algorithm, compilers, automata, and loops. It’s also an opportunity to work on coding with better efficiency.
     */
    fun decompress(input: String): String {
        val sb = StringBuilder()
        var index = 0
        while (index < input.length) {
            val c = input[index]
            if (Character.isDigit(c)) {
                val (dec, idx) = decompress(input, index)
                sb.append(dec)
                index = idx
            } else {
                sb.append(c)
                index++
            }
        }
        return sb.toString()
    }

    // read number
    // read brackets
    // read number of characters + index
    fun decompress(input: String, index: Int): Pair<String, Int> {
        var endIndex = index
        while (Character.isDigit(input[endIndex])) {
            endIndex++
        }
        val num = Integer.parseInt(input.substring(index, endIndex))
        // endIndex should be [
        // read a string until we find corresponding ]
        val bracketTextStart = endIndex + 1
        endIndex++
        var bracketStack = 1
        while (endIndex < input.length) {
            val c = input[endIndex]
            when (c) {
                '[' -> bracketStack++
                ']' -> bracketStack--
            }
            endIndex++
            if (bracketStack == 0) {
                val bracketText = input.substring(bracketTextStart, endIndex - 1)
                return expand(num, bracketText) to endIndex
            }
        }
        throw IllegalArgumentException("never found closing bracket? input=$input index=$index")
    }

    fun expand(times: Int, text: String): String {
        val sb = StringBuilder()
        (1..times).forEach { sb.append(decompress(text)) }
        return sb.toString()
    }
}