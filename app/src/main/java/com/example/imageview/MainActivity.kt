package com.example.imageview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.imageview.databinding.MainBinding

class MainActivity : ComponentActivity(), View.OnClickListener {

    private var seletedOperation = ""
    private var oldNumber = ""
    private var iseNewOperation = true
    private var answer: Double? = null

    private lateinit var binding: MainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.clear.setOnClickListener(this)
        binding.negative.setOnClickListener(this)
        binding.division.setOnClickListener(this)
        binding.multiplication.setOnClickListener(this)
        binding.percent.setOnClickListener(this)

        binding.subtraction.setOnClickListener(this)
        binding.sum.setOnClickListener(this)
        binding.dot.setOnClickListener(this)
        Log.d("dot", "sterted")
        binding.one.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five.setOnClickListener(this)
        binding.six.setOnClickListener(this)
        binding.seven.setOnClickListener(this)
        binding.eight.setOnClickListener(this)
        binding.nine.setOnClickListener(this)
        binding.zero.setOnClickListener(this)


    }

    override fun onClick(v: View?) {


        if (iseNewOperation) {
            clearNumber()
            Log.d("if onClick", "Operation is check")
        }
        iseNewOperation = false
        Log.d("onClick", "Operation is false")


        binding.equal.setOnClickListener {
            equalEvent(v)
        }

        percentage(v)
        operationEvent(v)
        cleanInput(v)


        val selectedButton = v as Button
        val currrentNumber: String = binding.editText.text.toString()
        val newNumber = setNextCharacter(currrentNumber, selectedButton)
        binding.editText.setText(newNumber)


    }

    private fun setNextCharacter(oldNumber: String, selectedButton: Button): String {

        var number = oldNumber
        when (selectedButton.id) {


            R.id.zero -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    number += "0"
                }
            }

            R.id.one -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }

            R.id.two -> {
                if (number == "0" || number == "") {
                    number = "2"
                } else {
                    number += "2"
                }
            }

            R.id.three -> {
                if (number == "0" || number == "") {
                    number = "3"
                } else {
                    number += "3"
                }
            }

            R.id.four -> {
                if (number == "0" || number == "") {
                    number = "4"
                } else {
                    number += "4"
                }
            }

            R.id.five -> {
                if (number == "0" || number == "") {
                    number = "5"
                } else {
                    number += "5"
                }
            }

            R.id.six -> {
                if (number == "0" || number == "") {
                    number = "6"
                } else {
                    number += "6"
                }
            }

            R.id.seven -> {
                if (number == "0" || number == "") {
                    number = "7"
                } else {
                    number += "7"
                }
            }

            R.id.eight -> {
                if (number == "0" || number == "") {
                    number = "8"
                } else {
                    number += "8"
                }
            }

            R.id.nine -> {
                if (number == "0" || number == "") {
                    number = "9"
                } else {
                    number += "9"
                }
            }

            R.id.dot -> {
                if (number == "") {
                    number = "0."
                } else {
                    if (number.indexOf('.') == -1) {
                        number += "."
                    }
                }
            }

            R.id.negative -> {
                number = if (number == "0" || number == "") {
                    "0"
                } else {
                    if (number.first() == '-') {
                        number.substring(1, number.lastIndex + 1)
                    } else {
                        "-$number"

                    }

                }
            }


        }
        return number
    }

    private fun operationEvent(view: View?) {
        val selectedButton = view as Button
        when (selectedButton.id) {
            binding.division.id -> {
                Log.v("Event", "Operation is true")
                seletedOperation = "÷"
                oldNumber = binding.editText.text.toString()
                iseNewOperation = true

            }

            binding.sum.id -> {
                seletedOperation = "+"
                oldNumber = binding.editText.text.toString()
                iseNewOperation = true


            }

            binding.subtraction.id -> {
                seletedOperation = "–"
                oldNumber = binding.editText.text.toString()
                iseNewOperation = true

            }

            binding.multiplication.id -> {
                seletedOperation = "×"
                oldNumber = binding.editText.text.toString()
                iseNewOperation = true


            }


        }


    }

    private fun clearNumber() {
        binding.editText.setText("0")
    }

    private fun percentage(view: View?) {
        view as Button

        when (view.id) {
            R.id.percent -> {

                val percentage = answer!! / 100
                Toast.makeText(
                    this,
                    "answer = $answer , pecentage = $percentage",
                    Toast.LENGTH_SHORT
                ).show()
                binding.editText.setText(percentage.toString())
                iseNewOperation = true
                 seletedOperation = ""


            }
        }

    }

    private fun cleanInput(view: View?) {
        view as Button
        when (view.id) {
            R.id.clear -> {
                clearNumber()
                iseNewOperation = true
                seletedOperation = ""
                answer = 0.0

            }
        }


    }

    private fun equalEvent(view: View?) {
        view as Button
        val newNumber = binding.editText.text.toString().toDouble()
        Log.d("val answer", " val is worked")
        if (seletedOperation != "" && oldNumber != "") {
//            اگر خالی نباشد
            when (seletedOperation) {
                "÷" -> {
                    answer = oldNumber.toDouble() / binding.editText.text.toString().toDouble()
                    binding.editText.setText(answer.toString())
                    iseNewOperation = true
                    oldNumber = ""
                    seletedOperation = ""
                    Toast.makeText(this, "$answer = $oldNumber ÷ $newNumber", Toast.LENGTH_SHORT)
                        .show()
                }

                "×" -> {
                    answer = oldNumber.toDouble() * newNumber
                    binding.editText.setText(answer.toString())
                    iseNewOperation = true
                    oldNumber = ""
                    seletedOperation = ""
                    Toast.makeText(this, "$answer = $oldNumber x $newNumber", Toast.LENGTH_SHORT)
                        .show()
                }

                "–" -> {
                    answer = oldNumber.toDouble() - newNumber
                    binding.editText.setText(answer.toString())
                    iseNewOperation = true
                    oldNumber = ""
                    seletedOperation = ""
                    Toast.makeText(this, "$answer = $oldNumber - $newNumber", Toast.LENGTH_SHORT)
                        .show()
                }

                "+" -> {
                    answer = oldNumber.toDouble() + newNumber
                    binding.editText.setText(answer.toString())
                    iseNewOperation = true
                    oldNumber = ""
                    seletedOperation = ""
                    Toast.makeText(this, "$answer = $oldNumber + $newNumber", Toast.LENGTH_SHORT)
                        .show()

                }

            }
        }


    }

}

