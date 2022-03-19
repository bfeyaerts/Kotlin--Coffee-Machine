fun main() {    
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val h = readLine()!!.toInt()

    if (h in a..b)
        println("Normal")
    else if (h < a)
        println("Deficiency")
    else
        println("Excess")
}