package com.sangvaleap.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sangvaleap.lab2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var foodList = mutableListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese" )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setImageResource(R.drawable.dd_logo)
        binding.textView.text = "Welcome to Dinner Decider"
        binding.button.setOnClickListener{
            var temp = binding.editText.text;
            if(temp != null && temp.toString() != ""){
                foodList.add(temp.toString())
            }
            println(foodList.size)
        }

        binding.btndecide.setOnClickListener {
            binding.textView.text = getRandomFood()
        }
    }

    private fun getRandomFood(): String{
        var index = Random.nextInt(foodList.size)
        return foodList[index]
    }
}