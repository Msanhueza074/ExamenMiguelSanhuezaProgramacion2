package cl.msanhueza.examenmiguelsanhuezap2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion
import cl.msanhueza.examenmiguelsanhuezap2.repository.MedicionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MedicionViewModel(private val repository: MedicionRepository) : ViewModel() {

    val mediciones: Flow<List<Medicion>> = repository.obtenerMediciones()

    fun agregar(tipo: String, valor: Int, fecha: String) {
        viewModelScope.launch {
            repository.agregarMedicion(
                Medicion(tipo = tipo, valor = valor, fecha = fecha)
            )
        }
    }
}

