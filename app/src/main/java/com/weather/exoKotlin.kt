package com.weather

fun main() {
    println("HelloWorld")

//    Créer une variable v1 de type String et y mettre la chaine "toto"
    var v1: String = "toto"
//    Afficher dans la console sa version en majuscule (uppercase)
    println(v1.uppercase())

//    Essayer d'y mettre la valeur null. (Erreur de compilation)
    //v1 = null

//    Créer une variable v2 de type String nullable et y mettre la chaine "toto"
    var v2: String? = "toto"

//    Afficher dans la console sa version en majuscule. Obligé de mettre le safe check
    println(v2?.uppercase())

//    Créer une variable v3 de type String nullable et y mettre la valeur null
    var v3: String? = null
//    Afficher dans la console sa version en majuscule
    println(v3?.uppercase())

    var v4 = v3 + v3
    println(v4)

    if (v3.isNullOrBlank()) {
        println("V3 est null ou blanc")
    }

    val res = boulangerie(nbBag = 2)
    println("res= $res")


}

fun boulangerie(nbC: Int = 0, nbBag: Int = 0, nbSand: Int = 0) = nbC * PRICE_CROISSANT + nbBag * PRICE_BAGUETTE + nbSand * PRICE_SANDWICH

fun pair(c: Int) = c % 2 == 0
fun myPrint(text: String) = println("#$text#")

fun min(a: Int, b: Int, c: Int) = if (a < b && a < c) a else if (b < a && b < c) b else c

