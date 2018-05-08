package rando

// https://techiedelight.quora.com/500-Data-Structures-and-Algorithms-practice-problems-and-their-solutions

fun `find pair with given sum in the array`(array: IntArray, sum: Int): Pair<Int, Int> {
    for (i in array.indices) {
        val first = array[i]
        for (j in i..array.lastIndex) {
            val second = array[j]
            val s = first + second
            if (s == sum) {
                return Pair(first, second)
            }
        }
    }
    throw RuntimeException("no pairs for sum=$sum in array=$array")
}