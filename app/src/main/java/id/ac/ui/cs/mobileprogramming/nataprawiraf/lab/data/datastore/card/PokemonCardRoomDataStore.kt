package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.card

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.database.PokemonCardDao
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonCard

class PokemonCardRoomDataStore(private val pokemonCardDao: PokemonCardDao) : PokemonCardDataStore {
    override suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val response = pokemonCardDao.getAll(set)
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        pokemons?.let { pokemonCardDao.insertAll(*it.toTypedArray()) }
    }
}