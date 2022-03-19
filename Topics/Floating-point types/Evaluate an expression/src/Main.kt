const val CONSTANT_1 = 10.5
const val CONSTANT_2 = 4.4
const val CONSTANT_3 = 2.2

fun main() {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    val d = readLine()!!.toDouble()

    println(a * CONSTANT_1 + b * CONSTANT_2 + (c + d) / CONSTANT_3)
}