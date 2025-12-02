package io.berkin.adventofcode_2025

import io.berkin.AbstractDay
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day1Test {
    private lateinit var day: AbstractDay
    private var start: Long = 0L

    @BeforeAll
    fun init() {
        day = Day1()
    }

    @Test
    fun question1() {
        Assertions.assertThat(day.question1()).isEqualTo(1026)
    }

    @Test
    fun question2() {
        Assertions.assertThat(day.question2()).isEqualTo(5923)
    }

    @BeforeEach
    fun beforeEach() {
        start = System.nanoTime()
    }

    @AfterEach
    fun afterEach(testInfo: TestInfo) {
        val end = System.nanoTime()
        println("${testInfo.testClass.get().name} ${testInfo.testMethod.get().name} - Time taken: ${(end - start).toDouble() / 1_000_000}ms")
    }
}