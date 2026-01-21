package cl.msanhueza.examenmiguelsanhuezap2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicionDao {

    @Query("SELECT * FROM mediciones ORDER BY id DESC")
    fun getAll(): Flow<List<Medicion>>

    @Insert
    suspend fun insert(medicion: Medicion)
}
