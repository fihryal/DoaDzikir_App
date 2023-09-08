package com.faqiy.doadzikirapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faqiy.doadzikirapp.databinding.ItemArticleBinding
import com.faqiy.doadzikirapp.model.ArticleItem
import com.faqiy.doadzikirapp.ui.DetailArticleActivity
import com.faqiy.doadzikirapp.utils.OnItemCallBack

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){
    private  var listArticle = arrayListOf<ArticleItem>()
    private var onItemCallback: OnItemCallBack? = null

    fun setData(list: List<ArticleItem>){
        listArticle.clear()
        listArticle.addAll(list)
    }

    fun setOnItemCallback(onItemCallback: OnItemCallBack){
        this.onItemCallback = onItemCallback
    }

    inner class ArticleViewHolder(val view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ArticleViewHolder (
        ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.itemArticle.setImageResource(data.imageArticle)
        // this is give click event for each iten in viewPager
        holder.itemView.setOnClickListener{

            onItemCallback?.onItemClicked(data)

            // provide context for Intent
//            it.context.apply {
//                // navigate to DetailActivity
//                val intent = Intent(this,DetailArticleActivity::class.java)
//                // navigate do DetailArticleActivity with data using putExtra
//                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE,data.titleArticle)
//                intent.putExtra("content",data.contentArticle)
//                intent.putExtra("image",data.imageArticle)
//                startActivity(intent)
//
//            }
        }
    }


    }

