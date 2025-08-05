package oop

/**
 * Topic 07: Difference between Interface and Abstract class
 * This file provides a detailed explanation of the differences between an
 * abstract class and an interface in Kotlin, including their use cases,
 * advantages, and code examples.
 *
 * Both abstract classes and interfaces are used to define a contract or a
 * blueprint for other classes. The key difference lies in what they can
 * contain and how they are inherited/implemented.
 */

// -----------------------------------------------------------------------------
// 1. Interface
// -----------------------------------------------------------------------------
// An interface in Kotlin is a blueprint of a class. It can contain
// abstract declarations as well as implementations of methods.
//
// Key Characteristics:
// - It cannot hold state (properties must be abstract or have custom getters).
// - A class can implement multiple interfaces.
// - Interfaces can inherit from other interfaces.
// - All members of an interface are 'open' by default, meaning they can be
//   overridden.
// - Methods with a body are 'default' implementations that implementing
//   classes can choose to override.

/**
 * Use Case for Interface:
 * Define a capability or a contract that a class "can do".
 * For example, a 'Clickable' interface defines the behavior of being clickable,
 * and any class that is 'Clickable' must provide an implementation for the
 * 'onClick' function. This is a classic "has-a" or "can-do" relationship.
 */
interface Clickable {
    // An abstract property. Implementing classes must provide a value.
    val isClickable: Boolean

    // An abstract function. Implementing classes must provide a body.
    fun onClick()

    // A default implementation for a function.
    fun onLongClick() {
        println("Default behavior: Long click not implemented.")
    }
}

/**
 * An example class that implements the Clickable interface.
 * It must provide implementations for the abstract members of the interface.
 */
class Button : Clickable {
    override val isClickable: Boolean = true

    override fun onClick() {
        println("Button was clicked!")
    }

    // We can choose to override the default implementation.
    override fun onLongClick() {
        println("Button was long-clicked! This is a custom implementation.")
    }
}

// -----------------------------------------------------------------------------
// 2. Abstract Class
// -----------------------------------------------------------------------------
// An abstract class is a class that cannot be instantiated on its own.
// It is designed to be a base class for other classes to inherit from.
//
// Key Characteristics:
// - It can have state (properties with backing fields).
// - It can have constructors.
// - It can have both abstract and non-abstract (concrete) members.
// - A class can inherit from only one abstract class.
// - Abstract members must be implemented by subclasses.
// - Non-abstract members are inherited and can be overridden if they are 'open'.

/**
 * Use Case for Abstract Class:
 * Define a common base class for a family of related classes that share
 * both state and behavior. This is a classic "is-a" relationship.
 * For example, 'BaseAnimal' can provide common properties like 'name' and
 * common behavior like 'eat()' for all animals, while forcing subclasses
 * to implement unique behaviors like 'makeSound()'.
 */
abstract class BaseAnimal(val name: String) {
    // A concrete property with a default value. This represents shared state.
    var age: Int = 0

    // An abstract function that subclasses must implement.
    abstract fun makeSound()

    // A concrete function with a default implementation that all animals share.
    fun eat() {
        println("$name is eating.")
    }
}

/**
 * An example class that inherits from the abstract class BaseAnimal.
 * It must provide an implementation for the abstract 'makeSound' function.
 */
class Dog(name: String) : BaseAnimal(name) {
    override fun makeSound() {
        println("$name says: Woof!")
    }
}

class Cat2(name: String) : BaseAnimal(name) {
    override fun makeSound() {
        println("$name says: Meow!")
    }
}

// -----------------------------------------------------------------------------
// 3. Main function to demonstrate the examples
// -----------------------------------------------------------------------------
fun main() {
    // Demonstrate Interface
    println("--- Demonstrating Interface ---")
    val button = Button()
    button.onClick()
    button.onLongClick()
    println("Is the button clickable? ${button.isClickable}")
    println()

    // Demonstrate Abstract Class
    println("--- Demonstrating Abstract Class ---")
    val dog = Dog("Buddy")
    dog.age = 5
    dog.eat()
    dog.makeSound()
    println("The dog's name is ${dog.name} and he is ${dog.age} years old.")
    println()

    val cat = Cat2("Whiskers")
    cat.eat()
    cat.makeSound()
    println("The cat's name is ${cat.name}.")
    println()
}

// -----------------------------------------------------------------------------
// 4. Summary of Key Differences
// -----------------------------------------------------------------------------
/**
 * Advantages of an Abstract Class over an Interface:
 * - Can have constructors, allowing for shared initialization logic.
 * - Can hold state (properties with backing fields), which is useful for
 * sharing common data among subclasses.
 * - Can provide concrete, non-abstract members that cannot be overridden
 * by subclasses (by not using the 'open' keyword).
 *
 * Advantages of an Interface over an Abstract Class:
 * - A class can implement multiple interfaces, allowing for greater
 * flexibility and a better way to model multiple capabilities.
 * - Interfaces are ideal for defining a contract without dictating any
 * implementation details or state.
 *
 * When to use which:
 * - Use an **interface** when you want to define a contract for a capability
 * that classes can "have" or "do". Use it for a "has-a" relationship.
 * Example: All `Clickable` things, all `Serializable` things.
 *
 * - Use an **abstract class** when you want to define a base class for a
 * family of related classes that share common behavior and state. Use it
 * for an "is-a" relationship.
 * Example: All `Animals` are a type of `BaseAnimal`, all `Shapes` are a type
 * of `BaseShape`.
 */
