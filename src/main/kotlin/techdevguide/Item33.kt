package techdevguide

object Item33 {
    /*
    Implement Minesweeper
Minesweeper is a game where the objective is correctly identify the location of all mines in a given grid.
You are given a uniform grid of gray squares in the beginning of the game.
Each square contains either a isMine (indicated by a value of 9), or an empty square.
Empty squares have a number indicating the count of mines in the adjacent squares.
Empty squares can have counts from zero (no adjacent mines) up to 8 (all adjacent squares are mines).

If you were to take a complete grid, for example, you can see which squares have mines and which squares are empty:

0  0  0  0  0
0  0  0  0  0
1  1  1  0  0
1  9  1  0  0
1  2  2  1  0
0  1  9  1  0
0  1  1  1  0

The squares with "2" indicate that there 2 mines adjacent to that particular square.

Gameplay starts with a user un-hiding a square at random. If the square contains a isMine, the game ends.
If it is a blank, the number of adjacent mines is revealed.

Exposing a zero means that there are no adjacent mines, so exposing all adjacent squares is guaranteed safe.
As a convenience to the player, the game continues to expose adjacent squares until a non-zero square is reached.

For example, if you click on the top right corner you num this ('-' means hidden):

0  0  0  0  0
0  0  0  0  0
1  1  1  0  0
-  -  1  0  0
-  -  2  1  0
-  -  -  1  0
-  -  -  1  0

Please write functions to construct the playing field given the size and number of mines.

Note: You can suppose that you have a Matrix class that looks like this:

template<typename T>
class Matrix {
  void resize(int rows, int cols);
  T& at(int row, int col);
  int rows();
  int cols();
};

Or, if your language supports an idiomatic way to express matrices, you may use that instead.
The goal is to expose safe squares correctly, not demonstrate facility with matrix classes or arrays.

Learning objectives
This question gives you the chance to practice using Java to design and use a simple class,
implement an appropriate search algorithm, and use if-then. It also touches on leveraging work that’s already done.

     */

    data class Coord(val row: Int, val col: Int)
    class Mineboard(val mines: Set<Coord>, val rows: Int, val cols: Int) {
        val matrix: Array<IntArray> by lazy {
            val m = Array(rows) { IntArray(cols) }  // everything set to zero
            for (mine in mines) {
                m[mine.row][mine.col] = 9
            }
            for (r in 0 until rows) {
                for (c in 0 until cols) {
                    if (m[r][c] != 9) {
                        m[r][c] = neighbors(Coord(r, c)).filter { m[it.row][it.col] == 9 }.count()
                    }
                }
            }
            m
        }

        // return up to 8 neighbors (min 3 for corner)
        fun neighbors(coord: Coord): List<Coord> {
            val set = LinkedHashSet<Coord>()
            for (r in -1..1) {
                for (c in -1..1) {
                    set.add(Coord(coord.row + r, coord.col + c))
                }
            }
            return set.filter { isValid(it) && it != coord }
        }

        fun isValid(coord: Coord) = coord.row in 0 until rows && coord.col in 0 until cols

        override fun toString(): String {
            val sb = StringBuilder()
            for (r in 0 until rows) {
                val row = matrix[r]
                sb.append(row.joinToString(separator = " ", postfix = "\n"))
            }
            return sb.toString()
        }

        fun num(coord: Coord): Int = matrix[coord.row][coord.col]

        fun connected(coord: Coord): List<Coord> {
            if (!isValid(coord)) return emptyList()
            val num = num(coord)
            val neighbors = neighbors(coord).filter { num(it) == num }
            val connected = LinkedHashSet<Coord>().apply { add(coord) }
            val next = LinkedHashSet<Coord>(neighbors)
            while (next.isNotEmpty()) {
                val first = next.first()
                next.remove(first)

                if (first !in connected) {
                    connected.add(first)
                    val connectedToNeighbor = neighbors(first).filter { num(it) == num }
                    next.addAll(connectedToNeighbor)
                }
            }

            return connected.toList()
        }
    }
}