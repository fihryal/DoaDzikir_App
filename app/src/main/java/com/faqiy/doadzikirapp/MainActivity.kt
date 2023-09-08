package com.faqiy.doadzikirapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.faqiy.doadzikirapp.adapter.ArticleAdapter
import com.faqiy.doadzikirapp.databinding.ActivityMainBinding
import com.faqiy.doadzikirapp.model.ArticleItem
import com.faqiy.doadzikirapp.ui.DetailArticleActivity
import com.faqiy.doadzikirapp.ui.DzikirHarianActivity
import com.faqiy.doadzikirapp.ui.DzikirSetiapSaatActivity
import com.faqiy.doadzikirapp.ui.QouliyahSholatActivity
import com.faqiy.doadzikirapp.ui.pagipetang.PagiPetangActivity
import com.faqiy.doadzikirapp.ui.pagipetang.pagiActivity
import com.faqiy.doadzikirapp.utils.OnItemCallBack
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()

    // OnPageChangeCallback is sub Class from ViewPager2 for
    // responding to changing state if the selected page
    private val slidingCallback = object : ViewPager2.OnPageChangeCallback(){
        // instance onPageSelected give you access to setting behavior state of selected page
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for (i in initData().indices){
//                Toast.makeText(this@MainActivity, "Page $position", Toast.LENGTH_LONG).show()
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.inactive_dot)
                )
            }
            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.active_dot)

            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // di dapat dari depedenci gradle
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // serContentView is use to chose and  display layout in activity
        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices){
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.inactive_dot)
            )

            val params = LinearLayoutCompat.LayoutParams(35,35)
            params.marginStart = 8
            params.marginEnd = 8
            binding.dots.addView(dotSliderIndicator[i],params)

        }
    }

    private fun initView(){

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //declar variable to get in touch with view in layout activity_main
        // use findviewbyid to communicate with the view
        val cardQouliyahSholat = findViewById<MaterialCardView>(R.id.card_qouliyahsholat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_Dzikirsetiapsholat)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_Dzikirharian)
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.card_Dzikirpagipetang)

        //when card view clicked it will be navigate to other page
        //Intent is use for navigate to other activity by clicked cardview
        cardQouliyahSholat.setOnClickListener {
            //Intent(argument contxt, wich activity you want to go)
            val intent = Intent(this, QouliyahSholatActivity::class.java)
            // start to go destinationactivity
            startActivity(intent)
        }
        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData())
        mAdapter.setOnItemCallback(object : OnItemCallBack {
            override fun onItemClicked(item: ArticleItem) {
                val intent = Intent(applicationContext, DetailArticleActivity::class.java)
                // navigate do DetailArticleActivity with data using putExtra
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE,item.titleArticle)
                intent.putExtra("content",item.contentArticle)
                intent.putExtra("image",item.imageArticle)
                startActivity(intent)
            }

        })
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)
    }

    private fun initData() : MutableList<ArticleItem> {
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        val listData = mutableListOf<ArticleItem>()
        for (i in titleArticle.indices){
            val data = ArticleItem(
            titleArticle[i],
            imageArticle.getResourceId(i,0),
            contentArticle[i]
            )
            listData.add(data)
        }
        imageArticle.recycle()
        return listData
    }

    override fun onClick(view: View?){
            when(view?.id){
                R.id.card_Dzikirsetiapsholat -> startActivity(Intent(this,
                    DzikirSetiapSaatActivity::class.java))
                R.id.card_Dzikirharian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
                R.id.card_Dzikirpagipetang -> startActivity(Intent(this, PagiPetangActivity::class.java))
            }
        }
}