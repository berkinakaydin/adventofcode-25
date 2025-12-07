package io.berkin.adventofcode_2025

import io.berkin.AbstractDay
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day7Test {

    private lateinit var day: AbstractDay
    private var start: Long = 0L

    @BeforeAll
    fun init() {
        day = Day7()
    }

    @Test
    fun question1() {
        Assertions.assertThat(day.question1()).isEqualTo(1703)
    }

    @Test
    fun question2() {
        Assertions.assertThat(day.question2()).isEqualTo(171692855075500)
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