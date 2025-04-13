package com.example.lab3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dataset: Array<Goal> = arrayOf(
            Goal("Понедельник: Итальянская паста Карбонара", "Классическая паста с густым соусом из яиц, пармезана, панчетты и черного перца", R.drawable.monday
            ),
            Goal("Вторник: Мексиканские фахитос", "Мясо с перцами и луком, подается с лепешками, гуакамоле и сметаной", R.drawable.tuesday
        ),
            Goal("Среда: Японский рамен", "Наваристый бульон с пшеничной лапшой, свининой чашу и яйцом", R.drawable.wednesday
            ),
            Goal("Четверг: Индийское карри", "Ароматное блюдо с курицей в кокосовом молоке и смесью специй", R.drawable.thursday
            ),
            Goal("Пятница: Американские бургеры", "Сочные котлеты с сыром, овощами и специальным соусом", R.drawable.friday
            ),
            Goal("Суббота: Французский рататуй", "Овощное рагу из баклажанов, кабачков и перцев с прованскими травами", R.drawable.saturday
            ),
            Goal("Воскресенье: Русские блины", "Тонкие блинчики с разными начинками: от сгущенки до красной икры", R.drawable.sunday
            )
        )

        val goalAdapter = GoalAdapter(this, dataset)
        val recyclerView: RecyclerView = findViewById(R.id.goals_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = goalAdapter
    }
}