package com.project.faily.ui.answer





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.entities.SendAnswerBody
import com.project.faily.data.remote.answer.AnswerListener
import com.project.faily.data.repository.answer.AnswerRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class AnswerViewModel(private val repository: AnswerRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){

    val content: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    var answerListener: AnswerListener? = null

    fun checkAnswer() {

        val content = content.value.toString()

        if(content.isNullOrEmpty()){
            answerListener!!.onFailure("내용을 입력해주세요.")
            return
        }

        Coroutines.main {

            try {
                val questionIndex = sharedPreferencesManager.getQuestionIndex()
                val response = repository.sendAnswer(SendAnswerBody(content, questionIndex))
                if(response.isSuccess){
                    answerListener!!.onSuccess(response.message)
                    return@main
                }
                    answerListener!!.onFailure(response.message)
            }catch (e:Exception){
                answerListener!!.onFailure(e.message!!)
            }
        }

    }
}