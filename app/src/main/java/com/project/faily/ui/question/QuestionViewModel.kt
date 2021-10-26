package com.project.faily.ui.question





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.data.repository.question.QuestionRepository

class QuestionViewModel(val repository: QuestionRepository): ViewModel(){
    var questionListener: QuestionListener? = null


}