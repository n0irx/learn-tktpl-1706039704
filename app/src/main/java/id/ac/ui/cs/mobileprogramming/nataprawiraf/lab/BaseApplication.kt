package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import android.app.Application
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.database.AppDatabase
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.card.PokemonCardRemoteDataStore
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.card.PokemonCardRoomDataStore
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.set.PokemonSetRemoteDataStore
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.datastore.set.PokemonSetRoomDataStore
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.repository.PokemonCardRepository
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.data.repository.PokemonSetRepository
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.utils.RetrofitApp

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val pokemonTcgService = RetrofitApp.POKEMON_TCG_SERVICE
        val appDatabase = AppDatabase.getInstance(this)
        PokemonSetRepository.instance.apply {
            init(
                PokemonSetRoomDataStore(appDatabase.pokemonSetDao()),
                PokemonSetRemoteDataStore(pokemonTcgService)
            )
        }

        PokemonCardRepository.instance.apply {
            init(
                PokemonCardRoomDataStore(appDatabase.pokemonCardDao()),
                PokemonCardRemoteDataStore(pokemonTcgService)
            )
        }
    }
}