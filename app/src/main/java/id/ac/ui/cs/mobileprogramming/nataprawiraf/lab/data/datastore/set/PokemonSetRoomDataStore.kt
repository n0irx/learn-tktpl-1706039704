package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.set

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.database.PokemonSetDao
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonSet

class PokemonSetRoomDataStore(private val pokemonSetDao: PokemonSetDao) : PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
        val response = pokemonSetDao.getAll()
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>?) {
        sets?.let { pokemonSetDao.insertAll() }
    }
}