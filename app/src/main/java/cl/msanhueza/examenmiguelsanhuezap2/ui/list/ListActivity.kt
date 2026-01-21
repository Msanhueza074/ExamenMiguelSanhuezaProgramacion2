package cl.msanhueza.examenmiguelsanhuezap2.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import cl.msanhueza.examenmiguelsanhuezap2.data.database.AppDatabase
import cl.msanhueza.examenmiguelsanhuezap2.databinding.ActivityListBinding
import cl.msanhueza.examenmiguelsanhuezap2.repository.MedicionRepository
import cl.msanhueza.examenmiguelsanhuezap2.viewmodel.MedicionViewModel
import cl.msanhueza.examenmiguelsanhuezap2.MedicionAdapter
import cl.msanhueza.examenmiguelsanhuezap2.ui.form.FormActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: MedicionViewModel
    private lateinit var adapter: MedicionAdapter
    private var dataJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar DB + Repo + VM
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "mediciones.db"
        ).build()

        val repository = MedicionRepository(db.medicionDao())
        viewModel = MedicionViewModel(repository)

        // Inicializar Recycler
        adapter = MedicionAdapter()
        binding.recyclerMediciones.layoutManager = LinearLayoutManager(this)
        binding.recyclerMediciones.adapter = adapter

        binding.btnAgregar.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        // Cancelar colectas previas para evitar duplicados
        dataJob?.cancel()

        dataJob = lifecycleScope.launch {
            viewModel.mediciones.collect { lista ->
                adapter.submitList(lista)
            }
        }
    }
}
