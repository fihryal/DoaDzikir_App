package com.faqiy.doadzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.faqiy.doadzikirapp.adapter.DoaDzikirAdapter
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.faqiy.doadzikirapp.model.DataDoaDzikir

class DzikirSetiapSaatActivity : AppCompatActivity() {

    private var _binding: ActivityDzikirSetiapSaatBinding? = null
    private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qouliyah_sholat)

        // initializq property of _binding with layoutInflater to get the layout
        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this os for connect the view using view binding
        setContentView(binding.root)

        // set recycleView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikir())
        binding.rvDzikir.adapter = mAdapter
        // layoutManager is a class to set our structure of recycleview to display dataset
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
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