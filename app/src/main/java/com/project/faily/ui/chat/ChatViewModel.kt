package com.project.faily.ui.chat





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.chat.ChatListener
import com.project.faily.data.remote.main.MainListener
import com.project.faily.data.remote.notice.NoticeListener

class ChatViewModel(): ViewModel(){
    var chatListener: ChatListener? = null
}