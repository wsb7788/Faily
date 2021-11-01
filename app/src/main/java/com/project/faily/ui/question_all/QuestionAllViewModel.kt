package com.project.faily.ui.question_all





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.data.remote.qustion_all.QuestionAllListener
import com.project.faily.data.repository.question.QuestionRepository
import com.project.faily.data.repository.question_all.QuestionAllRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class QuestionAllViewModel(private val repository: QuestionAllRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){


    var questionAllListener: QuestionAllListener? = null

    fun allQuestionLoad() {

        Coroutines.main {

            try {

                val response = repository.allQuestion()

                if(response.isSuccess){
                    questionAllListener!!.onLoadSuccess(response.result)
                    return@main
                }
                questionAllListener!!.onLoadFailure(response.message)

            }catch (e:Exception){
                questionAllListener!!.onLoadFailure(e.message!!)
            }
        }

    }

    fun saveQuestionInfo(questionIndex: Int) {
        sharedPreferencesManager.saveQuestionIndex(questionIndex)
    }
}