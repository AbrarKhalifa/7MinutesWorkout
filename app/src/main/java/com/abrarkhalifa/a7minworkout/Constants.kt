package com.abrarkhalifa.a7minworkout

object Constants {

    fun defaultExerciseList() : ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.jumping_jacks,
            false,
            false
        )

        exerciseList.add(jumpingJacks)
        val planks = ExerciseModel(
            1,
            "plank",
            R.drawable.plank,
            false,
            false
        )

        exerciseList.add(planks)
        val crunches = ExerciseModel(
            1,
            "Crunches Abdominal",
            R.drawable.crunches,
            false,
            false
        )

        exerciseList.add(crunches)

        val pushUp = ExerciseModel(
            2,
            "Push Ups",
            R.drawable.push_up,
            false,
            false
        )

        exerciseList.add(pushUp)

        return exerciseList
    }

}