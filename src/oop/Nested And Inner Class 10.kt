package oop

/**
 * ---------------------------------------------------
 * 10_nested_and_inner_class.kt
 * Topic: Nested and Inner Classes in Kotlin
 * ---------------------------------------------------
 *
 * - A *nested class* is a class declared inside another class.
 *   It is static by default → cannot access outer class members.
 *
 * - An *inner class* is marked with the keyword `inner` and
 *   holds a reference to the outer class → can access outer members.
 */

class Outer {

    private val outerMessage: String = "Message from Outer class"

    // -------- Nested (static-like) --------
    class Nested {
        fun printMessage() {
            println("Inside Nested Class")
        }
    }

    // -------- Inner (non-static) --------
    inner class Inner {
        fun printMessage() {
            // Can access outer class members
            println("Accessing: $outerMessage")
        }
    }
}

// -------------------------------------------------
fun main() {
    // Using nested class (no need outer instance)
    val nested = Outer.Nested()
    nested.printMessage()

    // Using inner class (requires outer instance)
    val outer = Outer()
    val inner = outer.Inner()
    inner.printMessage()
}

/*
OUTPUT:
Inside Nested Class
Accessing: Message from Outer class
*/

/**
 * KEY POINTS:
 * ✔ Nested class = static-like → no access to outer class members
 * ✔ Inner class = non-static → has reference to outer class, use `inner`
 * ✔ Use them to logically group classes or model relationships
 */
