package com.faqiy.doadzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.faqiy.doadzikirapp.adapter.DoaDzikirAdapter
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityQouliyahSholatBinding
import com.faqiy.doadzikirapp.model.DataDoaDzikir

class QouliyahSholatActivity : AppCompatActivity() {

    private var _binding: ActivityQouliyahSholatBinding? = null
    private val binding get() = _binding as ActivityQouliyahSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qouliyah_sholat)

        // initializq property of _binding with layoutInflater to get the layout
        _binding = ActivityQouliyahSholatBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this os for connect the view using view binding
        setContentView(binding.root)

        // set recycleView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDataQouliyah)
        binding.rvQouliyahSholat.adapter = mAdapter
        // layoutManager is a class to set our structure of recycleview to display dataset
        binding.rvQouliyahSholat.layoutManager = LinearLayoutManager(this)
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