package com.selimcinar.gezikitab

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.selimcinar.gezikitab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList:ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        landmarkList = ArrayList<Landmark>()

        //Data
        val konya = Landmark("Konya","Türkiye",R.drawable.simge)
        val nevşehir= Landmark("Nevşehir","Türkiye",R.drawable.simge2)
        val antalya = Landmark("Antalya","Türkiye",R.drawable.simge3)
        val ankara = Landmark("Ankara","Türkiye",R.drawable.simge4)

        landmarkList.add(konya)
        landmarkList.add(nevşehir)
        landmarkList.add(antalya)
        landmarkList.add(ankara)


        // Adapter : Layout & Data bağlantısı kurar

        //Mapping transform yapar isme özelliğe dönüştür gibi
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter=adapter


        // tıklanınca ne olacağı
        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            //veriyi gönderme diğer aktiviteye
            val intent = Intent(MainActivity@this,ActivityDetails::class.java)
        intent.putExtra("Landmark",landmarkList.get(position))
        startActivity(intent)
        }
    }
}