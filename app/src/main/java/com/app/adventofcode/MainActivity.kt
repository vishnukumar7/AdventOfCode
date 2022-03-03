package com.app.adventofcode

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.adventofcode.databinding.ActivityMainBinding
import com.app.adventofcode.year15.*
import com.app.adventofcode.year17.Day07
import kotlin.jvm.Throws

class MainActivity : AppCompatActivity() {
private val TAG="MainActivity"
    lateinit var binding: ActivityMainBinding

    val year15 = hashMapOf(
        1 to lazy { Day01(this) },
        2 to lazy { Day02(this) },
        3 to lazy { Day03(this) },
        4 to lazy { Day04(this) },
        5 to lazy { Day05(this) },
        6 to lazy { Day06(this) },
        8 to lazy { Day08(this) },
        9 to lazy { Day09(this) },
        10 to lazy { Day10(this) }
    )

    private val year17 = hashMapOf(
        1 to lazy { com.app.adventofcode.year17.Day01(this) },
        2 to lazy { com.app.adventofcode.year17.Day02(this) },
        3 to lazy { com.app.adventofcode.year17.Day03(this) },
        4 to lazy { com.app.adventofcode.year17.Day04(this) },
        5 to lazy { com.app.adventofcode.year17.Day05(this) },
        6 to lazy { com.app.adventofcode.year17.Day06(this) },
        7 to lazy { com.app.adventofcode.year17.Day07(this) },
        8 to lazy { com.app.adventofcode.year17.Day08(this) }
    )

    val year19 = hashMapOf(
        1 to lazy { com.app.adventofcode.yearNineTeen.Day01(this) },
        2 to lazy { com.app.adventofcode.yearNineTeen.Day02(this) },
        3 to lazy { com.app.adventofcode.yearNineTeen.Day03(this) },
        4 to lazy { com.app.adventofcode.yearNineTeen.Day04(this) },
        6 to lazy { com.app.adventofcode.yearNineTeen.Day06(this) }
    )

    val year20 = hashMapOf(
        1 to lazy { com.app.adventofcode.yearTwenty.Day01(this) },
        2 to lazy { com.app.adventofcode.yearTwenty.Day02(this) },
        3 to lazy { com.app.adventofcode.yearTwenty.Day03(this) },
        4 to lazy { com.app.adventofcode.yearTwenty.Day04(this) },
        5 to lazy { com.app.adventofcode.yearTwenty.Day05(this) },
        6 to lazy { com.app.adventofcode.yearTwenty.Day06(this) },
        8 to lazy { com.app.adventofcode.yearTwenty.Day08(this) },
        9 to lazy { com.app.adventofcode.yearTwenty.Day09(this) },
        10 to lazy { com.app.adventofcode.yearTwenty.Day10(this) },
        11 to lazy { com.app.adventofcode.yearTwenty.Day11(this) },
        12 to lazy { com.app.adventofcode.yearTwenty.Day12(this) },
        13 to lazy { com.app.adventofcode.yearTwenty.Day13(this) },
        14 to lazy { com.app.adventofcode.yearTwenty.Day14(this) },
        15 to lazy { com.app.adventofcode.yearTwenty.Day15(this) },
        17 to lazy { com.app.adventofcode.yearTwenty.Day17(this) },
        18 to lazy { com.app.adventofcode.yearTwenty.Day18(this) }
    )

    var arrayListYear = arrayListOf(2015, 2016, 2017, 2018, 2019, 2020, 2021)
    var arrayListDay = arrayListOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20,
        21,
        22,
        23,
        24,
        25,
        26,
        27,
        28,
        29,
        30
    )
    var selectYear = 0
    var selectDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*binding.submit.setOnClickListener {
            when {
                binding.day.text.toString().toInt() != 0 -> {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.enter_vaild_day),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                binding.year.text.toString().length != 4 -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Enter Valid Year - (like 2021)",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    call(binding.day.text.toString().toInt(), binding.year.text.toString().toInt())
                }
            }
        }*/
        val arrayAdapterYear =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListYear)
        val arrayAdapterDay =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListDay)
        binding.day.adapter = arrayAdapterDay
        binding.year.adapter = arrayAdapterYear
        /*binding.day.setOnItemClickListener { _, _, position, _ -> selectDay=arrayListDay[position] }
        binding.year.setOnItemClickListener { _, _, position, _ -> selectYear=arrayListYear[position] }*/
        binding.day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectDay = arrayListDay[position]
                Log.d("TAG", "onItemSelected: " + arrayListDay[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectYear = arrayListYear[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.submit.setOnClickListener {
            when {
                selectDay == 0 -> {
                    Toast.makeText(this@MainActivity, "Select the Day", Toast.LENGTH_SHORT).show()
                }
                selectYear == 0 -> {
                    Toast.makeText(this@MainActivity, "Select the year", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    call(selectDay, selectYear)
                }
            }
        }
    }


    private fun call(day: Int, year: Int) {
        when (year) {
            2015 -> calDay2015(day)
            2016 -> callDay2016(day)
            2017 -> callDay2017(day)
            2018 -> callDay2018(day)
            2019 -> callDay2019(day)
            2020 -> callDay2020(day)
            2021 -> callDay2021(day)
        }
    }

    private fun calDay2015(day: Int) {
        val dayans = year15[day]
        binding.answerPartOne.text = dayans?.value?.partOne().toString()
        binding.answerPartTwo.text = dayans?.value?.partTwo().toString()

    }

    private fun callDay2016(day: Int) {

    }

    private fun callDay2017(day: Int) {
        val dayans = year17[day]
        binding.answerPartOne.text = dayans?.value?.partOne().toString()
        binding.answerPartTwo.text = dayans?.value?.partTwo().toString()
        Log.d(TAG, "callDay2017: "+binding.answerPartTwo.text)
    }

    private fun callDay2018(day: Int) {

    }

    private fun callDay2019(day: Int) {

    }

    private fun callDay2020(day: Int) {

    }

    private fun callDay2021(day: Int) {

    }


}