package practice

open class BaseBuildingMaterial(){
    open val numberNeeded: Int = 1
}

class Wood: BaseBuildingMaterial(){
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial(){
    override val numberNeeded = 8
}

class Building<out T: BaseBuildingMaterial>(private val material: T){
    private val baseMaterialNeeded: Int = 100
    val actualMaterialNeeded = baseMaterialNeeded * material.numberNeeded

    fun build(){
        println("$actualMaterialNeeded ${material::class.simpleName} required")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) = run { if(building.actualMaterialNeeded<500) println("small building") else println("large building") }

fun main(args: Array<String>){
    val building = Building(Wood())
    building.build()
    isSmallBuilding(building)
    isSmallBuilding(Building(Brick()))
}