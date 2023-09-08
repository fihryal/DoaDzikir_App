package com.faqiy.doadzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.faqiy.doadzikirapp.adapter.DoaDzikirAdapter
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.faqiy.doadzikirapp.model.DoaDzikirItem

class DzikirHarianActivity : AppCompatActivity() {

        private var _binding: ActivityDzikirSetiapSaatBinding? = null
        private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            setContentView(R.layout.activity_dzikir_setiap_saat)

            // initializq property of _binding with layoutInflater to get the layout
            _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
            // replace argument of setContentView using viewBinding
            // this os for connect the view using view binding
            setContentView(binding.root)

            providingDzikirDatas()
            initView()
    }

    private fun initView() {
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(providingDzikirDatas())
        binding.rvDzikir.adapter = mAdapter
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirDatas(): ArrayList<DoaDzikirItem> {
        // data ser of dzikir harian is location in string.xml
        // we need ger string-array form string.xml put into a variable
        // resources is a variable from appcompat wit h getting access to resource derectory
        // from resource we need call resource directory like as drawable, layout , values (string, theme, color)
        // so now variable titleDzikir containing datas as String-Array  arr_dzikir_doa_harian
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val traaslateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (i in titleDzikir.indices){
            val data = DoaDzikirItem(
                titleDzikir[i],
                arabicDzikir[i],
                traaslateDzikir [i]
            )
            listData.add(data)
        }
        return listData
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