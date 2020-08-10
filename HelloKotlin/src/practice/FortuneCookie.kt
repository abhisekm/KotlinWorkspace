package practice

fun main(args: Array<String>){
    var fortune: String = ""
    for (i in 1..10) {
        fortune = getFortuneCookie(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break;
    }

//    // repeat loop
//    repeat (10) {
//        fortune = getFortuneCookie(getBirthday())
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break;
//    }

//    // while loop
//    while (!fortune.contains("Take it easy")){
//        fortune = getFortuneCookie(getBirthday())
//        println("\nYour fortune is: $fortune")
//    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
   return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie(birthday: Int): String{
    val fortuneList = listOf<String>(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )

    return when(birthday){
        in 1..7 -> "Being alone and being lonely are two different things."
        in listOf(28,31) -> "Dream your dream and your dream will dream of you."
        else ->  fortuneList[birthday%fortuneList.size]
    }
}