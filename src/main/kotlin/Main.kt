fun main() {
    // функции
    println(max1(5, 10))
    println(max2(6, 3))
    println(firstFiveSymOfStr("hellohello"))

    println(sum(1, 2, 3, 4, 5)) // функция с неизвестным числом параметров

    val list = mutableListOf(5, 4, 7, 3, 7, 2, 5, 3, 2, 6, 7, 1, 2, 2, 2, 5, 6, 4, 3)
    println(quickSort(list))
    println(bubbleSort(list))
}

fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// можно сократить запись
fun max2(a: Int, b: Int) = if (a > b) a else b

fun firstFiveSymOfStr(str: String) = str.substring(0, Math.min(str.length, 5)) // если строка меньше 5 символов

fun sum(vararg numbers: Int): Int {
    var sum = 0
    for (i in numbers) sum += i
    return sum
}

fun quickSort(array: MutableList<Int>) : List<Int> { // быстрая сортировка
    if (array.size < 2) return array

    val pivot = array[array.size / 2]

    val less = array.filter { it < pivot }
    val equal = array.filter { it == pivot }
    val greater = array.filter { it > pivot }

    return quickSort(less.toMutableList()) + equal + quickSort(greater.toMutableList())
}

fun bubbleSort(numbers: MutableList<Int>) : List<Int> {
    for (i in 1..<numbers.size) {
        for (j in numbers.size - 1 downTo i) {
            if (numbers[j] < numbers[j - 1]) {
                val tmp = numbers[j]
                numbers[j] = numbers[j - 1]
                numbers[j - 1] = tmp
            }
        }
    }
    return numbers
}