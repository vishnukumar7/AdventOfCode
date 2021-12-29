package com.app.adventofcode

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.app.adventofcode.model.AdventCode
import com.app.adventofcode.yearTwenty.*
import com.app.adventofcode.yearNineTeen.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private val TAG="MainActivity1"
    lateinit var listItem : ArrayList<String>
    lateinit var listItemSentence: ArrayList<String>
    lateinit var listItemMultiList: ArrayList<ArrayList<String>>
    lateinit var listItemAdventCode : ArrayList<AdventCode>
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listItemSentence= ArrayList()
        listItemMultiList= ArrayList()
        listItemAdventCode= ArrayList()
        listItem=getAssetsFile("CrossedWires.txt")
        listView=findViewById(R.id.list_item)
/*val rainRisk=RainRisk(listItem)
        Log.d(TAG, "onCreate: "+rainRisk.partTwo())*/
        val encodingError= CrossedWires(listItem)
        Log.d(TAG, "onCreate: "+encodingError.partOne())

    }

    override fun onResume() {
        super.onResume()

      //  val arrayAdapter=ArrayAdapter(this,R.layout.list_view,encodingError.partTwoArray())
       // listView.adapter=arrayAdapter
    }

    fun getAssetsFile(fileName: String) : ArrayList<String> {
       val bufferedReader= BufferedReader(InputStreamReader(assets.open(fileName)))
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

        return arrList
    }
}