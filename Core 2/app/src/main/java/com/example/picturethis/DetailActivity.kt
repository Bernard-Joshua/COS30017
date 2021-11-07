package com.example.picturethis

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.picturethis.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private lateinit var fData: Food

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize the values
        val fName = binding.fName
        val fCuisine = binding.fCuisine
        val fRating = binding.fRating
        val fDate = binding.fDate
        val fImg = binding.fImg

        //Get the intent from main activity
        fData = intent.getParcelableExtra("EXTRA_ITEM")!!
        // Converting the resource id of the image
        val drawable = resources.getDrawable(fData.resID, theme)
        fImg.setImageDrawable(drawable) // Setting the image for the second activity

        //Set the values of the intent to the corresponding EditText Views
        fName.setText(fData.name)
        fCuisine.setText(fData.cuisine)
        fDate.setText(fData.date)

        // Set the rating for the rating bar
        fRating.rating = fData.rating

    }

     /**
     * Utility function to carry out validation.
     * Doing this will reduce the amount of code needed to be written for validation.
     * It takes in the view id and a string that would indicate the field
     **/
    private fun validate(e: EditText, field: String) {
        if (e.text == null || e.text.isEmpty())
            e.error = "$field field cannot be empty"
    }

    override fun onBackPressed() {

        // Validate Values after the back button is pressed
        validate(binding.fName, "Dessert")
        validate(binding.fCuisine, "Cuisine")
        validate(binding.fDate, "Date")

        // Setting the values ( If the entered value is null then null will be set etc.. )
        fData.name = binding.fName.text.toString()
        fData.cuisine = binding.fCuisine.text.toString()
        fData.rating = binding.fRating.rating
        fData.date = binding.fDate.text.toString()

        // For debugging purposes
        //Log.d("Debug", "${fData.name} ${fData.cuisine} ${fData.date}")

        /* Actual validation logic. Prevents the activity from moving to the main activity
         if condition is not met. */
        if (fData.name.isNotEmpty() && fData.cuisine.isNotEmpty() && fData.date.isNotEmpty()) {
            val data = Intent(this, MainActivity::class.java).apply {
                putExtra("EXTRA_NEW_ITEM", fData)
            }
            setResult(RESULT_OK, data)
            // Indicates successful data storage
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }


    }

}
