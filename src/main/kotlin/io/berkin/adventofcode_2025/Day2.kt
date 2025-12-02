package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day2 : AbstractDay() {
    init {
        input = input.flatMap { it.split(",") }.filter { it.isNotEmpty() }
    }

    override fun question1(): Any {
        var output: Long = 0
        for (range in input) {
            val (start, end) = range.split("-").map { it.toLong() }

            for (i in start..end) {
                val str = i.toString()
                val midPoint = str.length / 2
                if (str.take(midPoint) == str.substring(midPoint)) {
                    output += i
                }
            }
        }
        return output
    }

    override fun question2(): Any {
        var output: Long = 0

        for (range in input) {
            val (start, end) = range.split("-").map { it.toLong() }

            for (i in start..end) {
                if (!isValid(i.toString())) {
                    output += i
                }
            }
        }
        return output
    }

    private fun isValid(input: String): Boolean {
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