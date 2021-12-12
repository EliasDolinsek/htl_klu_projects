package at.htlklu.wissenschaftler

import java.text.SimpleDateFormat
import java.util.*

data class Scientist(val surname: String, val firstName: String, val dateOfBirth: Calendar, val sex: Sex, val topic: String? = null, val country: String, val weight: Double? = null, val height: Int? = null) {

    enum class Sex(val sex: String) { MALE("m"), FEMALE("w") }

    override fun toString(): String {
        return "$firstName $surname (${formatDateOfBirth()}, $height, $weight)"
    }

    private fun formatDateOfBirth() = SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth.time)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Scientist

        if (surname != other.surname) return false
        if (firstName != other.firstName) return false
        if (dateOfBirth != other.dateOfBirth) return false
        if (sex != other.sex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = surname.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + dateOfBirth.hashCode()
        result = 31 * result + sex.hashCode()
        return result
    }


}