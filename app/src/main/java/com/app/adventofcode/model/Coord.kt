package com.app.adventofcode.model

import java.lang.Math.sqrt
import kotlin.math.*

data class Coord(
    var x: Int,
    var y: Int
) {
    operator fun plus(c: Coord) = Coord(x = x + c.x, y = y + c.y)
    operator fun minus(c: Coord) = Coord(x = x - c.x, y = y - c.y)

    /**
     * Get adjacent neighbor [Coord] list
     */
   /* fun neighbors(xLimit: Int = -1, yLimit: Int = -1): List<Coord> {
        var n = listOf(
            Coord(x, y + 1),
            Coord(x, y - 1),
            Coord(x + 1, y),
            Coord(x - 1, y)
        )

        if (xLimit > -1)
            n = n.filter { it.x in 0..xLimit }

        if (yLimit > -1)
            n = n.filter { it.y in 0..yLimit }

        return n
    }
*/
    /**
     * Get adjacent and diagonal neighbor [Coord] list
     *//*
    fun allNeighbors(xLimit: Int = -1, yLimit: Int = -1): List<Coord> {
        var n = listOf(
            Coord(x - 1, y - 1),
            Coord(x - 1, y + 1),
            Coord(x + 1, y - 1),
            Coord(x + 1, y + 1)
        )

        if (xLimit > -1)
            n = n.filter { it.x in 0..xLimit }

        if (yLimit > -1)
            n = n.filter { it.y in 0..yLimit }

        return neighbors(xLimit, yLimit) + n
    }

    fun distanceTo(c: Coord): Float = sqrt(
        ((x - c.x).toFloat()).pow(2) + ((y - c.y).toFloat()).pow(2)
    )

    fun diffWith(c: Coord): Coord = Coord(c.x - x, c.y - y)
    fun opposite(): Coord = Coord(x * -1, y * -1)*/

    override fun toString(): String = "($x, $y)"
}

/*
data class Coord3d(
    var x: Int,
    var y: Int,
    var z: Int
) {
    fun distanceTo(c: Coord3d): Float = sqrt(
        ((x - c.x).toFloat()).pow(2) + ((y - c.y).toFloat()).pow(2) + ((z - c.z).toFloat()).pow(2)
    )

    fun opposite(): Coord3d = Coord3d(x * -1, y * -1, z * -1)
    fun diffWith(c: Coord3d): Coord3d = Coord3d(c.x - x, c.y - y, c.z - z)

    operator fun plus(c: Coord3d) = Coord3d(x = x + c.x, y = y + c.y, z = z + c.z)
    operator fun minus(c: Coord3d) = Coord3d(x = x - c.x, y = y - c.y, z = z - c.z)

    fun manhattanDistanceTo(c: Coord3d): Int =
        with(diffWith(c)) {
            abs(this.x) + abs(this.y) + abs(this.z)
        }

    override fun toString(): String = "($x, $y, $z)"
}*/


data class Point2d(val x: Int, val y: Int){
    infix fun sharesAxisWith(that: Point2d): Boolean =
        x == that.x || y == that.y

    infix fun lineTo(that: Point2d): List<Point2d> {
        val xDelta = (that.x - x).sign
        val yDelta = (that.y - y).sign
        val steps = maxOf((x - that.x).absoluteValue, (y - that.y).absoluteValue)
        return (1..steps).scan(this) { last, _ -> Point2d(last.x + xDelta, last.y + yDelta) }
    }

    fun neighbors(): List<Point2d> =
        listOf(
            Point2d(x, y + 1),
            Point2d(x, y - 1),
            Point2d(x + 1, y),
            Point2d(x - 1, y)
        )

    fun allNeighbors(): List<Point2d> =
        neighbors() + listOf(
            Point2d(x - 1, y - 1),
            Point2d(x - 1, y + 1),
            Point2d(x + 1, y - 1),
            Point2d(x + 1, y + 1)
        )
}

data class Point3d(val x: Int, val y: Int, val z: Int) {

    infix fun distanceTo(other: Point3d): Int =
        (this.x - other.x).absoluteValue + (this.y - other.y).absoluteValue + (this.z - other.z).absoluteValue

    operator fun plus(other: Point3d): Point3d =
        Point3d(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Point3d): Point3d =
        Point3d(x - other.x, y - other.y, z - other.z)

    fun face(facing: Int): Point3d =
        when (facing) {
            0 -> this
            1 -> Point3d(x, -y, -z)
            2 -> Point3d(x, -z, y)
            3 -> Point3d(-y, -z, x)
            4 -> Point3d(y, -z, -x)
            5 -> Point3d(-x, -z, -y)
            else -> error("Invalid facing")
        }

    fun rotate(rotating: Int): Point3d =
        when (rotating) {
            0 -> this
            1 -> Point3d(-y, x, z)
            2 -> Point3d(-x, -y, z)
            3 -> Point3d(y, -x, z)
            else -> error("Invalid rotation")
        }

    companion object {
        fun of(rawInput: String): Point3d =
            rawInput.split(",").let { part ->
                Point3d(part[0].toInt(), part[1].toInt(), part[2].toInt())
            }
    }

}