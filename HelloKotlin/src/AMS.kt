import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
    feedTheFish();
}

fun feedTheFish() {
    val day = getRandomDay()
    val food = fishFood(day)
    println("Today is $day and the fish will eat $food")
    if (shouldCleanWater(day)) {
        println("Change the water today")
    }
}

fun shouldCleanWater(day: String, temperature: Int = 20, dirty: Int = 20): Boolean {
    return true;
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun getRandomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}
