package com.faqiy.doadzikirapp.ui.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.faqiy.doadzikirapp.adapter.DoaDzikirAdapter
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityPetangBinding
import com.faqiy.doadzikirapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_petang)

        // initializq property of _binding with layoutInflater to get the layout
        _binding = ActivityPetangBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this os for connect the view using view binding
        setContentView(binding.root)

        // set recycleView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPetang())
        binding.rvDzikirPetang.adapter = mAdapter
        // layoutManager is a class to set our structure of recycleview to display dataset
        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =  null
    }
}