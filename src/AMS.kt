import java.util.*

fun main(args: Array<String>) {
    //println(if(args[1].toInt() < 12) "Good morning Kotlin" else "Good night, Kotlin")
    feedTheFish()
    println(fitMoreFish(10, listOf(3,3,3)))
    println(fitMoreFish(8, listOf(2,2,2), hasDecorations = false))
    println(fitMoreFish(9, listOf(1,1,3), 3))
    println(fitMoreFish(10, listOf(), 7, true))
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = getDirtySensorReading()) : Boolean{
    fun isTooHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    return when{
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}
var dirty = 20
val waterFilter: (Int) -> Int = {dirty -> dirty/2}
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> (Int)): Int{
    return operation(dirty)
}

fun dirtyProcessor(){
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty -> dirty + 50}
}

fun fitMoreFish(
    tankSize:Int,
    currentFish: List<Int>,
    fishSize:Int=2,
    hasDecorations:Boolean=true) : Boolean{
    var newSize = tankSize
    if (hasDecorations){
        newSize = tankSize.times(0.80).toInt()
    }
    for (value in currentFish){
        newSize -= value
    }
    if (fishSize > newSize){
        return false
    }
    return true
}

fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, temperature = 20)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty=50)
    if(shouldChangeWater(day)){
        println("Change the water today")
    }
    dirtyProcessor()
}

fun swim(speed: String = "fast" ){
    println("swimming $speed")
}

fun randomDay() : String {
    val week = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String) : String{
    var food = "fasting"

    return when(day){
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