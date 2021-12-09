package com.og.examexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProgramAdapter(private val aboutProgram: List<String>) :
    RecyclerView.Adapter<ProgramViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.about_program_list_item, parent, false)
        return ProgramViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val name = aboutProgram[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return aboutProgram.size
    }
}