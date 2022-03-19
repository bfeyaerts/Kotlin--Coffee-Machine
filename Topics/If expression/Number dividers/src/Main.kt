fun main() {
    val number = readLine()!!.toInt()
    val divisors = listOf(2, 3, 5, 6)
    for (m in divisors) {
        if (number % m == 0)
            println("Divided by $m")
    }
}