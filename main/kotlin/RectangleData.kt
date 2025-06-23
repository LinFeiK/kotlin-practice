import kotlin.math.sqrt

// data classes: rect1 == rect2 -> false if their reference is different
data class RectangleData(var width: Float, var height: Float) {
    val area = width * height

    val diagonal = sqrt(width * width + height * height)
}

// non-data classes: rect1 == rect2 -> true if the data in the objects is the same
class RectangleNotData(var width: Float, var height: Float) {
    val area = width * height

    val diagonal = sqrt(width * width + height * height)
}
