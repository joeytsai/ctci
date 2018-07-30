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
            val sub = s.subSequence(0, i + 1)
            sb.append(sub)
        }
        return sb.toString()
    }
}