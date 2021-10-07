
package com.project.faily.ui.tutorial_invite




import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.tutorial_invite.TutorialInviteListener
import com.project.faily.data.repository.tutorial_invite.TutorialInviteRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class TutorialInviteViewModel(private val repository: TutorialInviteRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){


    var tutorialInviteListener:TutorialInviteListener? = null

    val chatCode: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    fun codeLoad() {

        Coroutines.main {

            try {
                val response = repository.groupCode()

                if(response.isSuccess){
                    tutorialInviteListener!!.onLoadSuccess(response.GroupCode)
                    return@main
                }
                tutorialInviteListener!!.onLoadFailure(response.message)
            }catch (e:Exception){
                tutorialInviteListener!!.onLoadFailure(e.message!!)
            }
        }
    }

    fun saveChatCode() {
        val chatCode = chatCode.value.toString()
        sharedPreferencesManager.saveChatCode(chatCode)
        tutorialInviteListener!!.onStartMain()
    }

}
