package com.frogobox.research

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.research.databinding.ActivityMainBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import java.util.*


class MainActivity : AppCompatActivity() {

    companion object {
        private val ALPHABET = arrayOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z"
        )
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //create the ItemAdapter holding your Items
        val itemAdapter = ItemAdapter<SimpleItem>()

        //create the managing FastAdapter, by passing in the itemAdapter
        val fastAdapter = FastAdapter.with(itemAdapter)

        //fill with some sample data
        val items = ArrayList<SimpleItem>()
        for ((x, s) in ALPHABET.withIndex()) {
            val item = SimpleItem().withName("$s Test $x").withDescription("")
            items.add(item)
        }
        itemAdapter.add(items)

        //set our adapters to the RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = fastAdapter

    }
}