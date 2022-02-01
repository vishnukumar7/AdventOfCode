package com.app.adventofcode.year15

class FireHazard(private val listItem: ArrayList<String>) {

   private var light = Array(1000) { BooleanArray(1000) }
    private var lightPart2 = Array(1000) { IntArray(1000) }

    fun partOne(): Int {
        var sum=0
        for (item in listItem) {
            var itemTemp=""
            var values=-1
            when {
                item.contains("turn on") -> {
                    itemTemp = item.replace("turn on", "").trim()
                    values=0
                }
                item.contains("toggle") -> {
                    itemTemp = item.replace("toggle", "").trim()
                    values=1
                }
                item.contains("turn off") -> {
                    itemTemp = item.replace("turn off", "").trim()
                    values=2
                }
            }
            val data=itemTemp.split(" ")
            var start=data[0].split(",")
            val startX=start[0].toInt()
            val startY=start[1].toInt()
            start=data[2].split(",")
            val endX=start[0].toInt()
            val endY=start[1].toInt()

            when(values){
                0 -> {
                    turnOn(startX,startY,endX,endY)
                }

                1 -> {
                    toggle(startX,startY,endX,endY)
                }
                2 -> {
                    turnOff(startX,startY,endX,endY)
                }
            }
        }
        for (x in 0..999){
            for (y in 0..999){
                if(light[x][y])
                    sum++
            }
        }
        return sum

    }

    fun partTwo(): Long {
        var sum=0L
        for (item in listItem) {
            var itemTemp=""
            var values=-1
            when {
                item.contains("turn on") -> {
                    itemTemp = item.replace("turn on", "").trim()
                    values=0
                }
                item.contains("toggle") -> {
                    itemTemp = item.replace("toggle", "").trim()
                    values=1
                }
                item.contains("turn off") -> {
                    itemTemp = item.replace("turn off", "").trim()
                    values=2
                }
            }
            val data=itemTemp.split(" ")
            var start=data[0].split(",")
            val startX=start[0].toInt()
            val startY=start[1].toInt()
            start=data[2].split(",")
            val endX=start[0].toInt()
            val endY=start[1].toInt()

            when(values){
                0 -> {
                    turnOnPart2(startX,startY,endX,endY)
                }

                1 -> {
                    togglePart2(startX,startY,endX,endY)
                }
                2 -> {
                    turnOffPart2(startX,startY,endX,endY)
                }
            }
        }
        for (x in 0..999){
            for (y in 0..999){
                    sum+=lightPart2[x][y].toLong()
            }
        }
        return sum

    }

    private fun turnOff(sx: Int,sy: Int, ex: Int,ey: Int){
        for (x in sx..ex){
            for (y in sy..ey){
                light[x][y]=false
            }
        }
    }

    private fun turnOn(sx: Int,sy: Int,ex: Int,ey: Int){
        for (x in sx..ex){
            for (y in sy..ey){
                light[x][y]=true
            }
        }
    }

    private fun toggle(sx: Int,sy: Int,ex: Int,ey: Int){
        for (x in sx..ex){
            for (y in sy..ey){
                light[x][y]=!light[x][y]
            }
        }
    }

    private fun turnOffPart2(sx: Int,sy: Int, ex: Int,ey: Int){
        for (x in sx..ex){
            for (y in sy..ey){
                if(lightPart2[x][y]>=1)
                    lightPart2[x][y]-=1

            }
        }
    }

    private fun turnOnPart2(sx: Int,sy: Int,ex: Int,ey: Int){
        for (x in sx..ex){
            for (y in sy..ey){
                lightPart2[x][y]+=1
            }
        }
    }

    private fun togglePart2(sx: Int,sy: Int,ex: Int,ey: Int){
        for (x in sx..ex){
            for (y in sy..ey){
                lightPart2[x][y]+=2
            }
        }
    }
}