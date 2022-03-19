fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    if (a + b > c && b + c > a && a + c > b)
        println("YES")
    else
        println("NO")
}