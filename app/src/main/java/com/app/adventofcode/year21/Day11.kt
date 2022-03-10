package com.app.adventofcode.year21

import android.content.Context
import com.app.adventofcode.Day

class Day11(context: Context): Day(context,11,2021) {

    private val gridItem: ArrayList<IntArray> = ArrayList()
    private val arrayListFlash: ArrayList<String> = ArrayList()
    private var flashes=0

    init {
        for(item in listItem){
            val intArray=toIntArray(item.toCharArray().toList() as ArrayList<Char>)
            gridItem.add(intArray)
        }
    }

    private fun toIntArray(arrayList: ArrayList<Char>): IntArray{
        val intArray=IntArray(arrayList.size)
        for (index in 0 until arrayList.size){
            intArray[index]=Character.getNumericValue(arrayList[index])
        }
        return intArray
    }

    override fun partOne(): Any? {
        for (index in 0 until 100) {
            arrayListFlash.clear()
            for (x in 0 until gridItem.size) {
                for (y in gridItem[x].indices) {
                    //   Log.d(TAG, "partOne: ${gridItem[x][y]} ")
                    if (gridItem[x][y] >= 9) {
                        checkPartOne(x,y,9)
                    } else if(!arrayListFlash.contains("$x$y")) {
                        gridItem[x][y] = gridItem[x][y] + 1
                    }
                }
            }
        }
        return flashes
    }

    override fun partTwo(): Any? {
        var flag=true
        var index=0
        while (flag) {
            index++
            arrayListFlash.clear()
            for (x in 0 until gridItem.size) {
                for (y in gridItem[x].indices) {
                    if (gridItem[x][y] >= 9) {
                        checkPartOne(x,y,9)
                    } else if(!arrayListFlash.contains("$x$y")) {
                        gridItem[x][y] = gridItem[x][y] + 1
                    }
                }
            }
            flag=isAllFlash()
        }
        return index
    }


    private fun isAllFlash(): Boolean{
        for (x in 0 until gridItem.size) {
            for (y in gridItem[x].indices) {
                if(gridItem[x][y]!=0)
                    return true
            }
        }
        return false
    }

    private fun isCheck(x: Int,y: Int): Int{
        if(!arrayListFlash.contains("$x$y")){
            return gridItem[x][y]+1
        }
        return gridItem[x][y]
    }

    private fun checkPartOne(x: Int, y: Int,beyond: Int){
        if(gridItem[x][y]>=beyond) {
            flashes++
            gridItem[x][y]=0
            arrayListFlash.add("$x$y")
            when {
                x == 0 && y == 0 -> {   // Top left corner
                    gridItem[x + 1][y] = isCheck(x+1,y)
                    checkPartOne(x + 1, y,10)
                    gridItem[x + 1][y + 1] =isCheck(x+1,y+1)
                    checkPartOne(x + 1, y + 1,10)
                    gridItem[x][y + 1] = isCheck(x,y+1)
                    checkPartOne(x, y + 1,10)
                }
                x == 0 && y == gridItem[x].size - 1 -> {  // top right corner
                    gridItem[x + 1][y] = isCheck(x+1,y)
                    checkPartOne(x + 1, y,10)
                    gridItem[x + 1][y - 1] = isCheck(x+1,y-1)
                    checkPartOne(x + 1, y - 1,10)
                    gridItem[x][y - 1] = isCheck(x,y-1)
                    checkPartOne(x, y - 1,10)
                }
                x == gridItem.size - 1 && y == 0 -> { // bottom left corner
                    gridItem[x - 1][y] = isCheck(x-1,y)
                    checkPartOne(x - 1, y,10)
                    gridItem[x - 1][y + 1] = isCheck(x-1,y+1)
                    checkPartOne(x - 1, y + 1,10)
                    gridItem[x][y + 1] = isCheck(x,y+1)
                    checkPartOne(x, y + 1,10)
                }
                x == gridItem.size - 1 && y == gridItem[x].size - 1 -> { // bottom right corner
                    gridItem[x - 1][y] = isCheck(x-1,y)
                    checkPartOne(x - 1, y,10)
                    gridItem[x - 1][y - 1] = isCheck(x-1,y-1)
                    checkPartOne(x - 1, y - 1,10)
                    gridItem[x][y - 1] = isCheck(x,y-1)
                    checkPartOne(x, y - 1,10)
                }
                x == 0 -> { // top center
                    gridItem[x][y - 1] = isCheck(x,y-1)
                    checkPartOne(x, y - 1,10)
                    gridItem[x + 1][y - 1] = isCheck(x+1,y-1)
                    checkPartOne(x + 1, y - 1,10)
                    gridItem[x + 1][y] = isCheck(x+1,y)
                    checkPartOne(x + 1, y,10)
                    gridItem[x + 1][y + 1] = isCheck(x+1,y+1)
                    checkPartOne(x + 1, y + 1,10)
                    gridItem[x][y + 1] = isCheck(x,y+1)
                    checkPartOne(x, y + 1,10)
                }
                y == 0 -> { // left center
                    gridItem[x - 1][y] = isCheck(x-1,y)
                    checkPartOne(x - 1, y,10)
                    gridItem[x - 1][y + 1] = isCheck(x-1,y+1)
                    checkPartOne(x - 1, y + 1,10)
                    gridItem[x][y + 1] =isCheck(x,y+1)
                    checkPartOne(x, y + 1,10)
                    gridItem[x + 1][y + 1] = isCheck(x+1,y+1)
                    checkPartOne(x + 1, y + 1,10)
                    gridItem[x + 1][y] = isCheck(x+1,y)
                    checkPartOne(x + 1, y,10)
                }
                x == gridItem.size - 1 -> {  // bottom center
                    gridItem[x][y - 1] = isCheck(x,y-1)
                    checkPartOne(x, y - 1,10)
                    gridItem[x - 1][y - 1] = isCheck(x-1,y-1)
                    checkPartOne(x - 1, y - 1,10)
                    gridItem[x - 1][y] = isCheck(x-1,y)
                    checkPartOne(x - 1, y,10)
                    gridItem[x - 1][y + 1] = isCheck(x-1,y+1)
                    checkPartOne(x - 1, y + 1,10)
                    gridItem[x][y + 1] = isCheck(x,y+1)
                    checkPartOne(x, y + 1,10)
                }
                y == gridItem[x].size - 1 -> { // right center
                    gridItem[x - 1][y] = isCheck(x-1,y)
                    checkPartOne(x - 1, y,10)
                    gridItem[x - 1][y - 1] = isCheck(x-1,y-1)
                    checkPartOne(x - 1, y - 1,10)
                    gridItem[x][y - 1] = isCheck(x,y-1)
                    checkPartOne(x, y - 1,10)
                    gridItem[x + 1][y - 1] = isCheck(x+1,y-1)
                    checkPartOne(x + 1, y - 1,10)
                    gridItem[x + 1][y] = isCheck(x+1,y)
                    checkPartOne(x + 1, y,10)
                }
                else -> {  // center
                    gridItem[x - 1][y] = isCheck(x-1,y)
                    checkPartOne(x - 1, y,10)
                    gridItem[x - 1][y - 1] = isCheck(x-1,y-1)
                    checkPartOne(x - 1, y - 1,10)
                    gridItem[x - 1][y + 1] = isCheck(x-1,y+1)
                    checkPartOne(x - 1, y + 1,10)
                    gridItem[x + 1][y] = isCheck(x+1,y)
                    checkPartOne(x + 1, y,10)
                    gridItem[x + 1][y - 1] = isCheck(x+1,y-1)
                    checkPartOne(x + 1, y - 1,10)
                    gridItem[x + 1][y + 1] = isCheck(x+1,y+1)
                    checkPartOne(x + 1, y + 1,10)
                    gridItem[x][y + 1] = isCheck(x,y+1)
                    checkPartOne(x, y + 1,10)
                    gridItem[x][y - 1] = isCheck(x,y-1)
                    checkPartOne(x, y - 1,10)
                }
            }
        }
    }

}