import kotlin.math.PI

data class Circle(var radius: Float) {
    val area = PI * radius * radius

    val diameter = 2 * radius

    val circumference = 2 * diameter
}