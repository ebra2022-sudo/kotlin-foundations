package basics
/*
In Kotlin, variable scoping rules define where a variable is accessible and valid within your code. Understanding
scopes is crucial for writing clean, bug-free, and maintainable code. Let's walk through variable scoping from basic
to advanced, with examples.
 */

// 1. Global Scope (Top-Level Declarations)
    //Declared outside any class, function, or block.
    //Available throughout the file and can be imported in other files
val appName = "MyApp"  // Top-level variable

fun main() {
    println(appName) // Accessible here
    greet("Muhammed")
    checkNumber(12)

    val person = Person()
    person.showName()
    test()
    createMediaName()
    appName.printUppercase()
    sample()
    scopeFunctions()
}

// 2. Function Scope
    //Variables declared inside a function are accessible only within that function.
    //These are local variables.

fun greet(name: String) {
    val message = "Hello"
    println("$message $name") // sting interpolation using the $ sign or expression evaluation with ${ expression} inside string
    // we cannot access the local variable "message" outside of this scope
}

// 3. Block Scope
    // any block that has {} create block scope such as if, when, for, while, try, catch blocks

fun checkNumber(x: Int) {
    if (x > 0) {
        val result = "Positive"
        println(result)
    }
    // println(result) ❌ Error: result is not visible here
}

// 4. Class-Level Scope

    //Variables declared in a class:
    //val / var inside class = property (instance variable)
    //companion object = similar to static variable

class Person {
    val name = "Ali"       // instance property
    var age: Int = 25      // instance property

    fun showName() {
        println(name)      // accessible here
    }

    companion object {
        const val species = "Human"  // class-level (like static)
    }
}

// 5. Shadowing
    // A local variable can hide or shadow a variable from an outer scope.

val x = 10

fun test() {
    val x = 5  // shadows the top-level x
    println(x) // prints 5
}

// 6. Lambda Scope / Anonymous Functions
    // Lambdas capture variables from the outer scope.

fun createMediaName() {
    val suffix = "BC"
    val prefixes = listOf("A", "B", "E", "F")
    // now we can access the suffix outer variable inside lambda scople
    val mediaNames = prefixes.map {
        it + suffix
    }
    println(mediaNames)
}

// 7. Extension Functions Scope
    //You can access members of the receiver object (this) and also outer variables.

fun String.printUppercase() {
    val suffix = "!!!"
    println(this.uppercase() + suffix)
}

// 8. Object Expressions (Anonymous Inner Class) Scope
    // Can access outer variables only if they are captured as final/val.

fun sample() {
    val greeting = "Hello"

    val runnable = object : Runnable {
        override fun run() {
            println(greeting)  // Allowed because greeting is val
        }
    }

}

// 9. Scopes with let, run, apply, also, and with
    // These are Kotlin scope functions, which introduce a new temporary scope.

val user = User(name = "Muhammed")


fun scopeFunctions() {
    user.let {
        it.name = "Ali"
    }
    println(user.name)
}

class User(var name: String){

}

// 10. Visibility Modifiers and Packages
    // private, internal, protected, public affect accessibility, not scope directly but still
    // important for scoping across files.
private val secret = "Hidden"  // only visible in this file
internal val internalData = "Module-wide"  // visible in the same module

/**
 * Summary table
 * | Scope Type         | Defined In                    | Accessible Where                             |
 * | ------------------ | ----------------------------- | -------------------------------------------- |
 * | Top-Level          | Outside all classes/functions | Whole file / via imports                     |
 * | Function Scope     | Inside a function             | Only inside that function                    |
 * | Block Scope        | Inside `{}` blocks            | Only inside that block                       |
 * | Class Scope        | Inside class                  | Anywhere within class                        |
 * | Lambda Scope       | Inside lambda expressions     | Inside the lambda                            |
 * | Extension Function | Defined with receiver type    | Acts like a class method on receiver         |
 * | Scope Functions    | `let`, `run`, etc.            | Limited to lambda block (`this` or `it`)     |
 * | Object Scope       | Anonymous inner class         | Can access `val` from outer scope            |
 * | Visibility Control | Using `private`, `internal`   | Controls visibility, not just variable scope |
 *
 */