package at.htlklu.wissenschaftler

import java.util.*

object ScientistTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val dateOfBirth = Calendar.getInstance()
        val scientists = listOf(
                Scientist(surname = "Test", firstName = "Test", dateOfBirth = dateOfBirth, sex = Scientist.Sex.MALE, country = "AT"),
                Scientist(surname = "Test", firstName = "Test", dateOfBirth = dateOfBirth, sex = Scientist.Sex.MALE, country = "AT")
        )

        println(areEqualScientistsInList(scientists))
    }

    private fun areEqualScientistsInList(scientists: List<Scientist>): Boolean {
        for (i in scientists.indices) {
            for (y in scientists.indices) {
                if (i != y && areScientistsEqual(scientists[i], scientists[y])) return true
            }
        }

        return false
    }

    private fun areScientistsEqual(a: Scientist, b: Scientist) = a == b
}