package com.sevvalekinci.kentsimgeleriuygulamas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.sevvalekinci.kentsimgeleriuygulamas.databinding.ActivityDetailsBinding
import com.sevvalekinci.kentsimgeleriuygulamas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val galata = Landmark("Galata Kulesi","Türkiye",R.drawable.galata)
        val greatWall = Landmark("the Great Wall of China","China",R.drawable.cinseddi)
        val eiffel = Landmark("Eiffel Tower","France",R.drawable.eiffel)
        val londonEye = Landmark("London Eye","London",R.drawable.londoneye)

        landmarkList.add(galata)
        landmarkList.add(greatWall)
        landmarkList.add(eiffel)
        landmarkList.add(londonEye)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })

        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("Landmark",landmarkList.get(position))
            startActivity(intent)
        }



    }
}