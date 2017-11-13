import kotlinx.coroutines.experimental.async
import java.nio.charset.StandardCharsets

/**
 * Kotlin Example
 *
 * Refer to [Car]
 */
fun main(args: Array<String>) {
    val mycar = Car("VW", "Passat", 2001)

    val yourcar = Car(make = "BMW",
            model = "M3")

    println("${yourcar.make}")

    println("""
Hello there... This
is a
multi-line string!
""")

    val name = "Ray"

    if (name == "Ray") {
        println("Your name is Ray!")
    }

    val c1 = Color(100, 100, 100)
    val c2 = Color(21, 32, 34)
    val c3 = c1 + c2

    println(c3)

    c3.darken()

    async {

    }
}

// 1. Semicolons
fun semicolons() {
    println("Hello from Java!")
}

// 2. Nullability
fun nullpointers(s: String) {
    val bytes = s.toByteArray(StandardCharsets.UTF_8)
}

// 3. Data Class
// 4. Named Parameter
// 5. Default Values
data class Car(val make : String,
               val model : String,
               val year : Int = 2010)

// 6. Setter/Getter on Properties


// 7. String Template
// 8. Multi-line String
// 9. Equality vs. Identity

// 10. Operator Overloading
data class Color(val r : Int,
                 val g : Int,
                 val b : Int) {
    var name : String = ""
    set(value) {
        if (name.isEmpty()) {
            throw IllegalArgumentException();
        }
        this.name = value;
    }
}

operator fun Color.plus(another : Color) : Color {
    return Color (this.r + another.r,
            this.g + another.g,
            this.b + another.b)
}

// 11. Extension Functions
fun Color.darken() : Color {
    return Color(this.r - 1,
            this.g - 1,
            this.b - 1)
}

// 12. KDoc vs JavaDoc!

// Watch out though!
// 1. Public by default!
// 2. Design for override - overriding is explicit! (open, override)
// 3. No ternary operator

open class Vehicle(licensePlate : String, wheels : Int) {
    open fun operate() {
        println("driving the vehicle")
    }
}

class Motorcycle(licensePlate : String, wheels : Int) :
        Vehicle(licensePlate, wheels) {
    override fun operate() {
        println("riding the motorcycle")
    }
}

