package oop

/**
 * ---------------------------------------------
 * 12_enum_class.kt
 * Topic: Enum Classes in Kotlin
 * ---------------------------------------------
 *
 * Enum (enumeration) classes are used to represent a fixed set
 * of constant values. Each enum constant is an object.
 */

// Basic enum
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

// Enum with properties & functions
enum class Day(val isWeekend: Boolean) {
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true);

    fun printInfo() {
        println("$name → Weekend: $isWeekend")
    }
}

// ---------------------------------------------------
fun main() {
    val currentDir = Direction.NORTH
    println("Direction = $currentDir")

    for (d in Direction.values()) {
        println(d)
    }

    val today = Day.SUNDAY
    today.printInfo()

    // get ordinal (position)
    println("${today.name} is at index ${today.ordinal}")
}

/*
OUTPUT:
Direction = NORTH
NORTH
SOUTH
EAST
WEST
SUNDAY → Weekend: true
SUNDAY is at index 6
*/

/**
 * KEY POINTS:
 * ✔ Enum is used when the value must be one from a predefined list
 * ✔ Each constant can have properties & methods
 * ✔ Useful in when/branching, type-safety, readable code
 */
