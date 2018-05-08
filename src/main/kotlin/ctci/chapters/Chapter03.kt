package ctci.chapters

/**
 * Created by joey on 5/29/17.
 */
object Chapter03 {
    // Implement 3 stacks with one simple array
    interface Stack<T> {
        fun pop(): T
        fun push(item: T)
        fun peek(): T
        fun isEmpty(): Boolean
    }

    // All operations should operate in O(1)
    interface MinStack<T> : Stack<T> {
        fun min(): T
    }

    // Implement, internally use multiple stacks
    // have a threshold, when a stack exceeds start a new stack
    interface SetOfStacks<T> : Stack<T> {
        // follow up, performs the pop on a specific sub stack
        fun popAt(index: Int): T
    }
}

// first way that comes to mind is just having three entries
// may be inefficient if stack sizes vary wildly
class IntTripleStack() {

    var size: Int = 30
        set(value) {
            val oldSize = field
            if (value > oldSize) throw IllegalArgumentException("cannot downsize array")
            field = value
            val oldArray = array
            array = IntArray(value) { if (it < oldSize) oldArray[it] else 0 }
        }

    private var array = IntArray(size)

    inner class ArrayStack(val offset: Int) : Chapter03.Stack<Int> {
        private var stackIndex: Int = 0

        private fun arrayIndex() = stackIndex * 3 + offset

        override fun pop(): Int {
            if (stackIndex == 0) throw IllegalStateException("stack is empty (offset=$offset)")
            val i = arrayIndex()
            stackIndex -= 1
            return array[i]
        }

        override fun push(item: Int) {
            // TODO check size
            stackIndex += 1
            val i = arrayIndex()
            array[i] = item
        }

        override fun peek(): Int {
            val i = arrayIndex()
            return array[i]
        }

        override fun isEmpty(): Boolean {
            return stackIndex == 0
        }
    }

    // stacks
    val uno = ArrayStack(0)
    val dos = ArrayStack(1)
    val tres = ArrayStack(2)

    // TODO okay lets write some tests
}