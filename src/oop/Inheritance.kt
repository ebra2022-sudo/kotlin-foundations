package oop

/**
 * ---------------------------------------------
 * 04_inheritance.kt
 * Topic: Inheritance in Kotlin
 * ---------------------------------------------
 *
 * In Kotlin, classes are *final* by default (cannot be inherited).
 * To allow inheritance, you must mark the class as `open`.
 */

// Base (parent) class
open class Animal(
    val name: String
) {
    open fun sound() {
        println("$name makes a sound.")
    }
}

// Derived (child) class inherits from Animal
class Dog(name: String) : Animal(name) {

    // Override the sound() function from parent
    override fun sound() {
        println("$name barks: Woof!")
    }
}

// Another child class
class Cat(name: String) : Animal(name) {
    override fun sound() {
        println("$name meows: Meow!")
    }
}

// ---------------------------------------------
fun main() {
    val animal = Animal("Generic Animal")
    val dog = Dog("Rex")
    val cat = Cat("Kitty")

    animal.sound() // Generic Animal makes a sound.
    dog.sound()    // Rex barks: Woof!
    cat.sound()    // Kitty meows: Meow!
}

/**
 * KEY POINTS:
 * ✔ use `open` to allow a class or function to be inherited/overridden
 * ✔ use `:` to inherit from a parent class
 * ✔ use `override` to change a parent function in the child
 */
