package com.abrarkhalifa.a7minworkout

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_excercise.*
import kotlinx.android.synthetic.main.activity_excercise.view.*
import java.util.*
import kotlin.collections.ArrayList

class excerciseActivity : AppCompatActivity() {

    private var restTimer:CountDownTimer? = null
    private var restProgress = 0
    private var exerciseTimer:CountDownTimer? = null
    private var exerciseProgress = 0

    private var exerciseList : ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)

        setSupportActionBar(toolbarExcercise)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        toolbarExcercise.setNavigationOnClickListener {
            onBackPressed()
        }

        exerciseList = Constants.defaultExerciseList()

        setUpRestView()




    }

    fun setUpRestView(){

        flRestView.visibility = View.VISIBLE
        textView.visibility = View.VISIBLE
        tvExerciseName.visibility= View.INVISIBLE
        flExerciseView.visibility = View.INVISIBLE
        ivImage.visibility = View.INVISIBLE
        tvUpcomingLabel.visibility = View.VISIBLE
        tvUpcomingExerciseName.visibility = View.VISIBLE

        if (restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }

        tvUpcomingExerciseName.text = exerciseList!![currentExercisePosition + 1].getname()
        setRestProgress()
    }

    fun setUpExerciseView(){
        flRestView.visibility = View.INVISIBLE
        textView.visibility = View.INVISIBLE
        tvExerciseName.visibility= View.VISIBLE
        flExerciseView.visibility = View.VISIBLE
        ivImage.visibility = View.VISIBLE
        tvUpcomingLabel.visibility = View.INVISIBLE
        tvUpcomingExerciseName.visibility = View.INVISIBLE

        if (exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        ivImage.setImageResource(exerciseList!![currentExercisePosition].getimage())
        tvExerciseName.text = exerciseList!![currentExercisePosition].getname()
        setExerciseProgress()
    }


    private fun setRestProgress(){
        progressBar.progress = restProgress

        restTimer = object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress = 10 - restProgress
                tvTimer.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                currentExercisePosition++
                setUpExerciseView()
            }

        }.start()
    }
    private fun setExerciseProgress(){
        progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                progressBarExercise.progress = 30 - exerciseProgress
                tvTimerExercise.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                if (currentExercisePosition < exerciseList?.size!! - 1){
                    setUpRestView()
                }else{
                    Toast.makeText(applicationContext, "Congratulations you finished 7 minutes workout exercise", Toast.LENGTH_SHORT).show()
                }
            }

        }.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        if (restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        if (exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
    }
}