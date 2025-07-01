// Can't inherit from regular classes/data classes
// To be inheritable, must be either an abstract or an open class
// Abstract classes can't be directly instantiated
abstract class Animal() {
    abstract val name: String
    abstract val age: Int
    abstract val sound: String
}