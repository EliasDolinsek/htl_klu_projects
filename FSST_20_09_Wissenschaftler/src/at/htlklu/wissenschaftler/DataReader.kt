package at.htlklu.wissenschaftler

import kotlin.Throws
import java.io.IOException
import java.io.BufferedReader
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object DataReader {
    @JvmStatic
    @Throws(IOException::class)
    fun readScientists(file: String): List<Scientist> {
        val scientists = mutableListOf<Scientist>()
        val bufferedReader: BufferedReader = File(file).bufferedReader()
        var line: String?

        bufferedReader.readLine() // Skip first line
        while (bufferedReader.readLine().also { line = it } != null) {
            val data = line!!.split(";".toRegex()).toTypedArray()
            try {
                validateScientistDataFields(data)
                scientists.add(scientistFromDataArray(data))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return scientists
    }

    private fun scientistFromDataArray(data: Array<String>): Scientist {
        return Scientist(
                surname = data[0],
                firstName = data[1],
                dateOfBirth = Calendar.getInstance().apply { SimpleDateFormat("dd.MM.yyyy").parse(data[2]) },
                weight = data[3].toDouble(),
                height = data[4].toInt(),
                sex = data[5].let { if (it == "w") Scientist.Sex.FEMALE else Scientist.Sex.MALE },
                topic = data[6],
                country = data[7]
        )
    }

    @Throws(Exception::class)
    private fun validateScientistDataFields(data: Array<String>) {
        if (data[0].isEmpty()) throw Exception("Surname is missing")
        if (data[1].isEmpty()) throw Exception("First name is missing")
        if (data[2].isEmpty()) throw Exception("Date of birth is missing")

        val dateOfBirth = Calendar.getInstance().apply { SimpleDateFormat("dd.MM.yyyy").parse(data[2]) }
        if (dateOfBirth.before(Date(1900)) || dateOfBirth.after(Date())) throw Exception("Invalid date of birth: $dateOfBirth")

        val weight = data[3].toDouble()
        if (weight <= 0 || weight >= 300) throw Exception("Invalid weight: $weight")

        val sex = data[5]
        if (sex != "w" && sex != "m") throw Exception("Invalid sex: $sex")

        if (data[7].isEmpty()) throw Exception("Country is missing")
    }

}
