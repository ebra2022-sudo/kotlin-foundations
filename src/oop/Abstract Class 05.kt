package oop

/**
 * ---------------------------------------------
 * 05_abstract_class.kt
 * Topic: Abstract Classes in Kotlin
 * ---------------------------------------------
 *
 * An abstract class cannot be instantiated directly.
 * It is meant to be inherited, and can contain both:
 *   - abstract members (no body, must be overridden)
 *   - concrete members (normal functions/properties with body)
 */

// Define abstract base class
abstract class Shape(val name: String) {

    // abstract function → must be implemented by subclasses
    abstract fun area(): Double

    // concrete function → shared by all subclasses
    fun printName() {
        println("Shape: $name")
    }
}

// Concrete subclass 1
class Circle(val radius: Double) : Shape("Circle") {
    override fun area(): Double = Math.PI * radius * radius
}

// Concrete subclass 2
class Rectangle(val width: Double, val height: Double) : Shape("Rectangle") {
    override fun area(): Double = width * height
}

// ----------------------------------------
fun main() {
    // Cannot do: val s = Shape("test") ❌ (abstract, cannot instantiate)

    val c = Circle(5.0)
    c.printName()
    println("Area = ${c.area()}")

    val r = Rectangle(4.0, 6.0)
    r.printName()
    println("Area = ${r.area()}")
}

/*
OUTPUT:
Shape: Circle
Area = 78.5398...
Shape: Rectangle
Area = 24.0
*/

/**
 * KEY POINTS:
 * ✔ abstract classes act as blueprints
 * ✔ they can hold both incomplete (abstract) & complete implementations
 * ✔ subclasses must override abstract members
 * ✔ they promote code reuse & polymorphism
 */
