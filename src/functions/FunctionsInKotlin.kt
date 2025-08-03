package functions

// 1. What is a Function? (Basics)

/**
 * A function is a reusable block of code that performs a specific task.
 * fun functionName(parameter1: Type1, parameter2: Type2): ReturnType {
 *     // body
 *     return value // must have type of the return type
 * }
 *
 * Function Components:
 *
 * | Part     | Meaning                               |
 * | -------- | ------------------------------------- |
 * | `fun`    | Keyword to declare a function         |
 * | `name`   | Identifier of the function            |
 * | `params` | Inputs (optional)                     |
 * | `return` | Output (optional) — default is `Unit` |
 *
 */

// Default and Named Parameters

fun greet(name: String, message: String = "Hello") {
    println("$message, $name")
}


// Single Expression Functions(if the function block is single line so we can remove the curly braces and equate with assignment operator)
fun square(x: Int) = println(x * x)

//  Function Overloading
// Multiple functions with the same name, different parameters:

fun show(num: Int) { println(num)}
fun show(text: String) { println(text) }

// Local Functions

//Functions declared inside another function:
fun outer() {
    fun inner() {
        println("Inside inner")
    }
    inner()
}

// Higher-Order Functions
//Takes functions as parameters or returns another function.
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Inline function, what is their purpose?
/**
 * Purpose of inline
 * When you mark a function as inline (especially higher-order functions that take lambdas as parameters),
 * the compiler copies the body of the function and the lambda directly into the places where it’s called.
 *
 * Why this is useful:
 * | Without `inline`                                                                     | With `inline`                                                                |
 * | ------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------- |
 * | A lambda means a function object is created → allocation on heap + call stack frame. | No function object created → lambda code is *injected* into the caller code. |
 * | Function call overhead at runtime                                                    | Removes call overhead → faster code                                          |
 * | Slightly slower                                                                      | More optimized performance                                                   |
 *
 * Think of it like:
 * inline fun doSomething(action: () -> Unit) {
 *     println("Before")
 *     action()
 *     println("After")
 * }
 *
 * fun main() {
 *     doSomething {
 *         println("Hello")
 *     }
 * }
 *
 * The compiler transforms this approximately into:
 * fun main() {
 *     println("Before")
 *     // inlined code of the lambda
 *     println("Hello")
 *     println("After")
 * }
 *
 * Side Effects?
 * Increases binary size if overused → because code is copied.
 * You can’t use certain features (like return) unless you understand crossinline / noinline.
 *
 * Summary:
 * Inline = “paste” the function body + lambda inside the caller → speeds up by skipping
 * function object creation and stack calls.
 */

/**
 * What is the difference between the crossinline and noinline in the inline function?
 * both noinline and crossinline are used inside an inline function to control how each lambda parameter behaves.
 *
 * 1. noinline
 * By default, all lambda parameters in an inline function are inlined, meaning their code is copied into the caller.
 * If you mark a lambda as noinline, it tells the compiler “don’t inline this one — treat it like a normal function object.”
 *
 * Use when:
 * You want to store the lambda in a variable
 * You need to pass it to another function
 * Or you don’t want it to be duplicated
 *
 * 2. crossinline
 * Normally, inside an inline function lambda, you are allowed to use a non-local return —
 * it means you can return directly from the caller function:
 * But in some cases (like using the lambda inside another function or thread), this kind of return would crash.
 * Using crossinline forbids using return inside the lambda. It only allows local returns,
 * making it safe to use inside other contexts (like Runnable, Thread, etc.)
 *
 * If you tried to write return inside a crossinline lambda, you’d get a compiler error
 *
 * can we use inlined the parameter but not the enclosing function?
 * in Kotlin you cannot inline only the parameter without also making the enclosing function itself inline.
 * What Kotlin allows:
 * You can only use inline, noinline, or crossinline inside an inline function.
 * If the function itself is not marked inline, then none of its parameters can be inlined.
 *
 * Cheatsheet:
 * | Modifier      | Meaning                                               |
 * | ------------- | ----------------------------------------------------- |
 * | `inline`      | Inline the function & its lambda params               |
 * | `noinline`    | Don’t inline *that* specific lambda                   |
 * | `crossinline` | Inline the lambda but forbid `return` from the caller |
 *
 */

inline fun process(a: () -> Unit, noinline b: () -> Unit) {
    a()            // will be inlined
    val x = b      // cannot inline b, so we store it
    x()
}

inline fun runTask(block: () -> Unit) {
    return block()      // non-local return is allowed here
}

fun test() {
    runTask {
        return      // returns from test()
    }
    println("Won't print")
}

inline fun doSomething(crossinline block: () -> Unit) {
    val r = Runnable {
        block()    // can't use non-local return
    }
    r.run()
}


// Extension Functions
// Add new functions to existing classes.
fun String.lastChar(): Char = this[this.length - 1]

/**
 * What really happens behind the scenes?
 * Kotlin compiles your extension function into a static utility method (a top-level Java-like function).
 *
 * When you call the extension, the compiler rewrites the call to that static method and passes the receiver object as a parameter.
 *
 * for example:
 * Kotlin code:
 * fun String.lastChar(): Char {
 *     return this[this.length - 1]
 * }
 *
 * You use it like:
 * val c = "Hello".lastChar()
 * The compiler rewrites it like Java:
 *
 *public static char lastChar(String receiver) {
 *     return receiver.charAt(receiver.length() - 1);
 * }
 *
 * // call becomes:
 * char c = lastChar("Hello");
 *
 *
 *  Scope of an Extension Function in Kotlin
 *  1, File-Level Scope
 *  Most commonly, extension functions are declared at the top level of a Kotlin file:
 *  This extension function will be available anywhere in the project — as long as
 *  you import it, or you're in the same package.
 *
 *  2. Scoped Inside an Object or Class
 *  You can also declare extension functions inside another class/object →
 *  then they are available only within that enclosing scope.
 */

class A {
    fun B.printHello() {
        println("Hello from B inside A")
    }

    fun call(b: B) {
        b.printHello()   // OK
    }
}

class B


//  Tail-Recursive Functions
// Optimizes recursion to prevent stack overflow.
/**
 * Tail recursion in Kotlin plays a crucial role in optimizing recursive functions and preventing stack overflow errors.
 *
 * Here's how it works:
 * Tail Call Optimization (TCO):
 * When a recursive function is tail-recursive, meaning the recursive call is the very last operation
 * performed in the function, the Kotlin compiler can apply Tail Call Optimization. This optimization
 * transforms the recursive calls into an iterative loop at compile time.
 *
 * Preventing Stack Overflow:
 * In traditional recursion, each recursive call adds a new frame to the call stack. For deep recursion,
 * this can lead to a stack overflow error as the stack memory is exhausted. Tail recursion, with TCO,
 * eliminates this issue because it doesn't build up the call stack. Instead, the function effectively
 * "jumps" back to the beginning of the loop, reusing the same stack frame.
 *
 * Enhanced Performance:
 * By converting recursion into iteration, tail recursion can sometimes offer performance improvements
 * by reducing the overhead associated with function calls and stack management.
 *
 * tailrec Modifier:
 * In Kotlin, you explicitly mark a tail-recursive function with the tailrec modifier. This serves two purposes:
 * It signals to the compiler that the function is intended for tail call optimization.
 * It enforces the tail-recursive nature of the function at compile time, ensuring that the recursive
 * call is indeed the last operation. If the function is not truly tail-recursive, the compiler will report an error.
 *
 * In essence, tail recursion allows developers to write recursive code in a functional style while gaining the
 * performance and safety benefits typically associated with iterative solutions.
 */

tailrec fun factorial(n: Long, acc: Long = 1): Long {
    return if (n == 0L) acc else factorial(n - 1, acc * n)
}

// Function Types & Typealiases
/**
 * Function types in Kotlin represent functions as first-class citizens,
 * meaning they can be stored in variables, passed as arguments,
 * and returned from other functions. They are defined using a specific syntax:
 *
 * has the following structure:
 * (ParameterType1, ParameterType2, ...) -> ReturnType
 *
 * by using the concept of kotlin's typealias we can give custom type name for the above Function type
 *
 * typealias NewFunctionTypeName = Function type
 *
 * example the code below
 */
typealias MathOperation = (Int,Int) -> Int
val multiply: MathOperation = {a,b -> a * b}
val add: MathOperation = {a,b -> a + b}
val subtract: MathOperation = {a,b -> a - b}
val division: MathOperation = {a,b -> try {
     a / b
} catch (e: Exception
) {
    println(e.message)
    -1
}
}

// Member & Top-Level Functions

//Top-level: Outside classes (recommended in Kotlin)
//Member: Inside classes/objects

// SAM(Single Abstract Method) Conversions
/**
 * SAM conversions in Kotlin, where SAM stands for Single Abstract Method,
 * refer to the ability to automatically convert a lambda expression into
 * an instance of a functional interface (or SAM interface). A functional
 * interface is an interface that contains only one abstract method and
 * there is fun keyword modifier before the interface keyword.
 *
 * Functional Interfaces: In Kotlin, you can declare a functional interface
 * by marking it with the fun modifier. Before Kotlin 1.4, SAM conversions
 * were primarily used for Java interfaces from Kotlin code.
 *
 * Lambda Expression: When a function or constructor expects an instance of
 * a functional interface as a parameter, you can provide a lambda expression
 * instead of explicitly creating an anonymous object that implements the interface.
 *
 * Automatic Conversion: The Kotlin compiler automatically converts the provided
 * lambda expression into an instance of the MyFunctionalInterface, where the
 * lambda's body becomes the implementation of the single abstract method (doSomething in this case).
 *
 * Benefits of SAM Conversions:
 * Conciseness:
 * Reduces boilerplate code by eliminating the need to write anonymous object declarations.
 * Readability:
 * Makes code cleaner and easier to understand, especially when dealing with callbacks or event listeners.
 */

fun interface MyFunctionalInterface {
    fun doSomething(value: String)
}

fun process(action: MyFunctionalInterface) {
    action.doSomething("Hello from SAM conversion!")
}

// Vararg Functions
//Accept variable number of arguments.

fun printAll(vararg items: String) {
    for (i in items) println(i)
}

fun main() {
    greet("Ali")                   // Hello, Ali
    greet(name = "Sara", message = "Hi") // Hi, Sara
    square(4) // will print out 16
    show(4) // this calls the function with int parameter type
    show("Muhammed") // this calls the function with string parameter type
    outer()
    val result = calculate(2, 3) { x, y -> x + y }
    println(result)   // 5

    process(
        { println("block a execution inlined")},
        {println("block b execution non inlined")}
    )
    test()
    doSomething {
        println("cross inlined block")
        //return // we cannot use return statement here
    }
    println("Hello".lastChar())  // 'o'
    A().call(B())
    //B().printHello() // ❌ ERROR: not visible here
    println(factorial(5)) // 120
    println(division(2,0)) // -1 since there is Arithmetic error (division by zero)
    // Using SAM conversion
    process { value -> println(value) }
    printAll("A", "B")
    printAll("A","B", "C")
}