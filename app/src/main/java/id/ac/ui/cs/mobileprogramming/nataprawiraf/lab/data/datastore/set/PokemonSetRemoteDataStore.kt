package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.set

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonSet
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.utils.PokemonTcgService

class PokemonSetRemoteDataStore(private val pokemonTcgService: PokemonTcgService) :
    PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
        val response = pokemonTcgService.getSets()
        if (response.isSuccessful) return response.body()?.sets

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>?) {
    }
}