package com.app.adventofcode

import android.content.Context
import android.util.Log
import com.app.adventofcode.model.AdventCode
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

abstract class Day(context: Context,day:Int,year:Int) {
val TAG1="Day"

    var listItemSentence: ArrayList<String> = ArrayList()
    var listItemMultiList: ArrayList<ArrayList<String>> = ArrayList()
    var listItemTab: ArrayList<ArrayList<String>> = ArrayList()
    var listItemAdventCode : ArrayList<AdventCode> = ArrayList()

    var listItem1 : ArrayList<String> =ArrayList()
    var listItem2 : ArrayList<String> =ArrayList()
    var listItem : ArrayList<String> = ArrayList()

    init {
        if(day==0) ArrayList() else getAssetsFile(context,if(day<10) "$year/0$day.txt" else "$year/$day.txt")
    }
    abstract fun partOne(): Any?

    abstract fun partTwo(): Any?

    private fun getAssetsFile(context: Context,fileName: String) : ArrayList<String> {
        val bufferedReader= BufferedReader(InputStreamReader(context.assets.open(fileName)))
        val arrList = ArrayList<String>()
        var line: String?
        var wordCount = 0
        var characterCount = 0
        var paraCount = 0
        var whiteSpaceCount = 0
        var sentenceCount = 0
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
                setListTab(line!!)

                wordCount += words.size
                whiteSpaceCount += wordCount - 1
                val sentence: List<String> = line!!.split("[ !?.:]+")
                sentenceCount += sentence.size
                arrList.add(line!!)
                multiList.add(line!!)
                val code= AdventCode()
                code.dataItem=line!!
                listItemAdventCode.add(code)
                sente+=" "+line!!
                sente.trim()
            }
        }
        if(sente.isNotEmpty())
            listItemSentence.add(sente)
        listItem1.addAll(arrList)
        listItem2.addAll(arrList)
        listItem.addAll(arrList)
        return arrList
    }

    fun setListTab(line: String){
       try {
           val wordsList: List<String> = line.split("\t")
           listItemTab.add(wordsList as java.util.ArrayList<String>)
       }
       catch (e : Exception){

       }
    }
}