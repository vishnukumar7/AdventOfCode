package com.app.adventofcode.year22

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import kotlin.math.log
import kotlin.math.max

class Day08(context: Context) : Day(context,8,2022) {

    val TAG= Day08::class.java.name
    val rows = listItem.size
    val cols= listItem[0].length
    var visible=0
    val values = listItem.map { it.map { it.digitToInt() }.toMutableList() }.toMutableList()

    override fun partOne(): Any? {
        visible=(rows*2)+(cols*2)-4
        Log.e(TAG, "partOne: visible : $visible", )
        for (rowItem in 1 until values.size-1){
            for (colItem in 1 until values[rowItem].size-1){
                if(isLeft(rowItem,colItem,values[rowItem][colItem]) || isTop(rowItem,colItem,values[rowItem][colItem]) || isBottom(rowItem,colItem,values[rowItem][colItem]) || isRight(rowItem,colItem,values[rowItem][colItem])){
                    Log.e(TAG, "partOne: rows pos : $rowItem ==== $colItem===== ${values[rowItem][colItem]}")
                    visible++
                }
            }
        }
        return visible.toString()
    }

    private fun isLeft(rowPos : Int,colPos: Int,height : Int): Boolean {
        var colPos=colPos
        while (--colPos!=-1){
            if(values[rowPos][colPos]>=height)
                return false
        }
        return true
    }

    private fun isTop(rowPos: Int,colPos: Int,height: Int): Boolean {
        var rowPos=rowPos
        while (--rowPos!=-1){
            if(values[rowPos][colPos]>=height)
                return false
        }
        return true
    }

    private fun isRight(rowPos : Int,colPos: Int,height : Int): Boolean {
        var colPos=colPos
        while (++colPos!=cols){
            if(values[rowPos][colPos]>=height)
                return false
        }
        return true
    }

    private fun isBottom(rowPos: Int,colPos: Int,height: Int): Boolean {
        var rowPos=rowPos
        while (++rowPos!=rows){
            if(values[rowPos][colPos]>=height)
                return false
        }
        return true
    }

    override fun partTwo(): Any {
        var maxBlockedCount=0
        for (rowItem in 0 until values.size){
            for (colItem in 0 until values[rowItem].size){
                val leftBlock = if(colItem==0 || colItem==1) 1 else isLeftBocked(rowItem,colItem)
                val rightBlock = if(colItem+1==cols || colItem+2==cols) 1 else isRightBlocked(rowItem,colItem)
                val topBlock = if(rowItem==0 || rowItem==1) 1 else isTopBlocked(rowItem,colItem)
                val bottomBlock = if(rowItem+1==rows || rowItem+2==rows) 1 else isBottomBlocked(rowItem,colItem)
                val scenic= leftBlock*rightBlock*topBlock*bottomBlock
                if (maxBlockedCount<scenic)
                    maxBlockedCount=scenic
            }
        }
        return maxBlockedCount.toString()
    }




    private fun isLeftBocked(rowPos : Int,colPos: Int): Int {
        Log.e(TAG, "isLeftBocked: rowspos : $rowPos ========== cols $colPos", )
        var colPos=colPos
        var count=1
        var max=values[rowPos][colPos]
        while (--colPos!=-1){
            if(values[rowPos][colPos]>=max){
                max=values[rowPos][colPos]
                count++
            }
        }
        return count
    }

    private fun isTopBlocked(rowPos: Int,colPos: Int): Int {
        Log.e(TAG, "isTopBlocked: rowspos : $rowPos ========== cols $colPos", )
        var rowPos=rowPos
        var count=1
        var max=values[rowPos][colPos]
        while (--rowPos!=-1){
            if(values[rowPos][colPos]>=max){
                max=values[rowPos][colPos]
                count++
            }
        }
        return count
    }

    private fun isRightBlocked(rowPos : Int,colPos: Int): Int {
        Log.e(TAG, "isRightBlocked: rowspos : $rowPos ========== cols $colPos", )
        var colPos=colPos
        var count=1
        var max=values[rowPos][colPos]
        while (++colPos!=cols){
            if(values[rowPos][colPos]>=max){
                max=values[rowPos][colPos]
                count++
            }
        }
        return count
    }

    private fun isBottomBlocked(rowPos: Int,colPos: Int): Int {
        Log.e(TAG, "isBottomBlocked: rowspos : $rowPos ========== cols $colPos", )
        var rowPos=rowPos
        var count=1
        var max=values[rowPos][colPos]
        while (++rowPos!=rows){
            if(values[rowPos][colPos]>=max){
                max=values[rowPos][colPos]
                count++
            }
        }
        return count
    }
}