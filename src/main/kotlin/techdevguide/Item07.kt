package techdevguide

object Item07 {
    /*
    Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)


sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18

     */
    fun sumNumbers(s: String): Int {
        var sum = 0
        var index = 0
        while (index < s.length) {
            val c = s[index]
            if (Character.isDigit(c)) {
                var endIndex = index + 1
                while (endIndex < s.length && Character.isDigit(s[endIndex])) {
                    endIndex++
                }
                sum += Integer.parseInt(s.substring(index, endIndex))
                index = endIndex
            } else {
                index++
            }
        }
        return sum
    }
}