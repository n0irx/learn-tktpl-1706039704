package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.card

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonCard

interface PokemonCardDataStore {
    suspend fun getPokemons(set: String): MutableList<PokemonCard>?
    suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?)
}