package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todosList = mutableListOf(
            Todo("Fazer bolo", false),
            Todo("Estudar trila Lackner", false),
            Todo("Lavar roupa", false),
            Todo("Fazer Marikondo", false),
            Todo("Estudar francês", false),
            Todo("Ler livro Objeto", false),
            Todo("Ler Ikigai", false)
        )

        val adapter = TodoAdapter(todosList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todosList.add(todo)
            adapter.notifyItemInserted(todosList.size - 1)
            binding.etTodo.text.clear()
        }
    }
}