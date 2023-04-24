package com.example.a6images

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private val animalNames = arrayOf(
        "Cat", "Dog", "Elephant",
        "Giraffe", "Lion", "Monkey"
    )

    private val animalImages = intArrayOf(
        R.drawable.cat, R.drawable.dog, R.drawable.elephant,
        R.drawable.giraffe, R.drawable.lion, R.drawable.monkey
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.grid_view)
        val adapter = AnimalAdapter(this, animalNames, animalImages)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, animalNames[position], Toast.LENGTH_SHORT).show()
        }
    }
}

class AnimalAdapter(
    private val context: Context,
    private val animalNames: Array<String>,
    private val animalImages: IntArray
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(R.layout.animal_item, parent, false)

        view.findViewById<ImageView>(R.id.image_view).setImageResource(animalImages[position])
        view.findViewById<TextView>(R.id.text_view).text = animalNames[position]

        return view
    }

    override fun getItem(position: Int): Any {
        return animalNames[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return animalNames.size
    }
}
