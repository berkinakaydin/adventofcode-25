package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day6 : AbstractDay() {
    val operations = input[input.size - 1].split(" ").filter { it.isNotBlank() }

    override fun question1(): Any {
        val numbers = parseInputQ1()

        var output = 0L
        operations.forEachIndexed { index, operation ->
            output += when (operation) {
                "*" -> {
                    numbers[index].reduce(Long::times)
                }

                "+" -> {
                    numbers[index].sum()
                }

                else -> 0
            }
        }
        return output
    }

    override fun question2(): Any {
        val numbers = parseInputQ2()
        var output = 0L
        operations.forEachIndexed { index, operation ->
            output += when (operation) {
                "*" -> {
                    numbers[index].reduce(Long::times)
                }

                "+" -> {
                    numbers[index].sum()
                }

                else -> 0
            }
        }
        return output
    }

    private fun parseInputQ1(): List<List<Long>> {
        var numbers = mutableListOf<List<Long>>()
        for (i in 0 until input.size - 1) {
            val line = input[i]
            numbers.add(line.split(" ").filter { it.isNotBlank() }.map { it.toLong() })
        }

        numbers = numbers[0].indices.map { col -> numbers.map { row -> row[col] } }.toMutableList()
        return numbers
    }

    private fun parseInputQ2(): List<List<Long>> {
        var col = 0
        var operationCount = 0
        val numbers = MutableList<MutableList<Long>>(operations.size) { mutableListOf() }

        while (col < input[0].length) {
            var row = 0
            var numberAsString = ""

            while (row < input.size - 1) {
                if (!input[row][col].isWhitespace()) {
                    numberAsString += input[row][col]
                }
                row++
            }

            if (numberAsString.isNotBlank()) {
                numbers[operationCount].add(numberAsString.toLong())
            } else {
                operationCount++
            }

            col++
        }

        return numbers
    }
}
