package com.arslan.model

data class TrendingNews(
    val status: String = "",
    val totalResults: Int = 0,
    val articles: List<Article> = listOf()
) {
    data class Article(
        val source: Source = Source(),
        val author: String = "",
        val title: String = "",
        val description: String = "",
        val url: String = "",
        val urlToImage: String = "",
        val publishedAt: String = "",
        val content: String = ""
    ) {
        data class Source(
            val id: String = "",
            val name: String = ""
        )
    }
}