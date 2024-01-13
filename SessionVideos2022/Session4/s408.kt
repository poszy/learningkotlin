// USE WITH CAUTION

// useful operator overloads
//    contains() -> use "in" and "!in" operators - great for data structure
//    get(index, ...)/set(index, ..., value) - great for matrix-like structures

data class Matrix(val rows: Int, val columns: Int) {
    private val data = MutableList<Int>(rows * columns) { -1 }

    private fun indexFor(row: Int, column: Int) =
            (row-1)*columns + (column-1)

    operator fun get(row: Int, column: Int): Int { // 1 based instead of 0
        return data[indexFor(row, column)]
    }
    operator fun set(row: Int, column: Int, value: Int) { // 1 based instead of 0
        data[indexFor(row, column)] = value
    }

    override fun toString(): String {
        return "Matrix(rows=$rows, columns=$columns, data=$data)"
    }

    operator fun contains(value: Int): Boolean {
        return value in data
//        calls data.contains(value)
    }
}

fun main() {
    val matrix = Matrix(2,3)

    matrix[1,1] = 42
    matrix[1,2] = 24
    println(matrix)
    println(matrix[1,1])

    println(10 in matrix)
    println(24 in matrix)
    pr
