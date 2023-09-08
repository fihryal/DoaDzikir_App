package com.faqiy.doadzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArticleBinding? = null
    private val binding get() = _binding as ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back)

        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleArticle = intent.getStringExtra(EXTRA_DATA_TITLE)
        val contentArticle = intent.getStringExtra("content")
        val imageArticle = intent.getIntExtra("image",1)

        binding.apply {
            tvDetailTitle.text = titleArticle
            tvDetailContent.text = contentArticle
            imgDetaiArticle.setImageResource(imageArticle)

        }
    }

    // object used in this Activity witch can access by yhe other class
    companion object{
        // constant for save KEY of data trasaction
        const val EXTRA_DATA_TITLE = "title"
    }
}