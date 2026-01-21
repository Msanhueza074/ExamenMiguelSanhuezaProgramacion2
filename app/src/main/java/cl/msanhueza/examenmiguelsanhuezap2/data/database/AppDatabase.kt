package cl.msanhueza.examenmiguelsanhuezap2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.msanhueza.examenmiguelsanhuezap2.data.dao.MedicionDao
import cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion

@Database(entities = [Medicion::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicionDao(): MedicionDao
}
