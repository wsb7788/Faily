package com.project.faily.ui.answer





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.answer.AnswerListener
import com.project.faily.data.remote.gallery.GalleryListener
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener

class AnswerViewModel: ViewModel(){
    var answerListener: AnswerListener? = null
}