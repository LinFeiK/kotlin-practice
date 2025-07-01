// Interfaces can't be directly instantiated
// They can declare variables but not their (default or non-default) values
// They can declare functions but not their functionality
// Could also have "sealed interface Shape" -> can only be implemented in this module
interface Shape {
    val area: Double
    val perimeter: Double
    val type: String
}