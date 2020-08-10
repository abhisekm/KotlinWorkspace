package practice

class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"
    var heat: Int = 0
        get() {
            return when (spiciness) {
                "mild" -> 5
                else -> 1
            }
        }
}

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    init {
        println("$name created with $spiciness spiciness and a heat of $heat")
    }
}

fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} - ${simpleSpice.heat}")

    val curry = Spice("curry")
    val pepper = Spice("pepper", "medium")
    val cayenne = Spice("cayenne", "spicy")
    val ginger = Spice("ginger", "mild")
    val redCurry = Spice("red curry", "medium")
    val greenCurry = Spice("green curry")
    val redPepper = Spice("red pepper", "extremely spicy")

    val salt = makeSalt()

    val spiceList = listOf<Spice>(curry, pepper, cayenne, ginger, redCurry, greenCurry, redPepper, salt)
    println("${spiceList.filter { it.heat < 5 }}")
}

fun makeSalt() = Spice("salt", "none")