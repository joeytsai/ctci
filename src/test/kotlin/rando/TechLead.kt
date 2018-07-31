package rando

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TechLead {

    @Test
    fun simple() {
        val grid = colorGrid(listOf(listOf(Green, Blue, Blue)))
        assertEquals(Blue to 2, grid.maxConnected)
    }

    @Test
    fun simple2row() {
        val list = listOf(
                listOf(Green, Blue, Blue),
                listOf(Red, Red, Blue)
        )
        val grid = colorGrid(list)
        assertEquals(Blue to 3, grid.maxConnected)
    }

    @Test
    fun example() {
        val list = listOf(
                listOf(Green, Green, Blue, Red),
                listOf(Green, Blue, Red, Blue),
                listOf(Red, Blue, Blue, Blue)
        )
        val grid = colorGrid(list)
        assertEquals(Blue to 5, grid.maxConnected)
    }
}