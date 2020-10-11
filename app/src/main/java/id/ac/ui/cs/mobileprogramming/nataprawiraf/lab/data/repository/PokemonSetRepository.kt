package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.repository

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.set.PokemonSetDataStore
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonSet

class PokemonSetRepository private constructor() : BaseRepository<PokemonSetDataStore>() {
    suspend fun getSets(): MutableList<PokemonSet>? {
        val cache = localDataStore?.getSets()
        if (cache != null) return cache
        val response = remoteDataStore?.getSets()
        localDataStore?.addAll(response)
        return response
    }

    companion object {
        val instance by lazy { PokemonSetRepository() }
    }
}

