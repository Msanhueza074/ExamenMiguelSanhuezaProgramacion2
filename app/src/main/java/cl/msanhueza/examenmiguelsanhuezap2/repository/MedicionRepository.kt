package cl.msanhueza.examenmiguelsanhuezap2.repository

import cl.msanhueza.examenmiguelsanhuezap2.data.dao.MedicionDao
import cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion
import kotlinx.coroutines.flow.Flow

class MedicionRepository(private val dao: MedicionDao) {

    fun obtenerMediciones(): Flow<List<Medicion>> {
        return dao.getAll()
    }

    suspend fun agregarMedicion(medicion: Medicion) {
        dao.insert(medicion)
    }
}


