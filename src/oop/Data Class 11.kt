package oop

/**
 * ---------------------------------------------
 * 11_data_classes.kt
 * Topic: Data Classes in Kotlin
 * ---------------------------------------------
 *
 * A data class is meant to store data.
 * The compiler automatically generates:
 *   - equals()
 *   - hashCode()
 *   - toString()
 *   - copy()
 *   - componentN() (for destructuring)
 * Requirements:
 *   - Must have at least one property in the primary constructor
 *   - Cannot be abstract, open, sealed, or inner
 */

data class User(val id: Int, val name: String, val email: String)

// ---------------------------------------------
fun main() {
    val user1 = User(1, "Ali", "ali@mail.com")
    val user2 = User(1, "Ali", "ali@mail.com")
    val user3 = user1.copy(name = "Sara")   // copy with change

    // Automatically checks value equality
    println("user1 == user2: ${user1 == user2}")  // true

    // Automatically generated toString()
    println(user1)   // User(id=1, name=Ali, email=ali@mail.com)

    // Destructuring
    val (id, name, email) = user3
    println("ID = $id, Name = $name, Email = $email")
}

/*
OUTPUT:
user1 == user2: true
User(id=1, name=Ali, email=ali@mail.com)
ID = 1, Name = Sara, Email = ali@mail.com
*/

/**
 * KEY POINTS:
 * ✔ data classes simplify creating classes to hold data
 * ✔ use 'copy()' & destructuring for convenience
 * ✔ generated functions save boilerplate coding
 */
