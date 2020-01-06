package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // menginisialisasi viewmodel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        displayResult()
        btn_calculate.setOnClickListener{
            val width = edt_width.text.toString()
            val height = edt_height.text.toString()
            // get value from layout edittext
            val length= edt_length.text.toString()
            when{
                width.isEmpty()->{
                    edt_width.error= "Masih Kosong"
                }
                height.isEmpty()->{
                    // ketika height kosong
                    edt_height.error= "Masih Kosong"
                }
                length.isEmpty()->{
                    edt_length.error= "Masih Kosong"
                }
                else ->{
                    // mengeset calculate result
                    viewModel.calculate(width, height, length)
                    // mengeset resutl
                    displayResult()
                }
            }
        }
    }

    // call result viewmodel
    private fun displayResult() {
        tv_result.text = viewModel.result.toString()
    }
}
