package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day2 : AbstractDay() {
    init {
        input = input.flatMap { it.split(",") }.filter { it.isNotEmpty() }
    }

    override fun question1(): Any {
        var output: Long = 0
        for (range in input) {
            val start = range.split("-")[0].toLong()
            val end = range.split("-")[1].toLong()

            for (i in start..end) {
                if (i.toString().startsWith("0")) {
                    output += i
                    continue
                }

                val length = i.toString().length
                if (i.toString().take(length / 2) == i.toString().substring(length / 2)) {
                    output += i
                }
            }
        }
        return output
    }

    override fun question2(): Any {
        var output: Long = 0

        for (range in input) {
            val start = range.split("-")[0].toLong()
            val end = range.split("-")[1].toLong()

            for (i in start..end) {
                if (!isValid(i.toString())) {
                    output += i
                }
            }
        }
        return output
    }

    private fun isValid(input: String): Boolean {
        if (input[0] == '0') {
            return false
        }

        var chunkSize = input.length / 2

        while (chunkSize > 0) {
            val chunks = input.chunked(chunkSize)
            val count = chunks.distinct().size

            if (count == 1) {
                return false
            }
            chunkSize--
        }

        return true
    }
}