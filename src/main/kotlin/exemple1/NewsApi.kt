package fr.hamtec.exemple1

import fr.hamtec.fr.hamtec.exemple1.ArticleHeadline

interface NewsApi {
    suspend fun fetchLatestNews(): List<ArticleHeadline>
}