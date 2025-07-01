data class Dog(
    override val name: String,
    override val age: Int
) : Animal() {
    override val sound: String
        get() = "Woof"
}