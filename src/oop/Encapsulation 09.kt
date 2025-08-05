package oop

/**
 * ---------------------------------------------
 * 09_encapsulation.kt
 * Topic: Encapsulation in Kotlin
 * ---------------------------------------------
 *
 * Encapsulation is the OOP concept of hiding the internal
 * implementation details and exposing only what is necessary.
 *
 * We achieve this using *access modifiers* (private, protected, public, internal)
 * and getter/setter for properties.
 */

class BankAccount(private var balance: Double) {

    // Public method to deposit money
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $$amount, New Balance = $$balance")
        } else {
            println("Invalid deposit amount")
        }
    }

    // Public method to withdraw money
    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $$amount, Remaining Balance = $$balance")
        } else {
            println("Invalid withdrawal amount OR insufficient funds")
        }
    }

    // Getter that exposes balance in a safe way
    fun getBalance(): Double = balance
}

// -----------------------------------------
fun main() {
    val account = BankAccount(100.0)

    account.deposit(50.0)
    account.withdraw(30.0)

    // Cannot directly access balance: account.balance ❌ (private)
    println("Current Balance = $${account.getBalance()}")
}

/*
OUTPUT:
Deposited $50.0, New Balance = $150.0
Withdrew $30.0, Remaining Balance = $120.0
Current Balance = $120.0
*/

/**
 * KEY POINTS:
 * ✔ Encapsulation = Hide internal data & logic
 * ✔ Use access modifiers + getters/setters
 * ✔ Protects object integrity and prevents misuse
 */
