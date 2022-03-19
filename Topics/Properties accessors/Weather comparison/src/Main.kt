import java.lang.Integer.min

class City(val name: String, val defaultTemp: Int) {
    var degrees: Int = defaultTemp
    set(value) {
        field = if (value !in -92..57) defaultTemp else value
    }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai", 30)
    firstCity.degrees = first
    val secondCity = City("Moscow", 5)
    secondCity.degrees = second
    val thirdCity = City("Hanoi", 20)
    thirdCity.degrees = third

    //implement comparing here
    val coldest = if (firstCity.degrees < min(secondCity.degrees, thirdCity.degrees))
            firstCity.name
        else if (secondCity.degrees < min(firstCity.degrees, thirdCity.degrees))
            secondCity.name
        else if (thirdCity.degrees < min(firstCity.degrees, secondCity.degrees))
            thirdCity.name
        else
            "neither"
    print(coldest)
}