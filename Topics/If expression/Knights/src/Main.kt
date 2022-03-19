import kotlin.math.abs

fun main() {
    // write your code here
    val (x1, y1) = readLine()!!.split(" ").map { it.toInt() }
    val (x2, y2) = readLine()!!.split(" ").map { it.toInt() }

    if (abs(x1 - x2) == 1) {
        if (abs(y1 - y2) == 2)
            println("YES")
        else
            println("NO")
    } else if (abs(x1 - x2) == 2) {
        if (abs(y1 - y2) == 1)
            println("YES")
        else
            println("NO")
    } else
        println("NO")
}