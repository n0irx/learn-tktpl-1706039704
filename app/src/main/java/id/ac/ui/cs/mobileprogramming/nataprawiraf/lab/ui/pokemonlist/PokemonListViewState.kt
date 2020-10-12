package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.ui.pokemonlist

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonCard
import java.lang.Exception

data class PokemonListViewState (
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<PokemonCard>? = null
)