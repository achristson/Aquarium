import java.lang.Math.random
import java.util.*

fun main(args: List<String>){

}

val rollDice = {sides: Int -> Random().nextInt(12) + 1 }
val rollDice0 = {sides: Int -> if (sides == 0) 0 else Random().nextInt(12) + 1 }

