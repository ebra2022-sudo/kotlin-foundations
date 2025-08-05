package oop

/**
 * ---------------------------------------------
 * 06_interface.kt
 * Topic: Interfaces in Kotlin
 * ---------------------------------------------
 *
 * An interface defines a contract: functions and properties
 * that a class must implement. Interfaces support:
 *   - Abstract methods (no body)
 *   - Default implementations (methods with a body)
 *   - Multiple inheritance (a class can implement multiple interfaces)
 */

// Define an interface
interface Flyable {
    fun fly()  // abstract method

    // default method implementation
    fun landing() {
        println("Landing safely...")
    }
}

// Another interface
interface Swimmable {
    fun swim()
}

// A class implementing multiple interfaces
class Duck : Flyable, Swimmable {
    override fun fly() {
        println("Duck is flying!")
    }

    override fun swim() {
        println("Duck is swimming!")
    }
}

// ------------------------------------------------
fun main() {
    val duck = Duck()

    duck.fly()
    duck.swim()
    duck.landing()
}

/*
OUTPUT:
Duck is flying!
Duck is swimming!
Landing safely...
*/

/**
 * KEY POINTS:
 * ✔ Interface can have abstract methods and default methods
 * ✔ Class uses ':' and 'implement' keyword in Java is replaced by ': InterfaceName' in Kotlin
 * ✔ Kotlin supports multiple interfaces → multiple inheritance of type
 * ✔ No constructor in interfaces
 */
