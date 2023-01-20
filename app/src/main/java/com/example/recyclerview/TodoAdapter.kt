package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemTodoBinding

class TodoAdapter(
    var todos: List<Todo>
) :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    lateinit var binding: ItemTodoBinding

    inner class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(todo:Todo) {
            binding.tvTitle.text = todo.title
            binding.cbDone.isChecked = todo.isChecked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = todos[position]
        holder.bindItems(item)
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}
