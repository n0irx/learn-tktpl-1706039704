package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.set

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonSet

interface PokemonSetDataStore {
    suspend fun getSets(): MutableList<PokemonSet>?
    suspend fun addAll(sets: MutableList<PokemonSet>?)
}