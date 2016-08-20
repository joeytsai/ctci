package com.googlejobapp.questions

import java.util.*

/**
 * Created by joeyt on 8/19/16.
 */
object Chapter01 {

    fun allUnique(input: String): Boolean {
        val set = HashSet<Char>()
        for (c in input) {
            if (c in set) return false
            set.add(c)
        }
        return true
    }

    // cannot use additional data structures
    fun allUnique2(input: String): Boolean {
        for ((idx, c) in input.withIndex()) {
            for ((j, c2) in input.withIndex()) {
                if (idx == j) continue
                if (c == c2) return false
            }
        }
        return true
    }

    /*
     * Might have done this wrong lol
     * Remember to ask the character set of the string
     * Thought of sorting, but that seemed like as much magic as using a HashSet
     */

    fun allUnique3(input: String): Boolean {
        val list = input.toMutableList()
        Collections.sort(list)
        for (i in list.indices) {
            if (i == 0) continue
            if (list[i-1] == list[i]) return false
        }
        return true
    }

    fun checkPermutation(input1: String, input2: String): Boolean {
        if (input1.length != input2.length) return false
        val list1 = input1.toMutableList()
        val list2 = input2.toMutableList()
        Collections.sort(list1)
        Collections.sort(list2)
        for ((i, c) in list1.withIndex()) {
            if (c != list2[i]) return false
        }
        return true
    }
}