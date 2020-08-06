package com.example.android_bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        BmiButton.setOnClickListener {
//            val intent = Intent(this, ResultActivity::class.java)
//            intent.putExtra("height" , HeightEditText.text.toString())
//            intent.putExtra("weight" , WeightEditText.text.toString())
//            startActivity(intent)

            saveData(HeightEditText.text.toString().toInt(), WeightEditText.text.toString().toInt())

            startActivity<ResultActivity>(
                "height" to HeightEditText.text.toString(),
                "weight" to WeightEditText.text.toString()
            ) //Anko 라이브러리를 사용하면 코드가 간결해짐

        }
    }

    private fun saveData(height:Int, weight:Int){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height).putInt("KEY_WEIGHT",weight).apply()
    }

    private fun loadData(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT",0)
        val weight = pref.getInt("KEY_WEIGHT",0)

        if(height!=0 && weight!=0){
            HeightEditText.setText(height.toString())
            WeightEditText.setText(weight.toString())
        }
    }
}