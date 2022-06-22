package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.mathgame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var newResult : Int? = null
    var level = 1
    var counter = 2
    var trueAnswer = 10
    var trueAnswer2 = 10
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setElement()

        binding.button.setOnClickListener{
          binding.counter.text = "$counter - misol"
            if (counter == 11){
                counter == 0

                level++
                binding.level.text = "Level $level"
                trueAnswer += 10
                trueAnswer2 += 10
            }


            val id = binding.radio.checkedRadioButtonId
            val m = findViewById<RadioButton>(id)
            val result =   m.text
            if (newResult.toString() == result){
                Toast.makeText(this, "true", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
            }
            counter++
            binding.radio.clearCheck()
            setElement()

        }


    }

    private fun setElement() {
        val a = (1..trueAnswer).random()
        val b = (1..trueAnswer2).random()
        val d = (1..4).random()

        when(d){
            1->{
                binding.textTv.text = "$a + $b = "
                newResult = a + b
            }
            2->{

                binding.textTv.text = "$a - $b = "
                if (a>b){
                    newResult = a - b
                }else{
                    binding.textTv.text = "$b - $a ="
                    newResult = b-a
                }

            }

            3->{
                binding.textTv.text = "$a : $b = "
                if (a>b){
                    newResult = a/b
                }else{
                    binding.textTv.text = "$b : $a = "
                    newResult = b/ a
                }

            }
            4->{
                binding.textTv.text = "$a * $b = "
                newResult = a*b
            }
        }
        val mSetOf = arrayListOf<String>()

        mSetOf.add(newResult.toString())
        while (mSetOf.size < 3) {
            val z = (1..10).random().toString()
            if (!mSetOf.contains(z))
                mSetOf.add(z)
        }
        mSetOf.shuffle()
        binding.button1.text = mSetOf[0]
        binding.button2.text = mSetOf[1]
        binding.button3.text = mSetOf[2]
    }

}
