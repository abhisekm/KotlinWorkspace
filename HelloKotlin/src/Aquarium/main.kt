package Aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Width: ${myAquarium.width} " +
            "Length: ${myAquarium.length} " +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80

    println("Height : ${myAquarium.height}")
    println("Volume : ${myAquarium.volume} litres")
    myAquarium.volume = 180

    println("Height : ${myAquarium.height}")

    val myNewAquarium = Aquarium(20,15,30)
    println("Width: ${myNewAquarium.width} " +
            "Length: ${myNewAquarium.length} " +
            "Height: ${myNewAquarium.height}")

    println("Volume : ${myNewAquarium.volume} litres")
}

fun feedFish(fish: FishAction){
    fish.eat()
}

fun makeFish(){
    val shark = Shark()
    val plecostomus = Plecostomus()
    println("Shark: ${shark.color} \nPlecostomus: ${plecostomus.color}")

    feedFish(shark)
    feedFish(plecostomus)
}