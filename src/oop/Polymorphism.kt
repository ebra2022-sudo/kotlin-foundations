package oop

/**
 * ---------------------------------------------
 * 07_polymorphism.kt
 * Topic: Polymorphism in Kotlin
 * ---------------------------------------------
 *
 * Polymorphism means "many forms". It allows you to treat
 * objects of different classes through the same interface,
 * and call overridden functions dynamically.
 *
 * → Kotlin uses runtime (dynamic) polymorphism with inheritance.
 */

// Parent class
open class Animal1 {
    open fun makeSound() {
        println("Animal makes some sound")
    }
}

// Child classes
class Dog1 : Animal1() {
    override fun makeSound() {
        println("Dog barks: Woof!")
    }
}

class Cat1 : Animal1() {
    override fun makeSound() {
        println("Cat meows: Meow!")
    }
}

// --------------------------------------------
fun main() {
    // Reference of type Animal pointing to Dog object
    val animal1: Animal1 = Dog1()
    // Reference of type Animal pointing to Cat object
    val animal2: Animal1 = Cat1()

    // Dynamic dispatch → correct function is chosen at runtime
    animal1.makeSound()  // Dog version
    animal2.makeSound()  // Cat version
}

/*
OUTPUT:
Dog barks: Woof!
Cat meows: Meow!
*/

/**
 * KEY POINTS:
 * ✔ Polymorphism enables one interface to be used for multiple forms (objects)
 * ✔ Achieved via inheritance + method overriding
 * ✔ Promotes flexibility and extensibility in OOP design
 */
