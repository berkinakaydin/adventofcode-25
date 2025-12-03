package io.berkin.adventofcode_2025

import io.berkin.AbstractDay

class Day3 : AbstractDay() {
    val parsedInput: List<IntArray> = input.map { line ->
        line.map { it.digitToInt() }.toIntArray()
    }

    override fun question1(): Any {
        var output = 0
        parsedInput.forEach { line ->
            val maxValue = line.take(line.size - 1).max()
            val indexOfMax = line.indexOfFirst { it == maxValue }

            val secondMax = line.slice(indexOfMax + 1 until line.size).max()
            output += (maxValue * 10) + secondMax
        }
        return output
    }

    override fun question2(): Any {
        val target = 12
        var output = 0L
        parsedInput.forEach { numbers ->
            val queue = ArrayDeque<Int>()
            var lineOutput = ""
            queue.add(numbers[0])

            for (i in 1 until numbers.size) {
                if (isRemovalPossible(queue.size, target, numbers.size, i)){
                    while (isRemovalPossible(queue.size, target, numbers.size, i) && queue.isNotEmpty() && queue.last() < numbers[i]){
                        queue.removeLast()
                    }
                    queue.addLast(numbers[i])
                    continue
                }

                if (isRemovalPossible(queue.size, target, numbers.size, i) && numbers[i] > queue.last()){
                    if (queue.size >= target){
                        while (queue.isNotEmpty() && queue.size >= target){
                            queue.removeLast()
                        }
                    }else{
                        queue.removeLast()
                    }
                }

                queue.addLast(numbers[i])
            }

            repeat(target){
                lineOutput += queue.removeFirst()
            }

            output += lineOutput.toLong()
        }
        return output
    }

    private fun isRemovalPossible(queueSize: Int, target: Int, inputSize:Int, currentIndex: Int) : Boolean {
        return target - queueSize < inputSize - currentIndex
    }
}
