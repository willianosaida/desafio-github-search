package br.com.igorbag.githubsearch.data

import br.com.igorbag.githubsearch.domain.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    suspend fun getAllRepositoriesByUser(@Path("user") user: String): List<Repository>
    abstract fun getUserRepositories(usuario: String): Any

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GitHubService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(GitHubService::class.java)
        }
    }
}

