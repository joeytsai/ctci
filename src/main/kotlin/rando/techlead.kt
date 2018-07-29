package rando

import java.util.*
import kotlin.collections.LinkedHashSet

// https://www.youtube.com/watch?v=IWvbPIYQPFM

sealed class Color
object Green : Color()
object Red : Color()
object Blue : Color()

data class Square(val neighbors: List<Square>, val color: Color)

data class ColorGrid(val array: ArrayList<ArrayList<Square>>) {
    private val map: Map<Color, List<Square>> by lazy {
        val map = LinkedHashMap<Color, MutableList<Square>>()
        for (row in array) {
            for (square in row) {
                val list: MutableList<Square> = map.getOrPut(square.color) { LinkedList() }
                list.add(square)
            }
        }
        map
    }

    fun colors(color: Color): List<Square> = map[color] ?: emptyList()

    val mostConnectedNeighbors: Color by lazy {
        var max = 0
        var maxColor: Color = Green
        for ((color, squares) in map) {
            for (square in squares) {
                val connected = findConnected(square)
                if (connected > max) {
                    max = connected
                    maxColor = color
                }
            }
        }
        maxColor
    }

    private fun findConnected(square: Square): Int {
        val colorSet = LinkedHashSet<Square>()
        val seenSet = LinkedHashSet<Square>()
        val next = mutableListOf(*square.neighbors.toTypedArray())
        for (neighbor in next) {
            if (neighbor.color == square.color) {
                colorSet.add(neighbor)
            }
        }
        return colorSet.size
    }
}