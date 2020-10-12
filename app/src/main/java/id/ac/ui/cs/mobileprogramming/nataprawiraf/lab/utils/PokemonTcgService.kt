package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.utils

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonCard
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonSet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonTcgService {
    @GET("cards")
    suspend fun getCards(@Query("set") set: String): Response<PokemonCard.PokemonCardResponse>

    @GET("sets")
    suspend fun getSets(): Response<PokemonSet.PokemonSetResponse>
}