package practice

import kotlin.math.absoluteValue

enum class Direction {
    EAST, WEST, NORTH, SOUTH, START, END
}

class Location (val width: Int = 4, val height: Int = 4) {

    val map = Array(width) { arrayOfNulls<String>(height) }

    var currentLocation = Pair (0,0)

    fun updateLocation(direction: Direction) {

        if(direction.equals(Direction.NORTH)) {
            currentLocation = Pair(currentLocation.first, (currentLocation.second + 1).rem(height))}
        else if(direction.equals(Direction.SOUTH)) {
            currentLocation = Pair(currentLocation.first, (currentLocation.second - 1).absoluteValue.rem(height))}
        else if(direction.equals(Direction.EAST)) {
            currentLocation = Pair((currentLocation.first + 1).rem(width), currentLocation.second)}
        else if(direction.equals(Direction.WEST)) {
            currentLocation = Pair((currentLocation.first - 1).absoluteValue.rem(width), currentLocation.second)}
    }

    fun getDescription ():String? {
        return map[currentLocation.first.rem(width)][currentLocation.second.rem(height)]
    }

    init {
        map[0][0] = "You are at the start of your journey. [n / e]"
        map[0][1] = "The road stretches before you. It promises beauty and adventure. [ n / s / e]"
        map[0][2] = "The road still stretches before you. It rains and the water forms puddles. [ n / s / e]"
        map[0][3] = "It is getting much colder and you wish you had a wool coat. [ s / e]"

        map[1][0] = "The narrow path stretches before you. You are glad you are on foot. [ n / e /w]"
        map[1][1] = "It is getting warmer. You smell moss, and marmot scat. You are stung by a mosquito. [ n / s / e / w]"
        map[1][2] = "You decide to sit on your backside and slide down a vast snowfield. [ n / s / e /w]"
        map[1][3] = "You have climbed to the top of a snowy mountain and are enjoying the view. [ w / s / e]"

        map[2][0] = "You cross an old stone bridge. Your hear the murmuring of water. And another grumbling sound. [ n / e / w]"
        map[2][1] = "A bridge troll appears. It swings a club and demands gold. You give them all your coins. [ n / s / e  /w]"
        map[2][2] = "It is getting cooler. A dense fog rolls in. You can hear strange voices. [ n / s / e / w]"
        map[2][3] = "The foothills promise a strenuous journey. You thread your way around gigantic boulders. [ s / e / w ]"

        map[3][0] = "Your journey continues. A fox runs across the path with a chicken in its mouth.[ n / e ]"
        map[3][1] = "In the distance, you see a house. You almost bump into a farmer with a large shotgun. They pay you no heed. [ n / s / w ]"
        map[3][2] = "It is getting hot, and dry, and very, very quiet. You think of water and wish you had brought a canteen.[ n / s / w ]"
        map[3][3] = "You have reached the infinite desert. There is nothing here but sand dunes. You are bitten by a sand flea.[ s / w ] "
    }
}

class Game {
    var path = mutableListOf<Direction>(Direction.START)
    var map = Location()

    var north = { path.add(Direction.NORTH)}
    var south = { path.add(Direction.SOUTH)}
    var west = { path.add(Direction.WEST)}
    var east = { path.add(Direction.EAST)}
    var end = { path.add(Direction.END); println("Game over: $path"); path.clear(); false }

    fun makeMove(direction: String?): Boolean {
        var gameOver = false

        when (direction) {
            "n" -> {move(north); map.updateLocation(Direction.NORTH)}
            "s" -> {move(south); map.updateLocation(Direction.SOUTH)}
            "e" -> {move(east); map.updateLocation(Direction.EAST)}
            "w" -> {move(west); map.updateLocation(Direction.WEST)}
            else -> {
                move(end); gameOver = true
            }
        }

        return gameOver
    }

    fun move(where: () -> Boolean) {
        where.invoke()
    }
}


fun main() {
//    var game = Game()
//    println(game.path)
//    game.north()
//    game.east()
//    game.south()
//    game.west()
//    game.end()
//    println(game.path)
//
//    println(numbers.divisibleBy { it.rem(3) })

    val game = Game()
    while (true) {
        println(game.map.getDescription())
        print("Enter a direction: n/s/e/w:")
        if (game.makeMove(readLine().toString())) break
    }
}

val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add((item))
        }
    }

    return result
}