import kotlin.math.sqrt

// data classes: rect1 == rect2 -> false if their reference is different
data class RectangleData(var width: Double, var height: Double): Shape {
    // before implementing Shape interface
//    val area = width * height

    // after implementing Shape interface
    override val area: Double
        get() = width * height.toDouble()

    override val perimeter: Double
        get() = 2.0 * width + 2 * height

    // does not work as intended if width/height changes; would only calculate this once at object creation
//    override val perimeter = 2 * width + 2 * height

    // doesn't need to get recalculated, therefore doesn't need get()
    override val type = "RectangleData"

    val diagonal: Double
        get() = sqrt(width * width + height * height)
}

// non-data classes: rect1 == rect2 -> true if the data in the objects is the same
class RectangleNotData(var width: Float, var height: Float) {
    // only use = if the values will not change after object creation
    // not the case here since the parameters are vars
//    val area = width * height
//    val diagonal = sqrt(width * width + height * height)

    val area: Float
        get() = width * height

    val diagonal: Float
        get() = sqrt(width * width + height * height)
}
