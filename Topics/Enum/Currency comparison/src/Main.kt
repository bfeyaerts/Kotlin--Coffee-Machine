fun main() {
    val (country1, country2) = readLine()!!.split(" ").map { it.uppercase() }
    try {
        println(Currency.valueOf(country1).currency == Currency.valueOf(country2).currency)
    } catch (e: java.lang.IllegalArgumentException) {
        println("false")
    }
}

enum class Currency(val currency: String) {
    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian real"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar"),

}