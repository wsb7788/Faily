package com.project.faily.ui.notice





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.main.MainListener
import com.project.faily.data.remote.notice.NoticeListener

class NoticeViewModel: ViewModel(){
    var noticeListener: NoticeListener? = null
}