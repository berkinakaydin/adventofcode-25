package io.berkin.adventofcode_2025

import io.berkin.AbstractDay
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day4Test {

    private lateinit var day: AbstractDay
    private var start: Long = 0L

    @BeforeAll
    fun init() {
        day = Day4()
    }

    @Test
    fun question1() {
        Assertions.assertThat(day.question1()).isEqualTo(1626)
    }

    @Test
    fun question2() {
        Assertions.assertThat(day.question2()).isEqualTo(9173)
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