package rando

// Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
fun longestWord(match: String, words: Set<String>): String {
    var longest = ""
    words.forEach {
        if (isSubsequence(it, match) && longest.length < it.length) {
            longest = it
        }
    }

    return longest
}

fun isSubsequence(word: String, match: String): Boolean {
    var wordIdx = 0
    var matchIdx = 0
    while (wordIdx < word.length && matchIdx < match.length) {
        val w: Char = word[wordIdx]
        val m: Char = match[matchIdx]
        if (w == m) {
            if (wordIdx == word.lastIndex) {
                return true
            }
            wordIdx++
            matchIdx++
        } else {
            matchIdx++
        }
    }
    return false

}
