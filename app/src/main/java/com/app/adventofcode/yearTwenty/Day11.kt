package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import java.lang.reflect.Array

class Day11(context: Context): Day(context,11,2020){
private val TAG="SeatingSystem"
    var gridItem=Array(listItem.size) { CharArray(listItem[0].length)}

    init {
        for (index in 0 until listItem.size){
            gridItem[index]=listItem[index].toCharArray()
        }
    }

    override fun partOne(){
        printArray()
        var flag=true
       while(flag){
         //  printArray()
           flag=shuffleSeat()
       }
        var count=0
        for(x in gridItem.indices) {
            for (y in gridItem[x].indices) {
                if(gridItem[x][y]=='#')
                    count++
            }
        }
        Log.d(TAG, "partOne: count $count")
    }

    private fun shuffleSeat(): Boolean{
        var flag=false
        val newGridItem=Array(listItem.size) { CharArray(listItem[0].length)}
        for(x in gridItem.indices){
            for(y in gridItem[x].indices){
                newGridItem[x][y]=gridItem[x][y]
                if(gridItem[x][y]!='.'){
                    if (gridItem[x][y]=='L' && getCountSeat(x,y)==0) {
                        newGridItem[x][y] = '#'
                        flag=true
                    }
                    if(gridItem[x][y]=='#' && getCountSeat(x,y)>=4) {
                        newGridItem[x][y] = 'L'
                        flag=true
                    }
                }
            }
        }
        gridItem=newGridItem
        return flag
    }

    private fun shuffleSeatPartTwo(): Boolean{
        var flag=false
        val newGridItem=Array(listItem.size) { CharArray(listItem[0].length)}
        for(x in gridItem.indices){
            for(y in gridItem[x].indices){
                newGridItem[x][y]=gridItem[x][y]
                if(gridItem[x][y]!='.'){
                    if (gridItem[x][y]=='L' && getCountPartTwo(x,y)==0) {
                        newGridItem[x][y] = '#'
                        flag=true
                    }
                    if(gridItem[x][y]=='#' && getCountPartTwo(x,y)>=5) {
                        newGridItem[x][y] = 'L'
                        flag=true
                    }
                }
            }
        }
        gridItem=newGridItem
        return flag
    }


    private fun printArray(){
        Log.d(TAG, "printArray: ")
        for(x in gridItem.indices){
            for(y in gridItem[x].indices){
                print("${gridItem[x][y]} ")
            }
            println()
        }
    }


    private fun getCountSeat(x : Int,y : Int): Int{
        var seatCount=0
            if(x==0 && y==0){
                if(gridItem[x+1][y]=='#') // bottom
                    seatCount++
                if(gridItem[x+1][y+1]=='#') // bottom right
                    seatCount++
                if(gridItem[x][y+1]=='#')   // right
                    seatCount++

            }else if(x==0 && y==gridItem[x].size-1) {
                if(gridItem[x+1][y]=='#') // bottom
                    seatCount++
                if(gridItem[x+1][y-1]=='#') // bottom left
                    seatCount++
                if(gridItem[x][y-1]=='#') // left
                    seatCount++
            }else if(y==0 && x==gridItem.size-1) {
                if(gridItem[x-1][y]=='#')  // top
                    seatCount++
                if(gridItem[x-1][y+1]=='#')  // top right
                    seatCount++
                if(gridItem[x][y+1]=='#')  // right
                    seatCount++
            }else if(x==gridItem.size-1 && y==gridItem[x].size-1) {
                if(gridItem[x-1][y]=='#')//top
                    seatCount++
                if(gridItem[x-1][y-1]=='#') // top left
                    seatCount++
                if(gridItem[x][y-1]=='#') // left
                    seatCount++
            }else if(x==0) {
                if(gridItem[x][y-1]=='#') // left
                    seatCount++
                if(gridItem[x+1][y-1]=='#') // bottom left
                    seatCount++
                if(gridItem[x+1][y]=='#') // bottom
                    seatCount++
                if(gridItem[x+1][y+1]=='#') // bottom right
                    seatCount++
                if(gridItem[x][y+1]=='#')   // right
                    seatCount++
            }else if(y==0){
                if(gridItem[x-1][y]=='#')  // top
                    seatCount++
                if(gridItem[x-1][y+1]=='#')  // top right
                    seatCount++
                if(gridItem[x][y+1]=='#')  // right
                    seatCount++
                if(gridItem[x+1][y]=='#') // bottom
                    seatCount++
                if(gridItem[x+1][y+1]=='#') // bottom right
                    seatCount++
            }else if(x==gridItem.size-1) {
                if(gridItem[x-1][y-1]=='#') // top left
                    seatCount++
                if(gridItem[x][y-1]=='#') // left
                    seatCount++
                if(gridItem[x-1][y]=='#')  // top
                    seatCount++
                if(gridItem[x-1][y+1]=='#')  // top right
                    seatCount++
                if(gridItem[x][y+1]=='#')  // right
                    seatCount++
            }else if(y==gridItem[x].size-1) {
                if(gridItem[x-1][y]=='#')  // top
                    seatCount++
                if(gridItem[x-1][y-1]=='#') // top left
                    seatCount++
                if(gridItem[x][y-1]=='#') // left
                    seatCount++
                if(gridItem[x+1][y-1]=='#') // bottom left
                    seatCount++
                if(gridItem[x+1][y]=='#') // bottom
                    seatCount++
            }else {
                if(gridItem[x-1][y]=='#')  // top
                    seatCount++
                if(gridItem[x-1][y-1]=='#') // top left
                    seatCount++
                if(gridItem[x][y-1]=='#') // left
                    seatCount++
                if(gridItem[x+1][y-1]=='#') // bottom left
                    seatCount++
                if(gridItem[x+1][y]=='#') // bottom
                    seatCount++
                if(gridItem[x+1][y+1]=='#') // bottom right
                    seatCount++
                if(gridItem[x-1][y+1]=='#')  // top right
                    seatCount++
                if(gridItem[x][y+1]=='#')  // right
                    seatCount++
            }
        return seatCount
        }

    private fun getCountPartTwo(x : Int,y : Int): Int{
        var seatCount=0
        if(x==0 && y==0){
            if(seatOccupiedBottom(x+1,y)) // bottom
                seatCount++
            if(seatOccupiedBottomRight(x+1,y+1)) // bottom right
                seatCount++
            if(seatOccupiedRight(x,y+1))   // right
                seatCount++

        }else if(x==0 && y==gridItem[x].size-1) {
            if(seatOccupiedBottom(x+1,y)) // bottom
                seatCount++
            if(seatOccupiedBottomLeft(x+1,y-1)) // bottom left
                seatCount++
            if(seatOccupiedLeft(x,y-1)) // left
                seatCount++
        }else if(y==0 && x==gridItem.size-1) {
            if(seatOccupiedTop(x-1,y))  // top
                seatCount++
            if(seatOccupiedTopRight(x-1,y+1))  // top right
                seatCount++
            if(seatOccupiedRight(x,y+1))  // right
                seatCount++
        }else if(x==gridItem.size-1 && y==gridItem[x].size-1) {
            if(seatOccupiedTop(x-1,y))//top
                seatCount++
            if(seatOccupiedTopLeft(x-1,y-1)) // top left
                seatCount++
            if(seatOccupiedLeft(x,y-1)) // left
                seatCount++
        }else if(x==0) {
            if(seatOccupiedLeft(x,y-1)) // left
                seatCount++
            if(seatOccupiedBottomLeft(x+1,y-1)) // bottom left
                seatCount++
            if(seatOccupiedBottom(x+1,y)) // bottom
                seatCount++
            if(seatOccupiedBottomRight(x+1,y+1)) // bottom right
                seatCount++
            if(seatOccupiedRight(x,y+1))   // right
                seatCount++
        }else if(y==0){
            if(seatOccupiedTop(x-1,y))  // top
                seatCount++
            if(seatOccupiedTopRight(x-1,y+1))  // top right
                seatCount++
            if(seatOccupiedRight(x,y+1))  // right
                seatCount++
            if(seatOccupiedBottom(x+1,y)) // bottom
                seatCount++
            if(seatOccupiedBottomRight(x+1,y+1)) // bottom right
                seatCount++
        }else if(x==gridItem.size-1) {
            if(seatOccupiedTopLeft(x-1,y-1)) // top left
                seatCount++
            if(seatOccupiedLeft(x,y-1)) // left
                seatCount++
            if(seatOccupiedTop(x-1,y))  // top
                seatCount++
            if(seatOccupiedTopRight(x-1,y+1))  // top right
                seatCount++
            if(seatOccupiedRight(x,y+1))  // right
                seatCount++
        }else if(y==gridItem[x].size-1) {
            if(seatOccupiedTop(x-1,y))  // top
                seatCount++
            if(seatOccupiedTopLeft(x-1,y-1)) // top left
                seatCount++
            if(seatOccupiedLeft(x,y-1)) // left
                seatCount++
            if(seatOccupiedBottomLeft(x+1,y-1)) // bottom left
                seatCount++
            if(seatOccupiedBottom(x+1,y)) // bottom
                seatCount++
        }else {
            if(seatOccupiedTop(x-1,y))  // top
                seatCount++
            if(seatOccupiedTopLeft(x-1,y-1)) // top left
                seatCount++
            if(seatOccupiedLeft(x,y-1)) // left
                seatCount++
            if(seatOccupiedBottomLeft(x+1,y-1)) // bottom left
                seatCount++
            if(seatOccupiedBottom(x+1,y)) // bottom
                seatCount++
            if(seatOccupiedBottomRight(x+1,y+1)) // bottom right
                seatCount++
            if(seatOccupiedTopRight(x-1,y+1))  // top right
                seatCount++
            if(seatOccupiedRight(x,y+1))  // right
                seatCount++
        }
        return seatCount
    }

    override fun partTwo(){
      //  printArray()
        var flag=true
        while(flag){
            //  printArray()
            flag=shuffleSeatPartTwo()
        }
        var count=0
        for(x in gridItem.indices) {
            for (y in gridItem[x].indices) {
                if(gridItem[x][y]=='#')
                    count++
            }
        }
        Log.d(TAG, "partTwo: count $count")
    }

    private fun seatOccupiedTopLeft(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedTopLeft(x-1,y-1)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedTop(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedTop(x-1,y)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedTopRight(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedTopRight(x-1,y+1)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedRight(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedRight(x,y+1)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedBottomRight(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedBottomRight(x+1,y+1)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedBottom(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedBottom(x+1,y)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedBottomLeft(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedBottomLeft(x+1,y-1)
        else gridItem[x][y]=='#'
    }

    private fun seatOccupiedLeft(x: Int,y: Int): Boolean{
        return if(x<0 || y<0 || x>=gridItem.size || y>=gridItem[x].size)
            false
        else if(gridItem[x][y]=='.')
            seatOccupiedLeft(x,y-1)
        else gridItem[x][y]=='#'
    }
}