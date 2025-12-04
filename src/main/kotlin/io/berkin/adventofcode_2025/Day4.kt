package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day4 : AbstractDay() {
    val vectorRow = listOf(0, 1, 1, 1, 0, -1, -1, -1, -1)
    val vectorColumn = listOf(1, 1, 0, -1, -1, -1, 0, 1)
    var grid: List<List<Char>> = input.map { row -> row.map { it } }

    override fun question1(): Any {
        var output = 0
        val tempGrid = grid.map { it.toMutableList() }

        tempGrid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, char ->
                if (char == '@' && isAccessible(rowIndex, columnIndex, tempGrid)) {
                    tempGrid[rowIndex][columnIndex] = 'x'
                    output++
                }
            }
        }
        return output
    }

    override fun question2(): Any {
        val tempGrid = grid.map { it.toMutableList() }
        var output = 0
        var previousSweepCount: Int

        do {
            previousSweepCount = output
            tempGrid.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { columnIndex, char ->
                    if (char == '@' && isAccessible(rowIndex, columnIndex, tempGrid)) {
                        tempGrid[rowIndex][columnIndex] = '.'
                        output++
                    }
                }
            }
        } while (previousSweepCount != output)

        return output
    }

    private fun isAccessible(row: Int, col: Int, grid: List<List<Char>>): Boolean {
        var adjacentTowelSize = 0
        repeat(vectorColumn.size) {
            if (isSafe(
                    row + vectorRow[it], col + vectorColumn[it]
                ) && (grid[row + vectorRow[it]][col + vectorColumn[it]] == '@' || grid[row + vectorRow[it]][col + vectorColumn[it]] == 'x')
            ) {
                adjacentTowelSize++
            }
        }
        return adjacentTowelSize < 4
    }

    private fun isSafe(row: Int, col: Int) = row > -1 && row < grid.size && col > -1 && col < grid[0].size
}
