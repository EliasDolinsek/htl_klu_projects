package at.htlklu.wissenschaftler

import at.htlklu.wissenschaftler.DataReader.readScientists
import kotlin.jvm.JvmStatic
import at.htlklu.wissenschaftler.ScientistDAO
import at.htlklu.wissenschaftler.DataReader
import java.io.IOException
import java.text.ParseException
import java.util.ArrayList

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val result: ArrayList<ScientistDAO> = readScientists("Scientist.txt")
            for (scientist in result) {
                println(scientist.toScientist().toString())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
}