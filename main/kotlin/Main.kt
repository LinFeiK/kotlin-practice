import kotlin.math.max
import kotlin.text.iterator

fun main() {
//    arrays()

    // Classes
//    classes()
//    abstractOrOpenClasses()
//    enumClasses()
    objectClasses()

//    conditionals()

    // Exceptions
//    try {
//        exceptions()
//    } catch (e: Exception) {
//        println("exceptions() function was run; threw exception with message: ${e.message}")
//    }


    // Functions
    // default value of a function
//    println("Function call without parameter passed, using default value:")
//    getValidIntValue()
//    println()
//    println("Function call with parameter passed: ")
//    getValidIntValue("Modified message. Enter a number: ")

    // extension functions
//    extensionFunctions()

    // lambda functions
//    lambdaFunctions()

    // named parameters
//    getValidIntValue(warningMessage = "Please enter a number: ")

//    interfaces()

//    lists()

//    loops()
//    forLoops()

//    mathOperators()

//    strings()

//    userInput()
}

fun arrays() {
    var numbers = intArrayOf(1, 5, 2)
    println(numbers[1]) // 5
    println(numbers.getOrNull(5)) // null since there's no 6th element in the array

    numbers[0] = 6

    println(numbers.toString()) // doesn't show all the elements

    println("Size is ${numbers.size}")

    numbers = numbers.plus(4)
    println("Added ${numbers[3]}")

    println("Size is ${numbers.size}")

    for (i in 0 until numbers.size) {
        println(numbers[i])
    }

    println("Last index is ${numbers.lastIndex}")

    numbers += 10
    for (i in 0..numbers.lastIndex) {
        println(numbers[i])
    }

    println(numbers.contentToString())
}


fun classes() {
    val rect1 = RectangleData(5.0, 10.0)
    println("Rect 1 has a width of ${rect1.width} and a height of ${rect1.height}.")
    println("The area is ${rect1.area} and the diagonal is ${rect1.diagonal}.")

    val rect2 = RectangleData(7.0, 9.0)
    println("Rect 2 has a width of ${rect2.width} and a height of ${rect2.height}.")
    println("The area is ${rect2.area} and the diagonal is ${rect2.diagonal}.")

    val maxArea = maxRectArea(rect1, rect2)
    println("The rectangle with the maximum area is the one with area $maxArea.\n")


    // comparing == for data classes vs non-data classes
    rect2.width = 5.0
    rect2.height = 10.0
    println("Rect 2's width is now ${rect2.width} and height is now ${rect2.height}.")
    // true for data classes -> compares the data/fields
    println("Data classes: Are Rect 1 and Rect 2 the same? ${rect1 == rect2}.\n")

    val rect3 = RectangleNotData(9f, 11f)
    val rect4 = RectangleNotData(9f, 11f)
    println("Rect 3 has ${rect3.width} width, ${rect3.height} height.")
    println("Rect 4 has ${rect4.width} width, ${rect4.height} height.")
    // false for non-data classes -> compares the references
    println("Non-data classes: Are Rect 3 and Rect 4 the same? ${rect3 == rect4}.\n")


    // comparing toString for data classes vs non-data classes
    println("Data class Rect 1: $rect1") // nice format
    println("Non-data class Rect 3: $rect3\n") // address in memory


    // copy function (only for data classes)
    // keeps everything the same as the original
    // if we want to change one or more field value, pass the changed value as a parameter to copy()
    val rect5 = rect2.copy(
        width = 6.0
    )
    println("Rect 5 copied from Rect 2 except with width of ${rect5.width}. The height is ${rect5.height}.\n")


    // circles
    val circle = Circle(6.0)
    println("$circle with area ${circle.area} and circumference ${circle.circumference}.")
}

fun maxRectArea(rect1: RectangleData, rect2: RectangleData): Double {
    return max(rect1.area, rect2.area)
}

fun abstractOrOpenClasses() {
    // can't do
//    animal = Animal()

    // abstract class Animal, open class Cat
    val animal1: Animal = Cat("Kitty", 3) // works for open classes
    val animal2: Animal = MaineCoonCat("Minny", 4)
    val animal3 = Dog("Doggy", 5)

    println(animal1.javaClass) // Cat
    println(animal2.javaClass) // MaineCoonCat
    println(animal3.javaClass) // Dog

    val animals = listOf(animal1, animal2, animal3)
    for (animal in animals) {
        println(animal.sound)
        println("Is of class Animal: ${animal is Animal}") // always true, even for animal3
        println("Is of class Cat: ${animal is Cat}")
        println("Is of class MaineCoonCat: ${animal is MaineCoonCat}")
        println("Is of class Dog: ${animal is Dog}")

        val name = animal.name
        when(animal) {
            is Cat -> println("This is a ${animal.breed} named $name.")
            is Dog -> println("This is a Dog named $name.")
        }
        println()
    }
}

fun enumClasses() {
    for (country in Country.entries) {
        println(greetByCountry(country))
    }

    println()
    for (country in CountryWithCode.entries) {
        println("${country.name}'s code is ${country.code}.")
    }
}

fun greetByCountry(country: Country): String {
    return when(country) {
        Country.CANADA -> "Hello from Canada!"
        Country.FRANCE -> "Bonjour from France!"
        Country.NEW_ZEALAND -> "Hello from New Zealand!"
        Country.USA -> "Hello from the US!"
    }
}

fun objectClasses() {
    println(FixedSizeSquare)
    println("${FixedSizeSquare.area} area, ${FixedSizeSquare.perimeter} perimeter.")
}


fun conditionals() {
    print("Enter a number: ")
    val input = readln()
    val inputAsInt = input.toIntOrNull() ?: -1

    // conditionals used to return a value/parameter for a function
    println(if (inputAsInt % 2 == 0) {
        "Is even"
    } else if (inputAsInt == -1) {
        "Is either -1 or not an integer"
    } else {
        "Is odd"
    })

    // lambdas with 'when'
    var output = when {
        inputAsInt == -1 -> {
            println(input)
            "Was either -1 or not an integer"
        }
        inputAsInt <= 10 -> "Was less than or equal to 10"
        else -> "Was bigger than 10"
    }
    println(output)

    output = when(inputAsInt) {
        0 -> "Was 0"
        in 1..10 -> "Was between 1 and 10 inclusive"
        in 11 until 20 -> "Was between 11 inclusive and 20 not inclusive"
        // cannot do '> 0' type conditions
        // can do 'is String' type conditions
        else -> "Was a negative number, invalid, or bigger than or equal to 0"
    }
    println(output)
}


fun exceptions() {
    // can be used to assign values
    print("Enter a number: ")
    val input = try {
        readln().toInt()
    } catch (e: NumberFormatException) {
        println(e.javaClass)
        println(e.message)
        -1
    } finally {
        // happens even if there was an exception thrown
        // for cleanup, closing resources, etc.
    }

    println("The input is $input. -1 may appear if the originally entered value is not a number.")

    throw Exception("Custom exception thrown")
}


fun extensionFunctions() {
    print("String to be reversed: ")
    val inputString = readln()

    println("Reversed string: ${inputString.reverseIt()}")

    print("Integer to be reversed: ")
    val inputInt = getValidIntValue()
    println("Reversed integer: ${inputInt.reverseIt()}")
}

// Extension function to reverse the letters of a string.
private fun String.reverseIt(): String {
    val result = buildString {
        // need this@reverseString to specify that we're not looking for the 'this' of 'buildString'
        for (i in this@reverseIt.lastIndex downTo 0) {
            append(this@reverseIt[i])
        }
    }

    return result
}

// Extension function to reverse the digits in an integer. Overloads String.reverseIt() above
private fun Int.reverseIt(): Int {
    return this.toString().reverseIt().toInt()
}

fun lambdaFunctions() {
    // Lambdas passed directly
    print("Enter a string with numbers: ")
    val input = readln()
    val numbersRemoved = input.filter {
        // it -> element being iterated over. In this case, the Char being iterated over.
        // last line of a lambda is the returning value for that lambda
        //  putting 'return' will return the enclosing function (here, lambdaFunctions)
        it.isLetter()
    }

    println("The string with the numbers removed: $numbersRemoved\n")


    val intList = mutableListOf(1, 5, 29, 30, 25)
    println("Original array: $intList")

    val oddNums = intList.filter {
        // will ask for each Int in the array, is it odd?
        //  if yes, keep it in the filtered array
        it % 2 == 1
    }
    println("Only odd numbers: $oddNums\n")

    val intArray = intArrayOf(1, 5, 29, 30, 25)
    println("Original array's address in memory: $intArray")

    // can also name the lambda parameter to avoid using 'it'
    val oddNumsArry = intArray.filter { currentChar ->
        // will ask for each Int in the array, is it odd?
        //  if yes, keep it in the filtered array
        currentChar % 2 == 1
    }

    // filter function for IntArray returns a List, which is why its toString function works as we want
    println("Only odd numbers: $oddNumsArry\n")


    // Lambdas saved in a variable and passed like a regular parameter
    val isAbove18: (Int) -> Boolean = {
        it > 18
    }
    val numsAbove18 = intArray.filter(isAbove18)
    println("Numbers above 18: $numsAbove18\n")


    // Multi-parameter lambdas need named parameters instead of just 'it' since that can't be resolved
    val charLessThanNum: (Int, Char) -> Boolean = { num, char ->
        char.isDigit() && char.digitToInt() < num
    }

    val mixNumsAndChar = "23boo30299556280"
    print("Original string: $mixNumsAndChar.\nFiltered string: ")
    println(mixNumsAndChar.filterWithNum(5, charLessThanNum) + "\n")


    // map returns a list of each character transformed using the lambda passed as its parameter
    val squaringNums = mixNumsAndChar.map {
        if (it.isDigit()) {
            it.digitToInt() * it.digitToInt()
        } else {
            // has to be the same type to map into a list
            // if keeping non-digits as Chars, would return List<Unit>
            -1
        }
    }
    println("Original: $mixNumsAndChar.\nNumbers squared: $squaringNums\n")

    val digitsOnly = mixNumsAndChar.myFilter {
        // basically passing the Char extension function as the argument for the String extension function
        // cannot put it.isDigit() but CAN put this.isDigit()
        isDigit()
    }
    println("Original: $mixNumsAndChar.\nNumbers only: $digitsOnly\n")
}

// Extension function that accepts another function.
// Returns a String filtered with the given predicate based on num.
fun String.filterWithNum(num: Int, predicate: (Int, Char) -> Boolean): String {
    return buildString {
        for(char in this@filterWithNum) {
            if(predicate(num, char)) {
                append(char)
            }
        }
    }
}

// Extension function that accepts an extension function of Char as a predicate.
// Returns a String filtered with the given predicate.
fun String.myFilter(predicate: Char.() -> Boolean): String {
    return buildString {
        for (c in this@myFilter) {
            // Can also use  if (predicate(c)) {
            if (c.predicate()) {
                append(c)
            }
        }
    }
}


fun interfaces() {
    val rect1 = RectangleData(7.0, 10.0)

    println("Rect 1 with width ${rect1.width} and height ${rect1.height}. Perimeter is ${rect1.perimeter}. " +
            "Area is ${rect1.area}.")

    val circle1 = Circle(9.0)
    println("Circle with radius ${circle1.radius} and circumference ${circle1.circumference}. " +
            "Area is ${circle1.area}.")

    val sumAreas = sumAreas(rect1, circle1)
    println("Sum of their areas: $sumAreas")
}

fun sumAreas(vararg shapes: Shape): Double {
    return shapes.sumOf { currentShape ->
        currentShape.area
    }
}


fun lists() {
    print("How many numbers do you want in the list? ")
    var size = readln().toIntOrNull()
    while (size == null || size < 0) {
        print("Invalid input. How many numbers do you want to enter? ")
        size = readln().toIntOrNull()
    }

    // mutableLists recommended over arrays for lists that change in size
    // arrays' size is immutable, whereas mutableLists' size is mutable
    val numbers = mutableListOf<Int>()
    var number: Int
    for (i in 0 until size) { // does not include size. To include, use 0..size
        print("Enter number #${i + 1}: ")
        number = readln().toIntOrNull() ?:
            getValidIntValue("Invalid input. Enter number #${i + 1}: ")
        numbers.add(number)
    }

    println("Numbers: $numbers")
}

// Displays warningMessage and waits for user input until the user inputs a valid integer.
private fun getValidIntValue(warningMessage: String = "Enter a valid integer: "): Int {
    print(warningMessage)

    var input = readln().toIntOrNull()
    while (input == null) {
        print(warningMessage)
        input = readln().toIntOrNull()
    }

    return input
}


fun loops() {
    forLoops()
    whileLoops()
}

fun forLoops() {
    val numbersArray = intArrayOf(5, 29, -1)

    // for loop with increasing counter
    for (i in 0 until numbersArray.size) {
        println("Element #${i+1}: ${numbersArray[i]}")
    }


    println("Elements:")

    // for loop for each element in the array
    // index not as easily accessible as above
    for (number in numbersArray) {
        println(number)
    }

    // downward iteration
    println("Downward iteration:")
    for (i in numbersArray.size - 1 downTo 0) {
        println(numbersArray[i])
    }

    // for loop for characters in a String
    for (char in "Hello") {
        println(char)
    }


    // labelling outer loops to break out of them instead of an inner loop
    // without specifying the outer loop label, breaks out of the inner loop only
    outerLoop@ for (i in 1..5) {
        for (j in 1..10) {
            println("i = $i, j = $j")
            if (i == 4 && j == 3) {
                println("Breaking out of the inner loop only")
                break
            }
        }
    }
    println("End of 1st loops.\n")

    // specifying the outer loop label correctly makes it break out of the outer loop
    println("With labels:")
    outerLoop@ for (i in 1..5) {
        for (j in 1..10) {
            println("i = $i, j = $j")
            if (i == 4 && j == 3) {
                println("Breaking out of the outer loop")
                break@outerLoop
            }
        }
    }

}

fun whileLoops() {
    var isContinue = "Y"

    while (isContinue == "Y") {
        print("Do you want to continue being asked this question? (Y/N) ")
        isContinue = readln().uppercase()
    }

    // using [continue] keyword
    print("How many numbers do you want to enter? ")
    var size = readln().toIntOrNull()
    while (size == null || size < 0) {
        print("Invalid input. How many numbers do you want to enter? ")
        size = readln().toIntOrNull()
    }

    var i = 0
    var value: Int
    while (i < size) {
        print("Enter number #${i + 1}: ")
        value = readln().toIntOrNull() ?: continue // won't increase i for invalid input
        println("You've entered the valid value $value")
        i++
    }

    // using [break] keyword
    i = 0
    var input: String
    while (i < size) {
        print("Enter number #${i + 1} or \"break\" before entering $size numbers: ")

        input = readln()
        if (input.uppercase() == "BREAK") break

        value = input.toIntOrNull() ?: continue // won't increase i for invalid input
        println("You've entered the valid value $value")
        i++
    }
}


fun mathOperators() {
    var x = 15

    // integer vs (at least one) non-integer division
    println(x / 8) // 1 -> truncates answer to keep integer only
    println(x / 8.0) // 1.875

    // modulo operator % or rem() function for null safety
    println(x % 8) // 7 -> remainder
    println(15.0 % 4) // 3.0 -> remainder with decimal
    println(15.1 % 4) // 3.0999999999999996 -> not exactly 3.1
    println(x % 4.5) // 1.5
    println(x.rem(2)) // 1

    println("x is $x")
    println("x + 5 is ${x + 5}")

    // comparisons
    x = 10
    val y = 9

    println("is x ($x) even? ${x % 2 == 0}")
    println("is y ($y) even? ${y % 2 == 0}")
    println("are both x ($x) and y ($y) even? ${x % 2 == 0 && y % 2 == 0}")
    println("is at least one of x ($x) and y ($y) even? ${x % 2 == 0 || y % 2 == 0}")

    // increments by 1; works for any type of number
    println(x.inc()) // 10 becomes 11
    println(4.5.inc()) // 5.5
}


fun strings() {
    // build a reversed string
    val toReverse = "Palindrome"

    val finalString = buildString {
        for (c in toReverse.lastIndex downTo 0) {
            append(toReverse[c])
        }
    }

    println("Reversed: $finalString")
}


fun userInput() {
    println("Enter a number: ")
    var input = readln() // String
    println("You have entered $input")

    val inputAsInt = input.toInt() // throws exception if not an int
    println("Is $inputAsInt even? ${inputAsInt % 2 == 0}")

    println("Enter a number or something else: ")
    input = readln()
    println("You have entered $input")

    var nullableInputAsInt = input.toIntOrNull()
    println("inputAsInt is $nullableInputAsInt")

    // default value for a nullable variable
    nullableInputAsInt = nullableInputAsInt ?: 0 // assigns 0 if nullableInputAsInt is null
    println(nullableInputAsInt)

    // only run a function if the value is not null
    println("Enter a number to increment, or enter something else: ")
    input = readln()
    println("You have entered $input")

    nullableInputAsInt = input.toIntOrNull()
    println("Your input incremented is: ${nullableInputAsInt?.inc()}")
}
