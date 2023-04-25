package com.example.prueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.prueba.databinding.ActivityMainBinding

class bubble1:   AppCompatActivity() {

   private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)

        setupSpinner()
    }

    private fun setupSpinner() {
        val personNames = arrayOf("Rahul", "J ack", "Rajeev", "Aryan", "Rashmi", "Jaspreet", "Akbar")
        val spinner = mBinding.spinnerID
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    /* context = */ this@bubble1,
                    /* text = */ getString(R.string.selected_item) + " " + personNames[position],
                    /* duration = */ Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }
    }
}
