package oop

/**
 * ---------------------------------------------
 * 13_sealed_class.kt
 * Topic: Sealed Classes in Kotlin
 * ---------------------------------------------
 *
 * A sealed class is used to represent a restricted hierarchy.
 * All subclasses must be declared in the *same file*.
 *
 * It is great for state management & when-expressions because
 * the compiler knows all possible types (exhaustive).
 */

// Sealed superclass
sealed class Result

// Possible subclasses (must be in same file)
class Success(val data: String) : Result()
class Error(val message: String) : Result()
object Loading : Result()   // can also use objects

// ------------------------------------------------
fun handleResult(result: Result) {
    when (result) {
        is Success -> println("Success → Data: ${result.data}")
        is Error   -> println("Error → ${result.message}")
        Loading    -> println("Loading...")
        // no need for 'else' → compiler knows all cases
    }
}

// ------------------------------------------------
fun main() {
    val r1: Result = Success("User fetched")
    val r2: Result = Error("Network failure")
    val r3: Result = Loading

    handleResult(r1)
    handleResult(r2)
    handleResult(r3)
}

/*
OUTPUT:
Success → Data: User fetched
Error → Network failure
Loading...
*/

/**
 * KEY POINTS:
 * ✔ Sealed class = restricted class hierarchy
 * ✔ Great for representing states and events
 * ✔ Enables exhaustive `when` without needing `else`
 */
