package com.selimcinar.gezikitab

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.selimcinar.gezikitab.databinding.ActivityDetailsBinding

class ActivityDetails : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        //veriyi alma
        val intent = intent
        // as cast yapma
        val selectedLandmark = intent.getSerializableExtra("Landmark") as Landmark
        binding.nameText.text=selectedLandmark.name
        binding.countyText.text=selectedLandmark.country
        binding.landImage.setImageResource(selectedLandmark.image)

    }
}