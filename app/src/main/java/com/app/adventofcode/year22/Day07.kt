package com.app.adventofcode.year22

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day07(context: Context) :Day(context,7,2022) {

    private val fileList = ArrayList<Day07FileModel>()
    private var fileSystemValue : Long=0
    init {
        getValue()
    }


    private fun getValue(){
        var startDir=""
        listItem.forEach {
            if(it.trim() != "\$ ls"){
                if(it == "\$ cd /"){
                    startDir="/"
                }else if(it.trim()=="\$ cd .."){
                    val index=startDir.dropLast(1).lastIndexOf("/")
                    startDir=startDir.substring(0,index+1)
                }else if(it.trim().startsWith("dir")){
                    val value=it.trim().split(" ")
                    fileList.add(Day07FileModel(currentDir = startDir,isFile = false, name = startDir+""+value[1].trim()))
                }else if(it.trim().startsWith("\$ cd")){
                    val value=it.trim().split(" ")
                    startDir+=value[2].trim()+"/"
                }else {
                    val checkNums= it.trim()[0].isDigit()
                    if(checkNums){
                        val value=it.trim().split(" ")
                        fileList.add(Day07FileModel(currentDir = startDir,isFile = true, name = value[1].trim(), fileSize = value[0].toLong()))
                        fileSystemValue+=value[0].toLong()
                        if(startDir!="/"){
                            getFileSizeUpdate(startDir,value[0].toLong())
                        }
                    }
                }
            }
        }
    }



    private fun getFileSizeUpdate(currentDir: String,fileSize: Long){
        val value = fileList.first { !it.isFile && it.name+"/"==currentDir }
        value.fileSize+=fileSize
        if(value.currentDir!="/")
            getFileSizeUpdate(value.currentDir,fileSize)
    }

    override fun partOne(): Any {
        return fileList.filter { !it.isFile && it.fileSize<=100000 }.sumOf { it.fileSize }.toString()
    }

    override fun partTwo(): Any {
        val unUsedFreeSpace=70000000-fileSystemValue
        val updateRun=30000000-unUsedFreeSpace
        return fileList.filter { !it.isFile && it.fileSize >= updateRun }.minByOrNull { it.fileSize }!!.fileSize
    }
}

data class Day07FileModel(
    var currentDir: String,
    var isFile: Boolean,
    var name : String,
    var fileSize : Long=0,
    var exceeds : Boolean=false
)
