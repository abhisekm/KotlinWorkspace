package practice.Spices

fun main(args: Array<String>){
    val curry = Curry("yellow curry","mild")
    println("Curry color is ${curry.color}")

    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
            SpiceContainer(Curry("Red Curry", "medium")),
            SpiceContainer(Curry("Green Curry", "spicy")))

    for(element in spiceCabinet) println(element.label)
}

sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {
    abstract fun prepareSpice()
}

class Curry(name:String, spiciness: String, color:SpiceColor = YellowSpiceColor) : Spice(name,spiciness, color),
        Grinder{
    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Curry grounded")
    }

}

interface SpiceColor{
    val color: Color
}

interface Grinder{
    fun grind()
}

object YellowSpiceColor: SpiceColor{
    override val color: Color = Color.YELLOW
}

data class SpiceContainer(val spice: Spice){
    var label = spice.name
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}