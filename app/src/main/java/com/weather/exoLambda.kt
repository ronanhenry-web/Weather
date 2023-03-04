package com.weather

fun main() {
exo1()
}

data class PersonBean(var name:String, var note:Int)
fun exo4(){

    val list = arrayListOf(PersonBean("toto", 16), PersonBean("Bobby", 20), PersonBean("Toto", 8), PersonBean("Charles", 14))

    println("Afficher la sous liste de personne ayant 10 et +")
    //println(list.filter { it.note >=10 })
    //Pour un affichage de notre choix
    println(list.filter { it.note >=10 }.joinToString("\n") { "-${it.name} : ${it.note}"})

    println("\n\nAfficher combien il y a de Toto dans la classe ?")
    val lambdaNomToto = { it: PersonBean -> it.name.equals("toto", true) }
    println(list.count(lambdaNomToto))

    println("\n\nAfficher combien de Toto ayant la moyenne (10 et +)")
    println(list.count { lambdaNomToto(it) && it.note >= 10 })

    println("\n\nAfficher combien de Toto ont plus que la moyenne de la classe")
    val moyenne = list.map { it.note }.average()
    println(list.count { lambdaNomToto(it) && it.note >= moyenne })

    println("\n\nAfficher les noms sans doublon par ordre alphabétique")
    println(list.map { it.name }.distinctBy { it }.sortedBy { it.lowercase() })

    println("\n\nAjouter un point à ceux n’ayant pas la moyenne (<10)")
    list.filter { it.note < 10 }.forEach { it.note++ }

    println("\n\nAjouter un point à tous les Toto")
    list.filter(lambdaNomToto).forEach { it.note++ }

    println("\n\nRetirer de la liste ceux ayant la note la plus petite")
    val minNote = list.minOfOrNull { it.note }
    list.removeIf { it.note == minNote }

    println("\n\nAfficher les noms de ceux ayant la moyenne(10et+) par ordre alphabétique")
    print(list.filter { it.note >= 10 }.map { it.name }.sortedBy { it })
    //V2
    list.filter { it.note >= 10 }.map { it.name }.sortedBy { it }.forEach(::println)
}

fun exo1(){
    val lower : (String)-> Unit = {it:String -> println(it.lowercase())}
    val lowerV2  = {it:String -> println(it.lowercase())}
    val lowerV3 : (String)-> Unit = {it -> println(it.lowercase())}
    val lowerV4 : (String)-> Unit = { println(it.lowercase())}

    lower("Un texte aVec des Majucules")

    val heure : (Int) -> Int = {it/60}
    val hour =
    println("heure:${heure(128)}")

    val max = {v1:Int, v2:Int -> Math.max(v1,v2)}
    val reverse : (String)->String  = {it.reversed()}

}