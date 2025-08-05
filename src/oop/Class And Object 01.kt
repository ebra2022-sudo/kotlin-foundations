package oop

/**
 * ---------------------------------------------
 * 01_class_and_object.kt
 * Topic: Basic Class and Object in Kotlin
 * ---------------------------------------------
 *
 * A class is a blueprint for creating objects. It can have properties (data)
 * and functions (behavior). An object is an instance of a class.
 */

// Step 1: Define a simple class
class Person {
    // property (state/field)
    var name: String = "Unknown"
    var age: Int = 0

    // member function (behavior)
    fun introduce() {
        println("Hi, my name is $name and I am $age years old.")
    }
}

// Step 2: Create objects and access them
fun main() {
    // Create an object of class Person
    val person1 = Person()

    // Set data (properties)
    person1.name = "Ali"
    person1.age = 23

    // Access behavior (method)
    person1.introduce()

    // Create another object
    val person2 = Person()
    person2.name = "Sara"
    person2.age = 30
    person2.introduce()
}

/**
 * OUTPUT:
 * Hi, my name is Ali and I am 23 years old.
 * Hi, my name is Sara and I am 30 years old.
 *
 * KEY POINTS:
 * ✔ class = blueprint
 * ✔ object = created from a class
 * ✔ Use "." operator to access properties and methods
 */
