package oop

/**
 * -----------------------------------------------------
 * 14_object_keyword.kt
 * Topic: The `object` Keyword in Kotlin
 * -----------------------------------------------------
 *
 * The `object` keyword is used for:
 *   1) Declaring a Singleton
 *   2) Creating Anonymous Objects
 *   3) Defining Object Expressions or Object Declarations
 */

// -----------------------------------------------------
// 1) Singleton using object declaration
object DatabaseConfig {
    val url = "jdbc:mysql://localhost:3306/mydb"
    val user = "root"
    val password = "password"

    fun connect() {
        println("Connecting to DB at $url...")
    }
}

// -----------------------------------------------------
// 2) Anonymous object example
fun getClickListener(): Any {
    return object {
        fun onClick() {
            println("Button clicked!")
        }
    }
}

// -----------------------------------------------------
fun main() {
    // Singleton usage
    DatabaseConfig.connect()
    println(DatabaseConfig.user)

    // Anonymous object usage
    val listener = getClickListener()
    // Smart cast needed, or use reflection/explicit interface
    // (in real code we return an interface for better use)
    listener.javaClass.getMethod("onClick").invoke(listener)
}

/*
OUTPUT:
Connecting to DB at jdbc:mysql://localhost:3306/mydb...
root
Button clicked!
*/

/**
 * KEY POINTS:
 * ✔ `object` = create a singleton
 * ✔ Only one instance is ever created
 * ✔ Also used for anonymous object expressions
 * ✔ Good for factory, configuration, event listener patterns
 */
