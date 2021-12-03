package com.app.adventofcode.yearTwenty

import android.util.Log

class PassportProcessingDayFour(private var listItem: ArrayList<String>) {
    private val TAG="PassportProcessing"

    fun partOne(): Int {
        var count=0

        for (testValues in listItem){
            val dataArray= arrayListOf<String>("byr","iyr","eyr","hgt","hcl","ecl","pid","cid")
            Log.d(TAG, "getValues: item $testValues")
            if (testValues.contains("byr:")) {
                dataArray.remove("byr")
            }
            if (testValues.contains("iyr:")) {
                dataArray.remove("iyr")
            }
            if (testValues.contains("eyr:")) {
                dataArray.remove("eyr")
            }
            if (testValues.contains("hgt:")) {
                dataArray.remove("hgt")
            }
            if (testValues.contains("hcl:")) {
                dataArray.remove("hcl")
            }
            if (testValues.contains("ecl:")) {
                dataArray.remove("ecl")
            }
            if (testValues.contains("pid:")) {
                dataArray.remove("pid")
            }
            if (testValues.contains("cid:")) {
                dataArray.remove("cid")
            }

            if((dataArray.size==0) || (dataArray.size==1 && dataArray.contains("cid")))
            count++
        }
        return count
    }

    fun partTwo(): Int {
        var count=0
        for (item in listItem){
            var itemList=item.trim().split(" ").toList()
            if (isValid(itemList as ArrayList<String>))
                count++
        }
        return count
    }

    fun isValid(itemList: ArrayList<String>): Boolean {
        val dataArray= arrayListOf<String>("byr","iyr","eyr","hgt","hcl","ecl","pid","cid")
        for (testValues in itemList){
            val item= testValues.trim().split(":")[0].trim()
            val itemValues= testValues.trim().split(":")[1].trim()
            Log.d(TAG, "getValues: item $item $itemValues")
            if (item.contains("byr")) {
                if(itemValues.toInt() in 1920..2002){
                    dataArray.remove(item)
                }
                else
                    return false
            }
            else if (item.contains("iyr")) {
                if(itemValues.toInt() in 2010..2020){
                    dataArray.remove(item)
                }
                else
                    return false
            }
            else if (item.contains("eyr")) {
                if(itemValues.toInt() in 2020..2030){
                    dataArray.remove(item)
                }
                else
                    return false
            }
            else if (item.contains("hgt")) {
                if(itemValues.contains("cm")){
                    if(itemValues.replace("cm","").toInt() in 150..193){
                        dataArray.remove(item)
                    }else return false
                }else if(itemValues.contains("in")){
                    if(itemValues.replace("in","").toInt() in 59..76){
                        dataArray.remove(item)
                    }else return false
                }else return false
            }
            else if (item.contains("hcl")) {
                if(itemValues.startsWith("#") && itemValues.matches(".*[0-9a-f].*".toRegex())){
                    dataArray.remove(item)
                }else return false
            }
            else if (item.contains("ecl")) {
                if(itemValues=="amb" || itemValues== "blu" || itemValues=="brn" || itemValues== "gry" || itemValues=="grn" || itemValues=="hzl" || itemValues== "oth")
                    dataArray.remove(item) else return false
            }
            else if (item.contains("pid")) {
                if(itemValues.length==9){
                    dataArray.remove(item)
                }else return false
            }
            else if (item.contains("cid")) {
                dataArray.remove(item)
            }

        }
        Log.d(TAG, "getPassport: dataarray $dataArray")
        return when {
            dataArray.size==0 -> true
            dataArray.size==1 && dataArray.contains("cid") -> true
            else -> false
        }
    }


}