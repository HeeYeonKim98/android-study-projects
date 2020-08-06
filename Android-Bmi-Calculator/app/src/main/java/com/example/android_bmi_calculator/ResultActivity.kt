package com.example.android_bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height= intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        val bmi = weight/ (height / 100.0).pow(2.0)

        //텍스트
        when{
            bmi>=35 -> ResultText.text = "고도비만"
            bmi>=30 -> ResultText.text = "2단계 비만"
            bmi>=25 -> ResultText.text = "1단계 비만"
            bmi>=23 -> ResultText.text = "과체중"
            bmi>=18.5 -> ResultText.text = "정상"
            else -> ResultText.text = "저체중"
        }

        //이미지
        when{
            bmi>=23-> imageView.setImageResource(
                R.drawable.ic_baseline_clear_24
            )
            bmi>=18.5 -> imageView.setImageResource(
                R.drawable.ic_baseline_favorite_24
            )
            else->imageView.setImageResource(
                R.drawable.ic_baseline_details_24
            )
        }

        toast("$bmi")
    }
}