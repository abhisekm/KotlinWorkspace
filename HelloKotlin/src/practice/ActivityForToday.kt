package practice

fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isTooHot(temperature) -> "go swimming"
        isHappySunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        else -> "Stay home and read."
    }
}

fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun isSadRainyCold(mood: String, weather: String , temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isTooHot(temperature: Int = 24) = temperature > 35