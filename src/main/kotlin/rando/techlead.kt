package rando

import java.util.*
import kotlin.collections.LinkedHashSet

// https://www.youtube.com/watch?v=IWvbPIYQPFM
// 5:20

sealed class Color
object Green : Color()
object Red : Color()
object Blue : Color()

// Given a grid of colors, find the maximum number of connected colors
data class Coord(val row: Int, val col: Int)

data class Connected(val color: Color, val connected: Set<Coord>)
class ColorGrid(val colors: Array<Array<Color>>) {
    val rows = colors.size
    val cols = colors[0].size

    init {
        for (row in colors) {
            if (row.size != cols) {
                throw IllegalArgumentException("all cols must be same size, expecting $cols")
            }
        }
    }

    fun neighbors2(coord: Coord): List<Coord> {
        if (!isValid(coord)) return emptyList()
        val list = ArrayList<Coord>()
        for (r in -1..1) {
            for (c in -1..1) {
                list.add(Coord(coord.row + r, coord.col + c))
            }
        }
        return list.filter { isValid(it) && it != coord }
    }

    fun neighbors(coord: Coord): List<Coord> {
        return listOf(
                coord.copy(row = coord.row - 1),
                coord.copy(row = coord.row + 1),
                coord.copy(col = coord.col - 1),
                coord.copy(col = coord.col + 1)
        ).filter { isValid(it) }
    }

    private fun isValid(coord: Coord) = coord.row in 0 until rows && coord.col in 0 until cols

    private fun color(coord: Coord): Color = colors[coord.row][coord.col]

    val allConnected: Set<Connected> by lazy {
        val set = LinkedHashSet<Connected>()
        val seen = LinkedHashSet<Coord>()
        colors.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, color ->
                val coord = Coord(rowIndex, colIndex)
                if (coord !in seen) {
                    seen.add(coord)
                    val connected = connected(coord)
                    seen.addAll(connected)
                    set.add(Connected(color, connected))
                }
            }
        }
        set
    }

    private fun connected(coord: Coord): Set<Coord> {
        val set = LinkedHashSet<Coord>()
        val next = LinkedHashSet<Coord>()
        next.add(coord)
        val color = color(coord)
        while (next.isNotEmpty()) {
            val first = next.first()
            next.remove(first)
            if (first !in set) {
                set.add(first)
                val connectedNeighbors = neighbors(first).filter { color == color(it) }
                next.addAll(connectedNeighbors)
            }
        }
        return set
    }

    val maxConnected: Pair<Color, Int> by lazy {
        var max = 0
        var color: Color = Green
        allConnected.forEach {
            if (it.connected.size > max) {
                max = it.connected.size
                color = it.color
            }
        }
        color to max
    }
}

fun colorGrid(list: List<List<Color>>) = ColorGrid(Array(list.size) { list[it].toTypedArray() })