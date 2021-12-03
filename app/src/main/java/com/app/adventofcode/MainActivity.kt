package com.app.adventofcode

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import com.app.adventofcode.model.AdventCode
import com.app.adventofcode.yearTwenty.BinaryBoardingDayFive
import com.app.adventofcode.yearTwenty.CustomDaySix
import com.app.adventofcode.yearTwenty.HandheldHaltingDayEight
import com.app.adventofcode.yearTwenty.PassportProcessingDayFour
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private val TAG="MainActivity1"
    lateinit var listItem : ArrayList<String>
    lateinit var listItemSentence: ArrayList<String>
    lateinit var listItemMultiList: ArrayList<ArrayList<String>>
    lateinit var listItemAdventCode : ArrayList<AdventCode>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
        }
        listItemSentence= ArrayList()
        listItemMultiList= ArrayList()
        listItemAdventCode= ArrayList()
        listItem=getValues()
        val binaryBoardingDayFive= HandheldHaltingDayEight(listItemAdventCode)
        Log.d(TAG, "onCreate: binary part one ${binaryBoardingDayFive.partOne()}")
        Log.d(TAG, "onCreate: binary part two ${binaryBoardingDayFive.partTwo()}")

    }

    fun getValues() : ArrayList<String> {
        val file = File(Environment.getExternalStorageDirectory().absolutePath,"Code.txt")
        val fileInputStream = FileInputStream(file)
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val arrList = ArrayList<String>()
        var line: String?
        var wordCount = 0
        var characterCount = 0
        var paraCount = 0
        var whiteSpaceCount = 0
        var sentenceCount = 0
        var count=0;
        var sente=""
        var multiList: ArrayList<String> = ArrayList()
        while (bufferedReader.readLine().also { line = it } != null) {
            if (line.equals("")) {
                paraCount += 1
                if(sente.isNotEmpty())
                    listItemSentence.add(sente)
                sente=""
                listItemMultiList.add(multiList)
                multiList= ArrayList()
            } else {
                characterCount = characterCount.plus(line!!.length)
                val words: List<String> = line!!.split("\\s+")
                wordCount += words.size
                whiteSpaceCount += wordCount - 1
                val sentence: List<String> = line!!.split("[!?.:]+")
                sentenceCount += sentence.size
                arrList.add(line!!)
                multiList.add(line!!)
                val code=AdventCode()
                code.dataItem=line!!
                listItemAdventCode.add(code)
                sente+=" "+line!!
                sente.trim()
            }
        }
        if(sente.isNotEmpty())
            listItemSentence.add(sente)
        Log.d(TAG, "getValues: para $count")
        return arrList
    }

    private fun getImageFromExternal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                //println(getValues())
            } else {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                val uri: Uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        getImageFromExternal()
    }
}