package basics

/**
 * This is kotlin operator
 */

// 1. Basic Arithmetic Operators

/**
 * for basic maths operator
 * | Operator | Description         | Example      |
 * | -------- | ------------------- | ------------ |
 * | `+`      | Addition            | `5 + 3 = 8`  |
 * | `-`      | Subtraction         | `5 - 3 = 2`  |
 * | `*`      | Multiplication      | `5 * 3 = 15` |
 * | `/`      | Division            | `5 / 2 = 2`  |
 * | `%`      | Modulus (remainder) | `5 % 2 = 1`  |
 */

// 2. Assignment  and Combined Operators

// for assignment operator for a variable and combination of assignment and arithmetic operator

/**
 * | Operator | Example  | Equivalent     |
 * | -------- | -------- | -------------- |
 * | `=`      | `a = 10` | Assign 10 to a |
 * | `+=`     | `a += 3` | `a = a + 3`    |
 * | `-=`     | `a -= 3` | `a = a - 3`    |
 * | `*=`     | `a *= 3` | `a = a * 3`    |
 * | `/=`     | `a /= 3` | `a = a / 3`    |
 * | `%=`     | `a %= 3` | `a = a % 3`    |
 */

// 3. Comparison Operators
// to compare tho number or Ascii equivalent of a char or string literal
/**
 * | Operator | Description      | Example  |
 * | -------- | ---------------- | -------- |
 * | `==`     | Equal to         | `a == b` |
 * | `!=`     | Not equal to     | `a != b` |
 * | `>`      | Greater than     | `a > b`  |
 * | `<`      | Less than        | `a < b`  |
 * | `>=`     | Greater or equal | `a >= b` |
 * | `<=`     | Less or equal    | `a <= b` |
 *
 * Note:
 *   Use == for structural equality (compares values), and === for reference equality (compares memory reference).
 */

// 4. Logical Operators
// to form logical boolean expression
/**
 * | Operator | Description | Example           |
 * | -------- | ----------- | ----------------- |
 * | `&&`     | Logical AND | `a > 1 && a < 10` |
 * | `||`     | Logical OR  | `a > 1 || a < 10` |
 * | `!`      | Logical NOT | `!isValid`        |
 */

// 5. Unary Operators
// are operators that is applied on a single operand

/**
 * | Operator | Description            | Example      |
 * | -------- | ---------------------- | ------------ |
 * | `+`      | Unary plus             | `+a`         |
 * | `-`      | Unary minus            | `-a`         |
 * | `++`     | Increment              | `a++`, `++a` |
 * | `--`     | Decrement              | `a--`, `--a` |
 * | `!`      | Not (logical negation) | `!flag`      |
 *
 * Note:
 *  a++ is post-increment (use first, then increase)
 *  ++a is pre-increment (increase first, then use)
 */

// 6. Range & Collection Operators
// that we apply in collections like list, set, map and their mutable counterpart
/**
 * | Operator | Description                  | Example             |
 * | -------- | ---------------------------- | ------------------- |
 * | `..`     | Range                        | `1..5` gives 1 to 5 |
 * | `in`     | Check membership             | `x in 1..5`         |
 * | `!in`    | Not in range                 | `x !in 1..5`        |
 * | `for`    | Iteration over range or list | `for (i in list)`   |
 */

// 7. Bitwise Operators (Advanced)
// Kotlin provides bitwise operators as functions, not symbols.
/**
 * | Function     | Equivalent in Java | Description          |            |
 * | ------------ | ------------------ | -------------------- | ---------- |
 * | `shl(bits)`  | `<<`               | Shift left           |            |
 * | `shr(bits)`  | `>>`               | Shift right          |            |
 * | `ushr(bits)` | `>>>`              | Unsigned shift right |            |
 * | `and(bits)`  | `&`                | Bitwise AND          |            |
 * | `or(bits)`   | \`                 | \`                   | Bitwise OR |
 * | `xor(bits)`  | `^`                | Bitwise XOR          |            |
 * | `inv()`      | `~`                | Bitwise NOT          |            |
 */

/**
 * Note:
 *  Backtick operator in Kotlin :
 *  In Kotlin, backticks (`` ` ``) serve a specific purpose primarily related to identifiers and naming conventions.
 *  Their main roles are:
 *  1: Escaping Keywords: Backticks allow the use of Kotlin keywords as identifiers
 *  (e.g., variable names, function names) when those keywords would otherwise cause
 *  a syntax error. This is particularly useful for interoperability with Java, where
 *  a valid Java identifier might be a keyword in Kotlin.
 *
 *  2: Allowing Special Characters and Spaces in Identifiers: Backticks enable the use of characters
 *  that are not typically allowed in identifiers, such as spaces or special symbols, within names.
 *  This is commonly leveraged in test code for creating more descriptive test method names.
 *
 *  Example:
 *     fun `should return true for valid input`() {
 *         // Test logic here
 *     }
 */

// 8. Elvis Operator ?:
// Returns a default value if the left side is null.
fun `Elvis Operartor Example`() {
    val name: String? = null
    val displayName = name ?: "Guest"
    println(displayName) // prints Guest as the name is null
}


// 9. Safe Call Operator ?.
// Used to avoid null pointer exceptions.

fun `Safe Call Operartor Example`() {
    val name: String? = null
    val displayLengthOfNameString = name?.length // when we apply the safe call operator the type will be
    // nullable of type of the method or property in the Receiver type to avoid nullability of the variable
    // we use elvis operator for default value in case the object mabe null
    println(displayLengthOfNameString) // prints Guest as the name is null
}


// 10, Not-null Assertion !!
// Throws NullPointerException if the variable is null.

// 11. Type Cast Operators

/**
 * | Operator | Description                       | Example                |
 * | -------- | --------------------------------- | ---------------------- |
 * | `as`     | Unsafe cast                       | `val x = y as String`  |
 * | `as?`    | Safe cast (returns null if fails) | `val x = y as? String` |
 */

// 12. Destructuring Declarations
// apply for data class only created with data key word when we create those classes
// Use componentN operators (operator functions behind the scenes).

data class Point(val x: Int, val y: Int)
fun destructuringExample() {
    val (x, y) = Point(3, 4)
    println(x) // prints 3
    println(y) // prints 4
}

// 13. Operator Overloading
// Kotlin allows custom operators for your classes using operator keyword.

data class Vector(val x: Int, val y: Int) {
    operator fun plus(v: Vector) = Vector(x + v.x, y + v.y)
}
fun operatorOverloadingExample() {
    val v1 = Vector(1, 2)
    val v2 = Vector(3, 4)
    val result = v1 + v2  // Vector(4, 6)
    println(result) // prints Vector(x = 4, y= 6)
}

/**
 * Summary Table of Operator Categories
 * | Category             | Example           |   |         |
 * | -------------------- | ----------------- | - | ------- |
 * | Arithmetic           | `+`, `-`, `*`     |   |         |
 * | Assignment           | `=`, `+=`         |   |         |
 * | Comparison           | `==`, `<`, `!=`   |   |         |
 * | Logical              | `&&`, \`          |   | `, `!\` |
 * | Unary                | `++`, `--`        |   |         |
 * | Range & Membership   | `in`, `..`, `!in` |   |         |
 * | Bitwise (functions)  | `shl()`, `and()`  |   |         |
 * | Null-safety          | `?:`, `?.`, `!!`  |   |         |
 * | Type casting         | `as`, `as?`       |   |         |
 * | Operator overloading | `operator fun`    |   |         |
 */






fun main() {
    `Elvis Operartor Example`()
    `Safe Call Operartor Example`()
    destructuringExample()
    operatorOverloadingExample()

}


