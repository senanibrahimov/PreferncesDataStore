package com.example.localdatabase

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppDataStore(var context:Context) {

    val Context.ds:DataStore<Preferences> by preferencesDataStore("information")//bu kod databazaya erismeye komek edir,yazilan information ise filein adidir

    companion object{
        val NAME_KEY= stringPreferencesKey("NAME")
        val AGE_KEY= intPreferencesKey("AGE")
        val TALL_KEY= doublePreferencesKey("TALL")
        val MARRIED_KEY= booleanPreferencesKey("MARRIED")
        val List_KEY= stringSetPreferencesKey("LIST")
 // DIGER emeliyyatlarda name uygundu
    }

   suspend fun  nameSave(name:String) {
       context.ds.edit {
           it[NAME_KEY] = name
       }
   }
       suspend fun nameRead(): String {
           val p = context.ds.data.first()// p obyekti yuxaridaki prefernces datastori gosteriri
           return p[NAME_KEY] ?: " There is not a name" //  key le oxuma islemi edirik
       }

    suspend fun deleteName(){
        context.ds.edit {

            it.remove(NAME_KEY)
        }
    }
}