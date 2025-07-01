// Open classes can be instantiated, abstract classes can't
// Must provide implementation for open class variables.
//   Add the 'open' keyword to let them be overridable in subclasses.
// Can't be both open and data class
open class Cat(
    override val name: String,
    override val age: Int
): Animal() {
    open val breed = "Cat"

    override val sound: String
        get() = "Meow"
}