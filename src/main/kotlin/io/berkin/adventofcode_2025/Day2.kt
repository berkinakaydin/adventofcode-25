package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day2 : AbstractDay() {
    private val ranges: List<LongRange>

    init {
        ranges = input.flatMap { it.split(",") }.filter { it.isNotEmpty() }.map(::parseRange)
    }

    override fun question1(): Any {
        return ranges.sumOf { range ->
            range.filter(::hasRepeatingHalves).sum()
        }
    }

    override fun question2(): Any {
        return ranges.sumOf { range ->
            range.filterNot(::hasRepeatingPattern).sum()
        }
    }

    private fun hasRepeatingHalves(number: Long): Boolean {
        val str = number.toString()
        val midpoint = str.length / 2
        return str.take(midpoint) == str.substring(midpoint)
    }

    private fun hasRepeatingPattern(number: Long): Boolean {
        val str = number.toString()
        var chunkSize = str.length / 2

        while (chunkSize > 0) {
            val chunks = str.chunked(chunkSize)
            val count = chunks.distinct().size

            if (count == 1) {
                return false
            }
            chunkSize--
        }

        return true
    }

    private fun parseRange(rangeStr: String): LongRange {
        val (start, end) = rangeStr.split("-").map { it.toLong() }
        return start..end
    }
}