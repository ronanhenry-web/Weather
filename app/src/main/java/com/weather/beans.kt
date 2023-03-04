package com.weather

import java.util.*

fun main() {
//    var car = CarBean("Seat", "Leon")
//    car.color = "grise"
//
//    println(car)
//    println("${car.marque} ${car.model} ${car.color}")
//
//    var student = StudentBean("Toto")
//    student.note++
//    println("${student.name} : ${student.note}" )

    //    val plane = PlaneBean("Toto")
    //    println("${plane.name} : ${plane.id}")
    //    plane.name = "bob"
    //    println("${plane.name} : ${plane.id}")
    //
    //    val plane2 = PlaneBean("Toto")

    val randomName = RandomName()
    randomName.add("bobby")
    repeat(10) {
        println(randomName.nextDiff() + " ")
    }
}

/* -------------------------------- */
// API Pokemon
/* -------------------------------- */

data class PokemonBean(
    val name: String,
    val type: List<String>
)

/* -------------------------------- */
// API WEATHER
/* -------------------------------- */
data class WeatherBean(var main: TempBean, var wind: WindBean, var name: String, var weather:List<DescBean>)

data class WindBean(var speed: Double)
data class DescBean(var description: String, var icon:String)
data class TempBean(var temp: Double, var temp_min:Double,var temp_max:Double)

data class WeatherErrorBean(var message:String)


/* -------------------------------- */
// EXO
/* -------------------------------- */
class RandomName {
    private val list = arrayListOf("Toto", "Tata", "Titi")
    private var oldValue = ""

    fun add(name: String?) {
        if (!name.isNullOrBlank() && name !in list) {
            //list.add(name)
            list += name
        }
    }

    fun next() = list.random()

    fun nextDiff(): String {
        var sendValue = next()
        while(sendValue == oldValue){
            sendValue = next()
        }
        oldValue = sendValue
        return sendValue
    }

    fun next2() = Pair(nextDiff(), nextDiff())
}

class PlaneBean(name: String) {
    var id = name.hashCode()
        private set

    var name = name
        set(value) {
            field = value
            id = name.hashCode()
        }

}

class PrintRandomIntBean(val max: Int) {
    val random = Random()

    init {
        println("Init")
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }

    constructor() : this(100) {
        println("constructor")
        println(random.nextInt(max))
    }

}


class UserBean(val name: String, var note: Int = 0) {
    val id = name.hashCode()
}

class StudentBean(val name: String) {
    var note = 0
}

data class CarBean(var marque: String, var model: String) {
    var color = ""
}