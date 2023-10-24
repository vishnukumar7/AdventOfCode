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
import com.app.adventofcode.year17.Day11

class MainActivity : BaseActivity() {
private val TAG="MainActivity"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val arrayAdapterYear =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListYear)
        val arrayAdapterDay =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListDay)
        binding.day.adapter = arrayAdapterDay
        binding.year.adapter = arrayAdapterYear
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
        binding.day.setSelection(0)
        binding.year.setSelection(1)
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
            2022 -> callDay2022(day)
        }
    }

    private fun calDay2015(day: Int) {
        val dayans = year15[day]
        binding.answerPartOne.text = dayans?.value?.partOne().toString()
        binding.answerPartTwo.text = dayans?.value?.partTwo().toString()

    }

    private fun callDay2016(day: Int) {
        val dayans = year16[day]
        binding.answerPartOne.text = dayans?.value?.partOne().toString()
        binding.answerPartTwo.text = dayans?.value?.partTwo().toString()
        Log.d(TAG, "callDay2016: "+binding.answerPartTwo.text)
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
        val dayans = year21[day]
        binding.answerPartOne.text = dayans?.value?.partOne().toString()
        binding.answerPartTwo.text = dayans?.value?.partTwo().toString()
        Log.d(TAG, "callDay2021: "+binding.answerPartTwo.text)

    }

    private fun callDay2022(day: Int) {
        val dayans = year22[day]
        binding.answerPartOne.text = dayans?.value?.partOne().toString()
        binding.answerPartTwo.text = dayans?.value?.partTwo().toString()
        Log.d(TAG, "callDay2021: "+binding.answerPartTwo.text)

    }


}