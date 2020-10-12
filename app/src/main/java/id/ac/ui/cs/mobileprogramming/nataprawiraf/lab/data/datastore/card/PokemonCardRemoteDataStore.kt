package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.card

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonCard
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.utils.PokemonTcgService

class PokemonCardRemoteDataStore(private val pokemonTcgService: PokemonTcgService) : PokemonCardDataStore {
    override suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val response = pokemonTcgService.getCards(set)
        if (response.isSuccessful) return response.body()?.cards

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
    }
}
