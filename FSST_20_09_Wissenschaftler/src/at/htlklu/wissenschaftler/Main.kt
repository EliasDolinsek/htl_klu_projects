package at.htlklu.wissenschaftler

import at.htlklu.wissenschaftler.DataReader.readScientists
import kotlin.jvm.JvmStatic
import java.io.IOException
import java.text.ParseException
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val result: List<Scientist> = readScientists("Scientist.txt")
            for (scientist in result) {
                println(scientist.toString())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val scientists = mutableListOf<Scientist>()
        scientists.add(Scientist(surname = "Test", firstName = "Test2", dateOfBirth = Calendar.getInstance(), country = "AT", height = 0, weight = 5.0, sex = Scientist.Sex.MALE, topic = "Test"))
        scientists.add(Scientist(surname = "Test", firstName = "Test2", dateOfBirth = Calendar.getInstance(), country = "AT",  sex = Scientist.Sex.MALE))
        scientists.add(Scientist(surname = "Test", firstName = "Test2", dateOfBirth = Calendar.getInstance(), country = "AT",  sex = Scientist.Sex.MALE, topic = "Test"))
        scientists.add(Scientist(surname = "Test", firstName = "Test2", dateOfBirth = Calendar.getInstance(), country = "AT",  sex = Scientist.Sex.MALE, topic = "Test", weight = 0.1, height = 1))
    }
}