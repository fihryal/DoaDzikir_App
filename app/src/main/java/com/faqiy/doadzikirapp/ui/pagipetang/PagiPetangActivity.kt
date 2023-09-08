package com.faqiy.doadzikirapp.ui.pagipetang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.faqiy.doadzikirapp.R
import com.faqiy.doadzikirapp.databinding.ActivityMainBinding
import com.faqiy.doadzikirapp.databinding.ActivityPagiPetangBinding

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityPagiPetangBinding? = null
    private val binding get() = _binding as ActivityPagiPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_pagi_petang)

        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

        btnPagi.setOnClickListener (this)
        btnPetang.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, pagiActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, PetangActivity::class.java))
        }
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