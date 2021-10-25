fun main() {
    val multiplyFunction = generateMultiply()
    println(multiplyFunction(3, 4))

    mathInvoker(5, 6, multiplyFunction)

    mathInvoker(7, 8) { x, y ->
        x * y
    }

    val squareAnonymous = fun(x: Int) = x * x
    val squareLambda = { x: Int -> x * x }
}

fun mathInvoker(x: Int, y: Int, mathFunction: (Int, Int) -> Int) {
    println(mathFunction(x, y))
}


fun generateMultiply(): (Int, Int) -> Int {
    return { x: Int, y: Int -> x * y }
}