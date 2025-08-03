package oop

/**
 * ---------------------------------------------
 * 02_constructors.kt
 * Topic: Constructors in Kotlin
 * ---------------------------------------------
 *
 * Constructors are special blocks used to initialize objects.
 * Kotlin has:
 *   1) Primary constructor
 *   2) Secondary constructor
 */

// ----------------------------------------------------
// Example 1: Using a Primary Constructor
// (defined in the class header)
class Car(val brand: String, val model: String, var year: Int) {

    // initializer block runs when object is created
    init {
        println("New car object created: $brand $model ($year)")
    }
}

// ----------------------------------------------------
// Example 2: Primary + Secondary Constructor
class Student(val name: String) {

    var age: Int = 0

    // secondary constructor
    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    fun info() {
        println("Student name: $name, age: $age")
    }
}

// ----------------------------------------------------
fun main() {
    // Using primary constructor
    val car = Car("Toyota", "Corolla", 2020)

    // Using secondary constructor
    val student1 = Student("Ali")
    student1.info()  // age will be 0

    val student2 = Student("Sara", 22)
    student2.info()
}

/*
OUTPUT:
New car object created: Toyota Corolla (2020)
Student name: Ali, age: 0
Student name: Sara, age: 22

KEY POINTS:
✔ Primary constructor goes in the class header
✔ Secondary constructor starts with 'constructor'
✔ 'init {}' block runs during object creation
 */
