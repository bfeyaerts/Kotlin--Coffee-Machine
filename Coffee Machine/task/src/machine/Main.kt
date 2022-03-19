package machine

const val WATER_INITIAL_ML = 400
const val MILK_INITIAL_ML = 540
const val BEANS_INITIAL_G = 120
const val CUPS_INITIAL = 9
const val MONEY_INITIAL = 550

object CoffeeMachine {
    private var water_ml: Int = WATER_INITIAL_ML
    private var milk_ml: Int = MILK_INITIAL_ML
    private var beans_g: Int = BEANS_INITIAL_G
    private var cups: Int = CUPS_INITIAL
    private var money: Int = MONEY_INITIAL

    enum class Action {
        SELECT,
        BUY,
        FILL,
        TAKE,
        EXIT,
        REMAINING
    }

    enum class Filling(val unit: String, val label: String) {
        WATER("ml", "water"),
        MILK("ml", "milk"),
        BEANS("grams", "coffee beans"),
        CUPS("disposable cups", "coffee"),
    }

    enum class Coffee(val water_ml: Int,
                      val milk_ml: Int,
                      val beans_g: Int,
                      val cost: Int) {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6)
    }

    private var action: Action = Action.SELECT
    private var filling: Filling = Filling.WATER

    fun process(input: String) {
        when(action) {
            Action.SELECT -> {
                when (Action.valueOf(input.uppercase())) {
                    Action.BUY -> printBuyMenu()
                    Action.FILL -> printFillPrompt(Filling.WATER)
                    Action.TAKE -> {
                        doTake()
                        printSelectionMenu()
                    }
                    Action.REMAINING -> {
                        printRemaining()
                        printSelectionMenu()
                    }
                }
            }
            Action.BUY -> {
                if (input != "back") {
                    buy(Coffee.values()[input.toInt() - 1])
                }
                printSelectionMenu()
            }
            Action.FILL -> {
                when (filling) {
                    Filling.WATER -> {
                        water_ml += input.toInt()
                        printFillPrompt(Filling.MILK)
                    }
                    Filling.MILK -> {
                        milk_ml += input.toInt()
                        printFillPrompt(Filling.BEANS)
                    }
                    Filling.BEANS -> {
                        beans_g += input.toInt()
                        printFillPrompt(Filling.CUPS)
                    }
                    Filling.CUPS -> {
                        cups += input.toInt()
                        printSelectionMenu()
                    }
                }
            }
        }
    }

    fun printSelectionMenu() {
        action = Action.SELECT
        println()
        print("Write action (buy, fill, take, remaining, exit): ")
    }

    private fun printBuyMenu() {
        action = Action.BUY
        println()
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    }

    private fun printFillPrompt(filling: Filling) {
        CoffeeMachine.filling = filling
        action = Action.FILL
        println()
        print("Write how many ${filling.unit} of ${filling.label} do you want to add: ")
    }

    private fun doTake() {
        println()
        println("I gave you $$money")
        money = 0
    }

    private fun printRemaining() {
        println()
        println("The coffee machine has:")
        println("$water_ml ml of water")
        println("$milk_ml ml of milk")
        println("$beans_g g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
    }

    private fun buy(coffee: Coffee) {
        if (water_ml < coffee.water_ml)
            println("Sorry, not enough water!")
        else if (milk_ml < coffee.milk_ml)
            println("Sorry, not enough milk!")
        else if (beans_g < coffee.beans_g)
            println("Sorry, not enough coffee beans!")
        else if (cups < 1)
            println("Sorry, not enough disposable cups!")
        else {
            println("I have enough resources, making you a coffee!")

            water_ml -= coffee.water_ml
            milk_ml -= coffee.milk_ml
            beans_g -= coffee.beans_g
            cups--
            money += coffee.cost
        }
    }
}

fun main() {
    CoffeeMachine.printSelectionMenu()
    while (true) {
        when (val action = readLine()!!) {
            "exit" -> return
            else -> CoffeeMachine.process(action)
        }
    }
}