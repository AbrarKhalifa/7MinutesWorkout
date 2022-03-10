package com.abrarkhalifa.a7minworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abrarkhalifa.a7minworkout.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var Binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flStart.setOnClickListener{
            Toast.makeText(this, "Start the exercise", Toast.LENGTH_SHORT).show()
            val intent:Intent = Intent(this,excerciseActivity::class.java)
            startActivity(intent)
        }
    }
}