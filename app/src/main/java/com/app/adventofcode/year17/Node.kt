package com.app.adventofcode.year17

import kotlin.math.absoluteValue

data class Node(val name: String, private val weight: Int, val children: MutableList<Node> = mutableListOf(),
                var parent: Node?=null){
    private val totalWeight: Int by lazy {
        weight + children.sumBy { it.totalWeight }
    }

    private val childrenAreBalanced: Boolean by lazy {
        children.map { it.totalWeight }.distinct().size == 1
    }

    fun findImbalance(imbalance: Int? = null): Int =

        if (imbalance != null && childrenAreBalanced) {
            // We end when I have a positive imbalance and my children are balanced.
            weight - imbalance
        } else {
            // Find the child tree that is off.
            val subtreesByWeight = children.groupBy { it.totalWeight }

            // Find the imbalanced child tree (they will be the lone node in the list, when grouped by weight)
            val badTree = subtreesByWeight.minByOrNull { it.value.size }?.value?.first()
                ?: throw IllegalStateException("Should not be balanced here.")

            // Recurse, passing down our imbalance. If we don't know the imbalance, calculate it.
            // Calculate the imbalance as the absolute value of the difference of all distinct weights
            badTree.findImbalance(imbalance ?: subtreesByWeight.keys.reduce { a, b -> a - b }.absoluteValue)
        }
}
