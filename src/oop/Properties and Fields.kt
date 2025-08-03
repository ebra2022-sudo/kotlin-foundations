package oop

/**
 * ---------------------------------------------
 * 03_properties_and_fields.kt
 * Topic: Kotlin Properties and Backing Fields
 * ---------------------------------------------
 *
 * In Kotlin, a property is like a combination of a variable
 * + automatic getter & setter functions.
 *
 * You can customize the getter/setter for advanced control.
 */

class User {

    // simple property: Kotlin automatically creates backing field,
    // getter() and setter()
    var name: String = "Unknown"

    // read-only property (val has only getter)
    val createdAt: Long = System.currentTimeMillis()

    // custom getter (computed property)
    val isNameLong: Boolean
        get() = name.length > 5

    // custom setter + getter using a backing field
    var email: String = ""
        set(value) {
            // custom logic
            field = value.lowercase() // 'field' = backing field behind property
        }
        get() = field.trim()
}

// --------------------------------------------------------
fun main() {
    val user = User()

    user.name = "Muhammed"
    println("Name: ${user.name}")                     // Muhammed
    println("Is name long: ${user.isNameLong}")       // true

    user.email = "Example@GMAIL.com "
    println("Email stored as: ${user.email}")         // example@gmail.com

    println("Created At timestamp: ${user.createdAt}") // read-only
}

/*
OUTPUT:
Name: Muhammed
Is name long: true
Email stored as: example@gmail.com
Created At timestamp: 1690000000000 (example)
*/

/**
 * KEY POINTS:
 * ✔ 'var' → mutable property (get + set)
 * ✔ 'val' → read-only property (only get)
 * ✔ Kotlin auto-generates getter/setter if not written
 * ✔ Use 'field' keyword inside custom setter/getter to access backing field
 */
