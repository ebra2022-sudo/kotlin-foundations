package basics

/**
 * TypeAndItsRule.kt
 * Here’s a comprehensive guide to types in Kotlin, going from basic to advanced.
 * Kotlin has a rich type system that ensures safety, expressiveness, and conciseness.
 * and it is statically typed programming language
 */

/*

It is necessary for every object created in memory, regardless of whether the language is
dynamically or statically typed, to have an associated type.
However, the nature of this type and when it is determined differs significantly between dynamic and static typing.
 */

// what is the role of type in programming language

// Basic Type

/**
 * Numerical Type
 * | Type    | Size   | Example                |
 * | ------- | ------ | ---------------------- |
 * | `Byte`  | 8-bit  | `val a: Byte = 10`     |
 * | `Short` | 16-bit | `val b: Short = 200`   |
 * | `Int`   | 32-bit | `val c: Int = 1000`    |
 * | `Long`  | 64-bit | `val d: Long = 10000L` |
 *
 * Floating pont type
 * | Type     | Size   | Example                |
 * | -------- | ------ | ---------------------- |
 * | `Float`  | 32-bit | `val e: Float = 12.3f` |
 * | `Double` | 64-bit | `val f: Double = 12.3` |
 *
 * 2. String and Text
 * String: Immutable text sequences.
 *
 * Supports string templates and multi-line strings (""").
 *
 *  Nullable Types
 */

val singlelineString = "single line string"
val multilineString = """
    This is
    Multiline String
""".trimIndent()
fun main() {
    println(singlelineString)
    println(multilineString)
    println("End line")
    //terminateProgram()
    //infiniteLoop()
}

// 3 Nullable type
/*
val normal: String = "Hi"
// val fail: String = null ❌ Error

val nullable: String? = null  ✅

 */

// Use ?., ?:, !!, or let to safely access
val nullable: String? = null // in this case type annotation is mandatory since the variable is nullable
val length = nullable?.length ?: 0

// 4, Kotlin collections are divided into mutable and immutable.

// Immutable collections(after we create the object we cannot update the object state, but we can reassign to another  variable with updated state)
fun immutableCollections() {
    val list: List<Int> = listOf(1, 2, 3)
    val set: Set<String> = setOf("A", "B")
    val map: Map<String, Int> = mapOf("A" to 1)
}

// mutable  collection(we can update the stat of the object after we create them)

fun mutableCollections() {
    val list = mutableListOf(1, 2)
    list.add(3)
    val map = mutableMapOf("x" to 5)
    map["y"] = 10
}


// 5. Array Type
// Kotlin offers both generic Array<T> for arrays of objects
// and specialized primitive-type arrays for performance optimization

/**
 *
 * Generic Array:
 * Array<T>: This is a generic class that represents an array of objects of type T.
 * When targeting the JVM, instances of this class are represented as T[]
 *
 * Primitive-type Arrays:
 * Kotlin provides dedicated classes for arrays of primitive types, which are mapped to their corresponding Java primitive array types for better performance and interoperability with the JVM. These include:
 * ByteArray: Equivalent to byte[] in Java.
 * ShortArray: Equivalent to short[] in Java.
 * IntArray: Equivalent to int[] in Java.
 * LongArray: Equivalent to long[] in Java.
 * FloatArray: Equivalent to float[] in Java.
 * DoubleArray: Equivalent to double[] in Java.
 * CharArray: Equivalent to char[] in Java.
 * BooleanArray: Equivalent to boolean[] in Java.
 *
 *
 */

// These primitive arrays can be created using their respective *ArrayOf() functions:
fun genericArray() {
    val stringArray: Array<String> = arrayOf("Apple", "Banana", "Cherry")
    val anyArray: Array<Any> = arrayOf(1, "Hello", true)
}

fun primitiveArray() {
    val intArray: IntArray = intArrayOf(1, 2, 3)
    val doubleArray: DoubleArray = doubleArrayOf(1.0, 2.5, 3.8)

}

// 6. Custom Types: Classes and Data Classes

// Kotlin lets you define your own types using classes.
class Persons(val name: String, val age: Int)

data class Product(val id: Int, val name: String)

// 7. Enums
// Useful for representing a fixed set of constants.
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

// 8. Sealed Classes (Advanced ADTs)

/*
Restricted inheritance: all subclasses must be defined in the same file.

Great for modeling state machines or variants.
 */

sealed class Result
data class Success(val data: String): Result()
data class Error(val message: String): Result()
object Loading : Result()

// 9. Type Aliases

/*
What is a Type Alias?
A type alias in Kotlin is a way to provide an alternative name for an existing type.
It doesn’t create a new type but allows you to refer to an existing type with a different name.
This can make your code more readable and expressive, especially when dealing with complex types.

Why Use Type Aliases?
Type aliases can be useful in several scenarios:

Readability: Simplify complex type declarations.
Maintainability: Make changes to type declarations easier.
Expressiveness: Give meaningful names to types that represent specific concepts in your code

How to Use Type Aliases
typealias AliasName = ExistingType
 */
// example of type alias
typealias UserName = String

val name: UserName = "Muhammed" // now the type is UserName for name

// 10. Generic Types
// Used to create type-safe and reusable components

class Box<T>(val value: T)

val intBox = Box(123)
val strBox = Box("Hello")

// 11. Function Types
// Functions are first-class citizens in Kotlin. which means they can be assigned to a variable,
// pass into function as argument, and returned from the function

val sum: (Int, Int) -> Int = { a, b -> a + b }
fun doWork(task: () -> Unit) { task() }

// 12. Type Inference() but there are cases we have to annotate the type like for nullable variables

/*
val x = 10     // Inferred as Int
val name = "Ali"  // Inferred as String
 */

// 13, Type Unit and type Nothing in kotlin

/**
 * In Kotlin, Unit and Nothing are distinct types with different purposes, despite both relating
 * to the absence of a meaningful return value.
 *
 * Unit:
 * Represents the absence of a meaningful value: Unit is akin to void in Java, signifying that a function performs
 * an action but doesn't produce a specific result that needs to be used.
 * Single instance: There is only one instance of the Unit type, which is the Unit object.
 * Default return type: If a function doesn't explicitly declare a return type, it implicitly returns Unit
 *
 * example:
 *    fun printMessage(message: String): Unit { // Explicit Unit return type
 *         println(message)
 *     }
 *
 *     fun doSomething() { // Implicit Unit return type
 *         // ... some operations
 *     }
 *
 * Nothing:
 * Represents a function that never returns: Nothing indicates that a function will never complete its execution
 * normally, typically because it always throws an exception, enters an infinite loop, or terminates the program.
 * No instances: It is impossible to create an instance of Nothing.
 * Bottom type: Nothing is a subtype of all other types in Kotlin, which allows it to be used in contexts where any
 * type is expected, without actually providing a value.
 * Compiler implications: The Kotlin compiler recognizes Nothing and marks any code following a call to a
 * Nothing-returning function as "unreachable code."
 *
 * example:
 *    fun terminateProgram(): Nothing {
 *         throw IllegalStateException("Program terminated unexpectedly.")
 *     }
 *
 *     fun infiniteLoop(): Nothing {
 *         while (true) {
 *             // ...
 *         }
 *     }
 *
 *
 * Key Differences Summarized:
 * Return behavior: Unit functions return but with no meaningful value, while Nothing functions never return at all.
 * Instantiability: Unit has a single instance (Unit object), while Nothing has no instances.
 * Purpose: Unit is for side-effect-oriented functions, Nothing is for indicating abnormal termination or unreachable code.
 */

fun terminateProgram(): Nothing {
    throw IllegalStateException("Program terminated unexpectedly.")
}

fun infiniteLoop(): Nothing {
    while (true) {
        // ...
    }
}