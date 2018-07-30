package techdevguide


/*
Given a non-empty string like "Code" return a string like "CCoCodCode".

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
 */

object Item04 {
    fun stringSplosion(s: String): String {
        val sb = StringBuilder()
        for (i in s.indices) {
            val sub = s.substring(0, i + 1)  // Ugh, a off-by-one error.  .subSequence() endIndex is not inclusive
            sb.append(sub)
        }
        return sb.toString()
    }
}