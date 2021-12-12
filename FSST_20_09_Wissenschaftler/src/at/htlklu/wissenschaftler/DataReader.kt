package at.htlklu.wissenschaftler

import kotlin.Throws
import java.io.IOException
import at.htlklu.wissenschaftler.ScientistDAO
import java.io.BufferedReader
import java.io.FileReader
import at.htlklu.wissenschaftler.DataReader
import java.util.ArrayList

object DataReader {
    @Throws(IOException::class)
    fun readScientists(file: String?): ArrayList<ScientistDAO> {
        val reader = BufferedReader(FileReader(file))
        reader.readLine() // Content list
        val scientistDAOs = ArrayList<ScientistDAO>()
        var line: String
        while (reader.readLine().also { line = it } != null) {
            val data = line.split(";".toRegex()).toTypedArray()
            scientistDAOs.add(scientistFromDataArray(data))
        }
        return scientistDAOs
    }

    private fun scientistFromDataArray(data: Array<String>): ScientistDAO {
        val weight = data[3].toDouble()
        val height = data[4].toInt()
        return ScientistDAO(data[0], data[1], data[2], data[5], data[6], data[7], weight, height)
    }
}