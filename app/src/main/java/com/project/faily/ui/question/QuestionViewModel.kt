package com.project.faily.ui.question





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.question.QuestionListener

class QuestionViewModel: ViewModel(){
    var questionListener: QuestionListener? = null
}