package control_flow

// 1. Basic Control Flow

    /******* Selection Control Flows ***********/

    // if Expression(can be used as statement or expression
    // Kotlin's if is an expression (returns a value).

    fun `if as expression example`() { // remember the backtick is used to write custom identifier even to use keywords
        // and symbols as function as identifier
        val a = 10
        val b = 20
        val max = if (a > b) a else b
        println("Max is $max")
    }

    fun `if as statement example`() {
        val a = 10
        val b = 20
        if (a > b) {
            println("A is greater")
            a
        } else {
            println("B is greater")
            b
        }

    }

    // when Expression (Kotlin's switch) also used as statement like if

    fun `when as expression example`() {
        val x = 2
        val result = when (x) {
            1 -> "One"
            2 -> "Two"
            in 3..5 -> "Three to Five"
            else -> "Unknown"
        }
        println(result)
    }

    fun `when as statement example`() {
        val x = 2
        when (x) {
            1 -> println("One")
            2 -> println("Two")
            in 3..5 -> println("Three to Five")
            else -> println("Unknown")
        }
    }


    // also works for type check
    fun checkType(obj: Any) = when (obj) {
        is String -> "String"
        is Int -> "Integer"
        else -> "Unknown"
    }


    /******* Iterator Control Flows ***********/

    // for Loop(To iterate a collection this can be range collection, string, list and
    // any other collection that implement iterator interface

    fun `for loop example`() {
        val list = listOf("a", "b", "c")
        for (item in list) {
            println(item)
        }

        for (i in 1..5) println(i)        // 1 to 5
        for (i in 1 until 5) println(i)   // 1 to 4
        for (i in 5 downTo 1) println(i)  // 5 to 1
        for (i in 0..10 step 2) println(i) // 0, 2, 4...

    }

    // while and do..while( they are used to repeat the block of code until the condition become false
    // the former(while pre condition check) and the later(do..while post condition check meaning the bock is executed at least one times)
    fun `while and do while loop example`() {
        var i = 0
        while (i < 5) {
            println(i)
            i++
        }

        do {
            println(i)
            i--
        } while (i > 0)

    }

// 2. Advanced Control Flow

    // Labels in Loops
    // The '@outer' annotation Used to break or continue outer loops:
    fun `the outer@ annotation example`() {
        outer@ for (i in 1..5) {
            for (j in 1..5) {
                if (j == 3) break@outer // or continue@outer
                println("i=$i, j=$j")
            }
        }
    }

    // return, break, continue in Lambdas

    fun `return without lable example`() {
        listOf(1, 2, 3).forEach {
            if (it == 2) return // returns from enclosing function!
            println(it)
        }

        println("After the return statement of lambda block no code executed as it returns from enclosing function")
    }

    fun `return with lable example`() {
        listOf(1, 2, 3).forEach label@{
            if (it == 2) return@label // returns from current iteration and move to the next iteration!
            // has semantic equivalent to continue statement in regular loop
            println(it) // will print out 1 and 3
        }

        // to totally break the lambda loop we should use remove the 'label@' annotation in the opening curly brace
        // and use "return@run" with rub {...} block has semantic equivalent to break statement in regular loop

        run {
            listOf(1, 2, 3).forEach {
                if (it == 2) return@run // returns from current iteration and move to the next iteration!
                // has semantic equivalent to continue statement in regular loop
                println(it) // will print out 1 only
            }

        }

        // this code is executed since the return is exite from the lambda scope
        println("After the return statement of lambda block this code is executed as it returns from lambda scope not from the enclosing function")
    }

    // Custom Flow Control with Sealed Classes

    // Sealed classes can enhance when to be exhaustive:

    sealed class Result
    data class Success(val data: String) : Result()
    object Error : Result()

    fun handle(result: Result) = when (result) {
        is Success -> println(result.data)
        is Error -> println("Error occurred")
    }

    // control flow in exception handling
    // Try-Catch-Finally
    fun calculateSquareRoot(number: Double): Double {
        if (number < 0) {
            throw IllegalArgumentException("Cannot calculate the square root of a negative number.")
        }
        return Math.sqrt(number)
    }
    fun `try-catch-final as statement example`() {
        try { // this block executed until exception is occurred this implies the code before exception statement executed and after that go to the catch block and then finally block
            val result = calculateSquareRoot(2.0)
        } catch (e: Exception) { // executed when there is exception
            println("Caught: ${e.message}")
        } finally { // the finally block is executed whether there is exception or not
            println("Cleanup code")
        }

    }






fun main() {
    `if as expression example`()
    `if as statement example`()
    `when as expression example`()
    `when as statement example`()
     println(checkType("Muhammed"))
    `for loop example`()
    `while and do while loop example`()
    `the outer@ annotation example`()
    `return without lable example`()
    `return with lable example`()
    handle(Success("Successful network request"))
    `try-catch-final as statement example`()

}