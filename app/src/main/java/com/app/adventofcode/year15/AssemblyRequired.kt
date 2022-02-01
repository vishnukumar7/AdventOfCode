package com.app.adventofcode.year15

import android.util.Log
import java.lang.NumberFormatException

class AssemblyRequired(private val listItem: ArrayList<String>) {
    private val TAG = "AssemblyRequired"
    private var map = HashMap<String, String>()

    fun partOne(): Int {
        var flag = true
        while (flag) {
            flag = false
            val list = ArrayList<String>()
            for (item in listItem) {
                val sp = item.split("->")
                when {
                    item.contains("AND") -> {
                        val data = sp[0].trim().split(" AND ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        val right=if(isNumeric(data[1])) data[1].toInt() else if(map[data[1].trim()] == null) -1 else  map[data[1].trim()]!!.toInt()
                        if(left!=-1 && right!=-1) {
                            val res = left and right
                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                       
                    }
                    item.contains("OR") -> {
                        val data = sp[0].trim().split(" OR ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        val right=if(isNumeric(data[1])) data[1].toInt() else if(map[data[1].trim()] == null) -1 else  map[data[1].trim()]!!.toInt()
                        if (left!=-1 && right!=-1) {
                            val res = left or right
                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                    }
                    item.contains("LSHIFT") -> {
                        val data = sp[0].trim().split(" LSHIFT ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        if (left!=-1) {
                            val res =left shl data[1].trim().toInt()
                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                    }
                    item.contains("RSHIFT") -> {
                        val data = sp[0].trim().split(" RSHIFT ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        if (left!=-1) {
                            val res = left shr data[1].trim().toInt()

                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                    }
                    item.contains("NOT") -> {
                        val data = sp[0].trim().replace("NOT", "").trim()
                        val right=if(isNumeric(data)) data.toInt() else if(map[data.trim()] == null) -1 else  map[data.trim()]!!.toInt()
                        if (right!=-1) {
                            val res =right.inv()
                            map[sp[1].trim()] = (65536 + res).toString()
                            list.add(item)
                        }
                    }
                    else -> {
                        map[sp[1].trim()] = sp[0].trim()
                        list.add(item)
                    }
                }


            }
            listItem.removeIf { list.contains(it) }
            if (list.size > 0)
                flag = true
            list.clear()

        }
        return getResult("a")
    }

    fun partTwo(): Int {
        val temp=ArrayList<String>(listItem)
        map["b"]= partOne().toString()
        var flag = true
        listItem.addAll(temp)
        while (flag) {
            flag = false
            val list = ArrayList<String>()
            for (item in listItem) {
                val sp = item.split("->")
                when {
                    item.contains("AND") -> {
                        val data = sp[0].trim().split(" AND ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        val right=if(isNumeric(data[1])) data[1].toInt() else if(map[data[1].trim()] == null) -1 else  map[data[1].trim()]!!.toInt()
                        if(left!=-1 && right!=-1) {
                            val res = left and right
                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }

                    }
                    item.contains("OR") -> {
                        val data = sp[0].trim().split(" OR ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        val right=if(isNumeric(data[1])) data[1].toInt() else if(map[data[1].trim()] == null) -1 else  map[data[1].trim()]!!.toInt()
                        if (left!=-1 && right!=-1) {
                            val res = left or right
                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                    }
                    item.contains("LSHIFT") -> {
                        val data = sp[0].trim().split(" LSHIFT ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        if (left!=-1) {
                            val res =left shl data[1].trim().toInt()
                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                    }
                    item.contains("RSHIFT") -> {
                        val data = sp[0].trim().split(" RSHIFT ")
                        val left=if(isNumeric(data[0])) data[0].toInt() else if(map[data[0].trim()] == null) -1 else  map[data[0].trim()]!!.toInt()
                        if (left!=-1) {
                            val res = left shr data[1].trim().toInt()

                            map[sp[1].trim()] = res.toString()
                            list.add(item)
                        }
                    }
                    item.contains("NOT") -> {
                        val data = sp[0].trim().replace("NOT", "").trim()
                        val right=if(isNumeric(data)) data.toInt() else if(map[data.trim()] == null) -1 else  map[data.trim()]!!.toInt()
                        if (right!=-1) {
                            val res =right.inv()
                            map[sp[1].trim()] = (65536 + res).toString()
                            list.add(item)
                        }
                    }
                    else -> {
                        if(sp[1].trim()!="b")
                            map[sp[1].trim()] = sp[0].trim()
                        list.add(item)
                    }
                }


            }
            listItem.removeIf { list.contains(it) }
            if (list.size > 0)
                flag = true
            list.clear()

        }
        return getResult("a")
    }

    private fun getResult(value: String): Int {
        if(isNumeric(map[value]!!)){
            return map[value]!!.toInt()
        }
        else return getResult(map[value]!!)
    }

    private fun isNumeric(value: String): Boolean{
        return try {
            value.toLong()
            true
        }catch (e: NumberFormatException){
            false
        }
    }

}