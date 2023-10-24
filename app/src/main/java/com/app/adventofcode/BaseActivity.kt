package com.app.adventofcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.adventofcode.year15.Day01
import com.app.adventofcode.year15.Day02
import com.app.adventofcode.year15.Day03
import com.app.adventofcode.year15.Day04
import com.app.adventofcode.year15.Day05
import com.app.adventofcode.year15.Day06
import com.app.adventofcode.year15.Day08
import com.app.adventofcode.year15.Day09
import com.app.adventofcode.year15.Day10
import com.app.adventofcode.year17.Day11

open class BaseActivity : AppCompatActivity() {

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

    val year16 = hashMapOf(
        1 to lazy { com.app.adventofcode.year16.Day01(this) }
    )

    val year17 = hashMapOf(
        1 to lazy { com.app.adventofcode.year17.Day01(this) },
        2 to lazy { com.app.adventofcode.year17.Day02(this) },
        3 to lazy { com.app.adventofcode.year17.Day03(this) },
        4 to lazy { com.app.adventofcode.year17.Day04(this) },
        5 to lazy { com.app.adventofcode.year17.Day05(this) },
        6 to lazy { com.app.adventofcode.year17.Day06(this) },
        7 to lazy { com.app.adventofcode.year17.Day07(this) },
        8 to lazy { com.app.adventofcode.year17.Day08(this) },
        9 to lazy { com.app.adventofcode.year17.Day09(this) },
        10 to lazy { com.app.adventofcode.year17.Day10(this) },
        11 to lazy { Day11(this) }
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

    val year21= hashMapOf(
        1 to lazy { com.app.adventofcode.year21.Day01(this) },
        2 to lazy { com.app.adventofcode.year21.Day02(this) },
        3 to lazy { com.app.adventofcode.year21.Day03(this) },
        4 to lazy { com.app.adventofcode.year21.Day04(this) },
        5 to lazy { com.app.adventofcode.year21.Day05(this) },
        6 to lazy { com.app.adventofcode.year21.Day06(this) }
    )


    val year22= hashMapOf(
        1 to lazy { com.app.adventofcode.year22.Day01(this) },
        2 to lazy { com.app.adventofcode.year22.Day02(this) },
        3 to lazy { com.app.adventofcode.year22.Day03(this) },
        4 to lazy { com.app.adventofcode.year22.Day04(this) },
        5 to lazy { com.app.adventofcode.year22.Day05(this) },
        6 to lazy { com.app.adventofcode.year22.Day06(this) },
        7 to lazy { com.app.adventofcode.year22.Day07(this) },
        8 to lazy { com.app.adventofcode.year22.Day08(this) }
    )

    var arrayListYear = arrayListOf(2015, 2016, 2017, 2018, 2019, 2020, 2021,2022)
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
    }


}