package techdevguide

object Item05 {
    /*

Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)


maxSpan([1, 2, 1, 1, 3]) → 4
maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6

     */

    fun maxSpan(array: IntArray): Int {
        val map = LinkedHashMap<Int, Pair<Int, Int>>()
        array.forEachIndexed { index, i ->
            val pair = map[i]
            if (pair == null) {
                map[i] = index to index
            } else {
                map[i] = pair.first to index
            }
        }

        var maxSize = 0
        map.values.forEach { (start, end) ->
            val span = end - start + 1  // another off by one error!  span size of one appearance is 1, not 0
            if (span > maxSize) {
                maxSize = span
            }
        }
        return maxSize
    }

}