package com.example.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // make result fungsi for in main
    var result = 0;

    fun calculate(width: String, height: String, length: String) {
        // membuat rumus untuk mendapatkan hasil hitung
        result = width.toInt() * height.toInt() * length.toInt()
    }
}