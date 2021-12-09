package com.og.examexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {

    lateinit var aboutProgramRecyclerView: RecyclerView
    lateinit var showWebSiteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val aboutProgram: List<String> = listOf("Всё достаточно просто!", " Узнать ответ на ваш вопрос можно " +
                "кликнув на кнопку под шариком",
                "Вы увидите ответ сразу же в центре шарика.", "Но помните, что шарик отвечает только вопросы",
            "которые подразумевают однозначный ответ на «да» или «нет».")

        showWebSiteButton=view.findViewById(R.id.show_web_site_button)
        aboutProgramRecyclerView = view.findViewById(R.id.program_recycler_view)
        aboutProgramRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        aboutProgramRecyclerView.adapter = ProgramAdapter(aboutProgram)

        showWebSiteButton.setOnClickListener {
            val link = Uri.parse("https://ball-8.ru/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }
        return view
    }


}