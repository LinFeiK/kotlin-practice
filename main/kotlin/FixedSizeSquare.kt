// Singleton; refer to it with its class name
// Can't have a constructor
// Fixed size of 5x5
// Can also have "data object" -> toString() only prints the class name
// Used to bundle relate functionalities/utilities (unlike in this example), like DateUtil
object FixedSizeSquare: Shape {
    // no need for getters since it's always the same value
    override val area = 25.0
    override val perimeter = 20.0
    override val type = "Square"
}