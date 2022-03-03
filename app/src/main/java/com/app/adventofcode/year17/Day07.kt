package com.app.adventofcode.year17

import android.content.Context
import com.app.adventofcode.Day

class Day07(context: Context): Day(context,7,2017) {

    override fun partOne(): Any {
        return headOfTree.name
    }

    override fun partTwo(): Any {
        return headOfTree.findImbalance()
    }


    private val headOfTree: Node by lazy { parseInput() }

    private fun parseInput(): Node{
        val nodesByName= mutableMapOf<String,Node>()
        val parentChildPairs= mutableSetOf<Pair<Node,String>>()
        val rowRegex = """\w+""".toRegex()
        listItem.forEach {
            val groups = rowRegex.findAll(it).toList().map { it.value }
            val node = Node(groups[0], groups[1].toInt())
            nodesByName[node.name] = node

            groups.drop(2).forEach {
                parentChildPairs.add(Pair(node, it))
            }
        }
        parentChildPairs.forEach { (parent, childName) ->
            with(nodesByName.getValue(childName)) {
                parent.children.add(this)
                this.parent = parent
            }
        }

        return nodesByName.values.firstOrNull { it.parent == null }
            ?: throw IllegalStateException("No head node?!")
    }

}