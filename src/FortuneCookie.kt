fun main(args:Array<String>){
    println(getFortuneCookie())
}

fun getFortuneCookie() : String{
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    val birthday = getBirthday()
    return when(birthday){
        in 1..7 -> fortunes[2]
        28 or 31 -> fortunes[5]
        else -> fortunes[birthday.mod(7)]
    }

}

fun getBirthday() : Int{
    print("Enter your birthday")
    return readLine()?.toIntOrNull() ?: 1
}