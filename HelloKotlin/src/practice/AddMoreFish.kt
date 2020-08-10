package practice

fun main(args: Array<String>){
    println("${canAddFish(10.0, listOf(3,3,3)) }---> false")
    println("${canAddFish(8.0, listOf(2,2,2), hasDecorations = false)} ---> true")
    println("${canAddFish(9.0, listOf(1,1,3), 3) }---> false")
    println("${canAddFish(10.0, listOf(), 7, true)} ---> true")
}

fun canAddFish(
        tankSize: Double,
        currentFish: List<Int>,
        fishSize: Int = 2,
        hasDecorations: Boolean = true
) : Boolean{
    return currentFish.sum() + fishSize <= (tankSize * (if (hasDecorations) 0.8f else 1f ))
}
