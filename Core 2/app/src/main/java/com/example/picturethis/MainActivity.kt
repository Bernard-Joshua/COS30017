package com.example.picturethis

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.picturethis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var foods: List<Food>
    private lateinit var res: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Getting the resource ID's of the images.
        res = listOf(
            resources.getIdentifier("cake", "drawable", packageName),
            resources.getIdentifier("muffin", "drawable", packageName),
            resources.getIdentifier("pie", "drawable", packageName),
            resources.getIdentifier("croissant", "drawable", packageName)
        )

        //Creating Classes and passing the data through them
        listOf(
            Food(0, "Cake", "pastry", "10/22/2021", 2.5f, res[0]),
            Food(1, "Muffin", "pastry", "10/22/2021", 2.5f, res[1]),
            Food(2, "Pie", "pastry", "10/22/2021", 2.5f, res[2]),
            Food(3, "Croissant", "pastry", "10/22/2021", 2.5f, res[3])
        ).also { foods = it }

        //OnClickFunctions
        binding.one.setOnClickListener { passData(foods[0]) }
        binding.two.setOnClickListener { passData(foods[1]) }
        binding.three.setOnClickListener { passData(foods[2]) }
        binding.four.setOnClickListener { passData(foods[3]) }

    }

    // Function to reduce the amount of code needed for on click listeners
    private fun passData(food: Food) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("EXTRA_ITEM", food)
        resultLauncher.launch(intent)
    }

    // Used to launch/execute the program
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val food = data?.getParcelableExtra<Food>("EXTRA_NEW_ITEM")

                // Usage of lists allows for a reduction in the amount of code needed to produce the
                // outcome
                food?.let {
                    val i = food.ID
                    foods[i].name = food.name
                    foods[i].cuisine = food.cuisine
                    foods[i].rating = food.rating
                    foods[i].date = food.date

                    Log.d("Success", foods[i].toString())

                    when (i) {
                        0 -> {
                            binding.cName.text = foods[i].name
                            binding.cRating.text = foods[i].rating.toString()
                        }
                        1 -> {
                            binding.mName.text = foods[i].name
                            binding.mRating.text = foods[i].rating.toString()
                        }
                        2 -> {
                            binding.pName.text = foods[i].name
                            binding.pRating.text = foods[i].rating.toString()
                        }
                        3 -> {
                            binding.crName.text = foods[i].name
                            binding.crRating.text = foods[i].rating.toString()
                        }
                    }

                }

            }

        }

}