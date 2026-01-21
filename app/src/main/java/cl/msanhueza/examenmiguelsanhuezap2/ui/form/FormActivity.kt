package cl.msanhueza.examenmiguelsanhuezap2.ui.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import cl.msanhueza.examenmiguelsanhuezap2.data.database.AppDatabase
import cl.msanhueza.examenmiguelsanhuezap2.databinding.ActivityFormBinding
import cl.msanhueza.examenmiguelsanhuezap2.repository.MedicionRepository
import cl.msanhueza.examenmiguelsanhuezap2.viewmodel.MedicionViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    private lateinit var viewModel: MedicionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar Room + Repo + ViewModel (rápido)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "mediciones.db"
        ).build()

        val repository = MedicionRepository(db.medicionDao())
        viewModel = MedicionViewModel(repository)

        binding.btnGuardar.setOnClickListener {
            guardarMedicion()
        }
    }

    private fun guardarMedicion() {
        val valor = binding.txtValor.text.toString().toIntOrNull()
        val fecha = binding.txtFecha.text.toString()

        val tipo = when {
            binding.rbAgua.isChecked -> "Agua"
            binding.rbLuz.isChecked -> "Luz"
            binding.rbGas.isChecked -> "Gas"
            else -> null
        }

        if (valor == null || tipo == null || fecha.isEmpty()) {
            return
        }

        MainScope().launch {
            viewModel.agregar(tipo, valor, fecha)
        }

        finish()
    }
}
