package com.app.adventofcode.yearTwenty

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class AdapterArray(private var listItem: ArrayList<String>) {
private val TAG="AdapterArray"

    private val listAdapter: ArrayList<Long> = ArrayList()
    init {
        for(item in listItem){
            listAdapter.add(item.toLong())
        }
    }

    fun partOne(){
        var diff1=1
        var diff3=1
        listAdapter.sort()
        for (item in 1 until listAdapter.size){
            Log.d(TAG, "partOne: "+(listAdapter[item-1]-listAdapter[item]))
            if(listAdapter[item]-listAdapter[item-1]==(1).toLong())
                diff1++
            if(listAdapter[item]-listAdapter[item-1]==(3).toLong())
                diff3++
        }
        Log.d(TAG, "partOne: diff : "+(diff1*diff3))

    }
    fun getAdapters(){
        var diff1=1
        val itemList=ArrayList<ArrayList<Long>>()
        //itemList.add(setValue.toList() as ArrayList<Long>)
        var item=0
        while (item<itemList.size){
            for(data in 2 until itemList[item].size){
                val values=ArrayList<Long>(itemList[item])
                when {
                    (itemList[item][data]-itemList[item][data-2])==(1).toLong() -> {
                        values.remove(itemList[item][data-1])
                        itemList.add(values)
                    }
                    (itemList[item][data]-itemList[item][data-2])==(2).toLong() -> {
                        values.remove(itemList[item][data-1])
                        itemList.add(values)
                    }
                    (itemList[item][data]-itemList[item][data-2])==(3).toLong() -> {
                        values.remove(itemList[item][data-1])
                        itemList.add(values)
                    }
                }
            }

            val currentList=itemList.distinct()
            itemList.clear()
            itemList.addAll(currentList)
            item++;
        }
        Log.d(TAG, "getAdapters: ${itemList.size}")
        val treeSet= TreeSet<String>()
        for (item in itemList){
            treeSet.add(item.toString())
        }
        Log.d(TAG, "getAdapters: ${treeSet.size}")
    }
}