package com.example.exam_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ColorBtn = findViewById(R.id.btnColor)
        BlueView = findViewById(R.id.Blue)
        RedView = findViewById(R.id.Red)
        YellowView = findViewById(R.id.Yellow)
    }

    lateinit var ColorBtn: Button
    lateinit var BlueView: View
    lateinit var RedView: View
    lateinit var YellowView: View

    val views: MutableList<View> = mutableListOf() //изменяемый лист
    var currentViewIndex = 0 //для хранения текущего видимого элемента

    fun btnColorClick(view: View) {

        views.add(BlueView) //добавляем элементы в список в определенном порядке
        views.add(RedView)
        views.add(YellowView)

        views[currentViewIndex].visibility = View.INVISIBLE //скрываем элемент
        currentViewIndex = (currentViewIndex + 1) % views.size // инкремируем и берем остаток от деления на размер списка, чтобы дальше по круговому порядку
        views[currentViewIndex].visibility = View.VISIBLE //следующий элемент делаем видимым
    }
}
