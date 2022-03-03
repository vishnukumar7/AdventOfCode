package com.app.adventofcode.year15

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Day09(context: Context): Day(context,9,2015) {
    private val TAG="SingleNight"
    override fun partOne(): Long {
        var distance=HashMap<String,Long>()
        val arrays=ArrayList<String>()
        for (item in listItem){
            var temp=item.split("=")
            var location=temp[0].trim().split("to")
            arrays.add(location[0].trim())
            arrays.add(location[1].trim())
            var keys=location[0].trim()+"to"+location[1].trim()
            distance[keys]=temp[1].trim().toLong()
            keys=location[1].trim()+"to"+location[0].trim()
            distance[keys]=temp[1].trim().toLong()
        }
        val dataItem= allPermutations(arrays.toSet())
        var small=Long.MAX_VALUE
        for (item in dataItem){
            var d=0L
            for (index in 0 until item.size-1){
                val keys=item[index].trim()+"to"+item[index+1].trim()
                d+=distance.getOrDefault(keys,0)
            }
            if(small>d)
                small=d
        }
        return small
    }

    override fun partTwo(): Long {
        var distance=HashMap<String,Long>()
        val arrays=ArrayList<String>()
        for (item in listItem){
            var temp=item.split("=")
            var location=temp[0].trim().split("to")
            arrays.add(location[0].trim())
            arrays.add(location[1].trim())
            var keys=location[0].trim()+"to"+location[1].trim()
            distance[keys]=temp[1].trim().toLong()
            keys=location[1].trim()+"to"+location[0].trim()
            distance[keys]=temp[1].trim().toLong()
        }
        val dataItem= allPermutations(arrays.toSet())
        var longest=Long.MIN_VALUE
        for (item in dataItem){
            var d=0L
            for (index in 0 until item.size-1){
                val keys=item[index].trim()+"to"+item[index+1].trim()
                d+=distance.getOrDefault(keys,0)
            }
            if(longest<d)
                longest=d
        }
        return longest
    }

    private fun <T> allPermutations(set: Set<T>): Set<List<T>> {
        if (set.isEmpty()) return emptySet()

        fun <T> _allPermutations(list: List<T>): Set<List<T>> {
            if (list.isEmpty()) return setOf(emptyList())

            val result: MutableSet<List<T>> = mutableSetOf()
            for (i in list.indices) {
                _allPermutations(list - list[i]).forEach{
                        item -> result.add(item + list[i])
                }
            }
            return result
        }

        return _allPermutations(set.toList())
    }

    /*private fun permuation(n: Int, elements: ArrayList<String>) {
        var elements=elements
        if (n == 1) {
            dataItem.add(elements)
        } else {
            for (index in 0 until n - 1) {
                permuation(n - 1, elements)
                if (n % 2 == 0) {

                   elements= swap(elements, index, n - 1)
                } else {
                   elements= swap(elements, 0, n - 1)
                }
            }
            permuation(n - 1, elements)
        }
    }

    private fun swap(input: ArrayList<String>, a: Int, b: Int): String {
        val tmp = input[a]
        input[a] = input[b]
        input[b] = tmp
        return tmp
    }*/
}