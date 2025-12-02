package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day1 : AbstractDay() {
    override fun question1(): Any {
        var position = 50
        var output = 0
        input.forEach {
            val direction = it[0]
            val dial = it.substring(1).toInt()
            when (direction) {
                'L' -> {
                    position = ((position - dial) + 100) % 100
                }

                'R' -> {
                    position = ((position + dial) + 100) % 100
                }
            }

            if (position == 0) {
                output += 1
            }
        }
        return output
    }

    override fun question2(): Any {
        var position = 50
        var output = 0
        input.forEach {
            val direction = it[0]
            var dial = it.substring(1).toInt()

            if (dial > 100){
                output += dial / 100
                dial %= 100
            }

            when (direction) {
                'L' -> {
                    if (position != 0 && position - dial < 0){
                        output += 1
                    }
                    position = ((position - dial) + 100) % 100
                }

                'R' -> {
                    if (position != 0 && position + dial > 100){
                        output += 1
                    }
                    position = ((position + dial) + 100) % 100

                }
            }

            if (position == 0) {
                output += 1
            }
        }
        return output
    }
}