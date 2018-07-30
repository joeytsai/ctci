package techdevguide

object Item01 {

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
            }
            matchIdx++
        }
        return false
    }


// Hint 2
// If you know how to check for subsequences, and are trying to optimize:
// Can you preprocess S in some way to make checking dictionary words against it very efficient?

// https://en.wikipedia.org/wiki/Trie
// Trie *feels* like the right solution, but solution still O(n)
// Would win if S is larger than elements in D

// Hint 3
// Consider how you might apply a greedy algorithm here. Is it possible to even improve on its efficiency?

// Try the elements in D in order of longest to shortest, you can stop at the first match


// After reading the answer, turns out I hadn't considered the brute force approach of creating all substrings

}
