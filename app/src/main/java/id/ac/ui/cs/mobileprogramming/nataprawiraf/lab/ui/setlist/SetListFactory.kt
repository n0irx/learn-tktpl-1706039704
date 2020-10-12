package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.ui.setlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.repository.PokemonSetRepository

class SetListFactory(
    private val setRepository: PokemonSetRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetListViewModel::class.java))
            return SetListViewModel(setRepository) as T
        throw IllegalArgumentException()
    }
}