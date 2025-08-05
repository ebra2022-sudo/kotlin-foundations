package oop

/**
 * --------------------------------------------------------
 * 14_companion_object.kt
 * Topic: Companion Object in Kotlin
 * --------------------------------------------------------
 *
 * A companion object allows you to create members that belong
 * to the *class itself* rather than to instances of the class.
 * Similar to static members in Java.
 */

class MathUtil private constructor(){  // private constructor prevents instantiation
    // but if we want we must remove the `private constructor()`
    companion object {
        const val PI = 3.14159     // static-like constant

        fun square(x: Int): Int {
            return x * x
        }

        fun printInfo() {
            println("MathUtil companion object called")
        }
    }
}

// --------------------------------------------------------
fun main() {
    // Accessing companion object members without creating object
    println("PI = ${MathUtil.PI}")
    println("Square(4) = ${MathUtil.square(4)}")
    MathUtil.printInfo()
}

/*
OUTPUT:
PI = 3.14159
Square(4) = 16
MathUtil companion object called
*/

/**
 * KEY POINTS:
 * ✔ companion object acts like static members
 * ✔ only one companion per class
 * ✔ name of companion object is optional; default name is "Companion"
 */
