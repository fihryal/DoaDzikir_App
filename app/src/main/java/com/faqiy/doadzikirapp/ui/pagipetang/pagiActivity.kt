package com.faqiy.doadzikirapp.ui.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.faqiy.doadzikirapp.adapter.DoaDzikirAdapter
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityPagiBinding
import com.faqiy.doadzikirapp.model.DataDoaDzikir

class pagiActivity : AppCompatActivity() {
    private var _binding: ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qouliyah_sholat)

        // initializq property of _binding with layoutInflater to get the layout
        _binding = ActivityPagiBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this os for connect the view using view binding
        setContentView(binding.root)

        // set recycleView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPagi())
        binding.rvDzikirPagi.adapter = mAdapter
        // layoutManager is a class to set our structure of recycleview to display dataset
        binding.rvDzikirPagi.layoutManager = LinearLayoutManager(this)
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