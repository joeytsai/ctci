package techdevguide

object Item06 {
    /*

Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".


withoutString("Hello there", "llo") → "He there"
withoutString("Hello there", "e") → "Hllo thr"
withoutString("Hello there", "x") → "Hello there"
     */

    fun withoutString(base: String, remove: String): String {
        val sb = StringBuilder()
        var i = 0
        while (i < base.length) {
            val sub = if (i + remove.length <= base.length)
                base.substring(i, i + remove.length)
            else
                ""
            if (sub.equals(remove, ignoreCase = true)) {
                i += remove.length
                continue
            } else {
                sb.append(base[i])
                i++
            }
        }
        return sb.toString()
    }
}