package com.app.adventofcode.year22

import android.content.Context
import com.app.adventofcode.Day
import com.app.adventofcode.MainActivity

class Day03(context: Context) :Day(context,3,2022) {
    private val priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    override fun partOne(): Any = listItem1.sumOf { priority.indexOf(compartment(it)) + 1 }

    override fun partTwo(): Any =listItem2.chunked(3).sumOf { priority.indexOf(groupComponent(it))+1 }


    fun compartment(value : String): Char{
        val first = value.substring(0, value.length / 2)
        val second = value.substring(value.length / 2)
        first.forEach { f ->
            if (second.any { it == f }) {
                return f
            }
        }
        return '0'
    }

    fun groupComponent(value: List<String>) : Char{
        value[0].forEach { f->
            if(value[1].any { it==f } && value[2].any { it==f })
                return f
        }
        return '0'
    }

}
