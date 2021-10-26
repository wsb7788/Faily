package com.project.faily.ui.question





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.data.repository.question.QuestionRepository
import com.project.faily.util.Coroutines

class QuestionViewModel(private val repository: QuestionRepository): ViewModel(){


    var questionListener: QuestionListener? = null

    fun recentQuestionLoad() {

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
}