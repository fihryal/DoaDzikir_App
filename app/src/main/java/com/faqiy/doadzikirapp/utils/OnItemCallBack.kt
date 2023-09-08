package com.faqiy.doadzikirapp.utils

import com.faqiy.doadzikirapp.model.ArticleItem

interface OnItemCallBack {
    fun onItemClicked (item: ArticleItem)
}