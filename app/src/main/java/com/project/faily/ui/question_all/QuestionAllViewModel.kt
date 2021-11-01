package com.project.faily.ui.question_all





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.data.remote.qustion_all.QuestionAllListener
import com.project.faily.data.repository.question.QuestionRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class QuestionAllViewModel(private val repository: QuestionRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){


    var questionAllListener: QuestionAllListener? = null

  /*  fun recentQuestionLoad() {

        Coroutines.main {

            try {

                val response = repository.allQuestion()

                if(response.isSuccess){
                    questionListener!!.onLoadSuccess(response.result)
                    return@main
                }
                questionListener!!.onLoadFailure(response.message)

            }catch (e:Exception){
                questionListener!!.onLoadFailure(e.message!!)
            }
        }

    }
*/
    fun saveQuestionInfo(questionIndex: Int) {
        sharedPreferencesManager.saveQuestionIndex(questionIndex)
    }
}