package com.zeph7.dinnerdecider

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var foodList = arrayListOf<String>("Pizza", "Cake", "Burger", "Rolls", "Noodles", "Chicken", "Drinks")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideButton.setOnClickListener {
            if(foodList.isEmpty()){
                selectedFoodTxt.text = "Food List Empty!!"
            }
            else {
                val random = Random()
                Handler().postDelayed({
                    selectedFoodTxt.text = foodList[random.nextInt(foodList.count())]
                }, 1000)
                selectedFoodTxt.text = "Go for..."
            }
        }

        addFoodButton.setOnClickListener{
            if(addFoodTxt.text.isEmpty()){
                Toast.makeText(this, "Please type a food!!", Toast.LENGTH_LONG).show()
            }else {
                val newFood = addFoodTxt.text.toString()
                foodList.add(newFood)
                addFoodTxt.text.clear()
                Toast.makeText(this, "Food Added To List", Toast.LENGTH_LONG).show()
            }
        }

        selectedFoodTxt.setOnClickListener {
            foodList.clear()
            selectedFoodTxt.text = "Dinner Decider"
            Toast.makeText(this, "Food List Cleared", Toast.LENGTH_LONG).show()
        }

    }
}
