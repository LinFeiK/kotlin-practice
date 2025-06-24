import kotlin.math.PI

data class Circle(var radius: Double): Shape {
    // before implementing Shape interface
    //    val area = PI * radius * radius

    // before implementing Shape interface
    override val perimeter: Double
        get() = circumference

    override val area: Double
        get() = PI * radius * radius

    override val type = "Circle"

    // only have = for variables if the values will not change after object creation
//    val diameter = 2 * radius
//    val circumference = 2 * diameter * PI

    // need getters here because the radius is a var
    val diameter: Double
        get() = 2 * radius

    val circumference: Double
        get() = PI * diameter
}