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

}