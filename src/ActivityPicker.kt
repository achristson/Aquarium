fun main(args:Array<String>){
    println(whatShouldIDoToday("happy", "sunny"))
}

fun whatShouldIDoToday(
    mood:String,
    weather:String="sunny",
    temperature:Int=24) : String{

    fun isHappySunny(mood:String,weather: String) = mood == "happy" && weather == "sunny"
    fun isVeryHot(temperature: Int, weather: String) = temperature == 38 && weather == "sunny"
    fun isSadRainyCold(mood: String,weather: String,temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
    return when {
        isHappySunny("happy","sunny") -> "go for a walk"
        isVeryHot(38,"sunny") -> "go to the beach"
        isSadRainyCold("sad","rainy",0)-> "stay in bed"
        else -> "stay home and read"
    }
}