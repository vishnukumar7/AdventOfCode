package com.app.adventofcode.year22

import android.content.Context
import com.app.adventofcode.Day

class Day05(context: Context) : Day(context,5,2022){
    val matrixList1=ArrayList<ArrayList<String>>()
    val matrixList2=ArrayList<ArrayList<String>>()
    init {
        init()
    }
    fun init(){
        matrixList1.add(arrayListOf("B","P","N","Q","H","D","R","T"))
        matrixList1.add(arrayListOf("W","G","B","J","T","V"))
        matrixList1.add(arrayListOf("N","R","H","D","S","V","M","Q"))
        matrixList1.add(arrayListOf("P","Z","N","M","C"))
        matrixList1.add(arrayListOf("D","Z","B"))
        matrixList1.add(arrayListOf("V","C","W","Z"))
        matrixList1.add(arrayListOf("G","Z","N","C","V","Q","L","S"))
        matrixList1.add(arrayListOf("L","G","J","M","D","N","V"))
        matrixList1.add(arrayListOf("T","P","M","F","Z","C","G"))

        matrixList2.add(arrayListOf("B","P","N","Q","H","D","R","T"))
        matrixList2.add(arrayListOf("W","G","B","J","T","V"))
        matrixList2.add(arrayListOf("N","R","H","D","S","V","M","Q"))
        matrixList2.add(arrayListOf("P","Z","N","M","C"))
        matrixList2.add(arrayListOf("D","Z","B"))
        matrixList2.add(arrayListOf("V","C","W","Z"))
        matrixList2.add(arrayListOf("G","Z","N","C","V","Q","L","S"))
        matrixList2.add(arrayListOf("L","G","J","M","D","N","V"))
        matrixList2.add(arrayListOf("T","P","M","F","Z","C","G"))
    }

    override fun partOne(): Any? {
        listItem1.forEach {
            val cargo=it.split(" ")
            val move=cargo[1].toInt()
            val from=cargo[3].toInt()-1
            val to=cargo[5].toInt()-1
            repeat(move){
                matrixList1[to].add(matrixList1[from].removeLast())
            }
        }
        var crates=""
        repeat(9){
            crates+=matrixList1[it].last()
        }
        return crates
    }

    override fun partTwo(): Any? {
        listItem1.forEach {
            val cargo=it.split(" ")
            val move=cargo[1].toInt()
            val from=cargo[3].toInt()-1
            val to=cargo[5].toInt()-1
            val cargos=ArrayList<String>()
            repeat(move){
                cargos.add(0,matrixList2[from].removeLast())
            }
            matrixList2[to].addAll(cargos)
        }
        var crates=""
        repeat(9){
            crates+=matrixList2[it].last()
        }
        return crates
    }

}
