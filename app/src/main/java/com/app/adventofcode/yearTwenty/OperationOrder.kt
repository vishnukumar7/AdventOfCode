package com.app.adventofcode.yearTwenty

class OperationOrder(private var listItem: ArrayList<String>) {
private val TAG="OperationOrder"
    fun partOne(): Long {
        var sum: Long=0
        for(data in listItem){
            var dataValues=data.replace(" ","")
            while (true){
                if(dataValues.contains("+") || dataValues.contains("*") ||  dataValues.contains("(") || dataValues.contains(")")){
                    if(dataValues.contains("(") || dataValues.contains(")")){
                        var startIndex=-1
                        var endIndex=-1
                        for(index in dataValues.indices){
                            if(dataValues[index]=='(') {
                                startIndex = index
                                endIndex=-1
                            }
                            else if(dataValues[index]==')') {
                                endIndex = index
                            }

                            if(startIndex!=-1 && endIndex!=-1){
                                val mid=dataValues.substring(startIndex,endIndex+1)
                                val result =parentheses(dataValues.substring(startIndex+1,endIndex)).toString()
                                dataValues=dataValues.replace(mid,result)
                                startIndex=-1
                                endIndex=-1
                            }
                            if(index+1>=dataValues.length)
                                break
                        }
                    }else{
                        dataValues=parentheses(dataValues).toString()
                    }

                }else
                    break

            }
            sum+=dataValues.toLong()
        }

        return sum
    }

    private fun parentheses(dataValues: String): Long{
        var mid=dataValues
        var sum: Long=0
        while(true){
            if(mid.contains("+") || mid.contains("-") || mid.contains("*") || mid.contains("/")){
                val digitSplit=mid.split("+","-","*","/").toList()
               val symbolSplit=mid.replace("[0-9]".toRegex(),"").toCharArray().toList()
                sum=digitSplit[0].toLong()
                for ((index,values) in symbolSplit.withIndex()){
                    when(values){
                        '*' -> sum*=digitSplit[index+1].toLong()
                        '+' -> sum+=digitSplit[index+1].toLong()
                    }
                }
                mid=sum.toString()
            }else
                break
        }
        return sum

    }


}