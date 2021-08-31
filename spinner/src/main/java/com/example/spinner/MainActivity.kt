package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.spinner.adapters.HabrAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initSimpleSpinner()
        initSimpleSpinnerWithHabrAdapter()
    }

    private fun initSimpleSpinnerWithHabrAdapter() {
        val spinner = findViewById<View>(R.id.simple_spinner_habr_adapter) as Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.planets_array_short,
            R.layout.new_first_item_droppdown
        )
        // выше устанавливается выбранный элемент

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // adapter.setDropDownViewResource(R.layout.new_first_item_droppdown) //установка view для элемента открытого спиннера. Если этого не сделать то будет выводиться layout  для выбранного элемента

        spinner.adapter = adapter

        // установка hint
        spinner.adapter = HabrAdapter(
            adapter,
            R.layout.first_item,
//            R.layout.first_item_droppdown,
            this
        )
    }

    private fun initSimpleSpinner() {
        val spinner: Spinner = findViewById(R.id.simple_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
}
