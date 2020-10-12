package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.ui.setlist

import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.model.PokemonSet

data class SetListViewState (
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<PokemonSet>? = null
)