data class MaineCoonCat(
    override val name: String,
    override val age: Int
): Cat(name, age) {
    override val breed = "Maine Coon"
}
