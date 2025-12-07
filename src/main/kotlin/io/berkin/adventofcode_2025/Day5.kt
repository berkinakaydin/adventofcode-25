package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day5 : AbstractDay() {
    val ranges: MutableList<LongRange> = mutableListOf()
    val fruitIds: MutableList<Long> = mutableListOf()

    init {
        for (line in input) {
            if (line.contains("-")) {
                val (start, end) = line.split("-").map { it.toLong() }
                ranges.add(start..end)
            } else if (line.isNotBlank()) {
                fruitIds.add(line.toLong())
            }
        }
    }

    override fun question1(): Any {
        return fruitIds.count { fruitId ->
            ranges.any { range ->
                range.contains(fruitId)
            }
        }
    }

    override fun question2(): Any {
        val mergedRanges = mergeRanges()
        return mergedRanges.sumOf { it.last - it.first + 1 }
    }

    private fun mergeRanges(): List<LongRange> {
        val sorted = ranges.sortedBy { it.first }
        val merged = mutableListOf<LongRange>()
        var current = sorted[0]

        for (i in 1 until sorted.size) {
            val next = sorted[i]
            if (next.first <= current.last + 1) {
                current = LongRange(current.first, maxOf(current.last, next.last))
            } else {
                merged.add(current)
                current = next
            }
        }
        merged.add(current)
        return merged
    }
}
