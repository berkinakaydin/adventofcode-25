package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day7 : AbstractDay() {
    val grid = input.map { it.toCharArray() }
    var startCol: Int = 0

    init {
        startCol = grid[0].indexOf('S')
    }

    override fun question1(): Any {
        var output = 0
        val tempGrid = grid.map { it.copyOf() }
        tempGrid[1][startCol] = '|'

        for (i in 1 until tempGrid.size) {
            for (j in tempGrid[i].indices) {
                val above = tempGrid[i - 1][j]
                val current = tempGrid[i][j]

                if (above == '|') {
                    when (current) {
                        '^' -> output += splitBeam(i, j, tempGrid)
                        else -> {
                            if (isSafe(i, j)) {
                                tempGrid[i][j] = '|'
                            }
                        }
                    }
                }
            }
        }

        return output
    }

    override fun question2(): Any {
        val tempGrid = grid.map { it.copyOf() }
        val timelineGrid = Array(tempGrid.size) { LongArray(tempGrid[0].size) }
        timelineGrid[0][startCol] = 1

        for (i in 0 until tempGrid.size - 1) {
            for (j in tempGrid[i].indices) {
                val timelinesHere = timelineGrid[i][j]

                if (timelinesHere == 0L) continue
                val below = tempGrid[i + 1][j]

                when (below) {
                    '^' -> {
                        if (isSafe(i + 1, j - 1)) {
                            timelineGrid[i + 1][j - 1] += timelinesHere
                        }
                        if (isSafe(i + 1, j + 1)) {
                            timelineGrid[i + 1][j + 1] += timelinesHere
                        }
                    }

                    '.' -> {
                        timelineGrid[i + 1][j] += timelinesHere
                    }
                }
            }
        }

        return timelineGrid[tempGrid.size - 1].sum()
    }

    private fun isSafe(row: Int, column: Int) = row > -1 && row < grid.size && column > -1 && column < grid[0].size

    private fun splitBeam(row: Int, column: Int, grid: List<CharArray>): Int {
        var isSplitted = false
        if (isSafe(row, column - 1)) {
            grid[row][column - 1] = '|'
            isSplitted = true
        }

        if (isSafe(row, column + 1)) {
            grid[row][column + 1] = '|'
            isSplitted = true
        }

        if (isSplitted) {
            return 1
        }

        return 0
    }
}
