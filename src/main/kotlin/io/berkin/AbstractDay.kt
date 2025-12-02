package io.berkin

abstract class AbstractDay {
    var input: List<String> = run {
        val day = this.javaClass.name.split(".").last().replace("Day", "").toInt()
        FileReader().readFileAsLinesUsingBufferedReader("src/main/resources/d${day}/input.txt")
    }

    abstract fun question1(): Any
    abstract fun question2(): Any
}