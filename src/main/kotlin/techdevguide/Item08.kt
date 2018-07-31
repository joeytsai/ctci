package techdevguide

object Item08 {
    /*

Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.


canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([10, 10]) → true

     */
    fun canBalance(array: IntArray): Boolean {

        fun sum(start: Int, end: Int): Int {
            var sum = 0
            for (i in start..end) {
                sum += array[i]
            }
            return sum
        }

        var leftIdx = 0
        var rightIdx = array.lastIndex
        while (leftIdx < rightIdx) {
            val leftSum = sum(0, leftIdx)
            val rightSum = sum(rightIdx, array.lastIndex)
            when {
                leftSum < rightSum -> leftIdx++
                leftSum > rightSum -> rightIdx--
                else -> {
                    if (leftIdx + 1 == rightIdx) {
                        return true
                    }
                    leftIdx++
                    rightIdx--
                }
            }
        }
        return false
    }
}