
package com.project.faily.ui.tutorial_insert




import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.entities.GroupCode
import com.project.faily.data.remote.tutorial_insert.TutorialInsertListener
import com.project.faily.data.repository.tutorial_insert.TutorialInsertRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class TutorialInsertViewModel(private val repository: TutorialInsertRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){

    var tutorialInsertListener: TutorialInsertListener? = null


    val code1: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val code2: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val code3: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val code4: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    fun checkInviteCode() {
        if(code1.value.isNullOrEmpty()||code2.value.isNullOrEmpty()||code3.value.isNullOrEmpty()||code4.value.isNullOrEmpty()){
            tutorialInsertListener!!.onCheckFailure("코드를 올바르게 입력해주세요.")
            return
        }
        enterChatRoom()

    }

    private fun enterChatRoom() {
        val code = code1.value + code2.value +code3.value +code4.value

        Coroutines.main {
            try{
                val emailAuthResponse = repository.entryChat(GroupCode(code))
                if (emailAuthResponse.isSuccess) {
                    sharedPreferencesManager.saveChatCode(code)
                    tutorialInsertListener!!.onCheckSuccess(emailAuthResponse.message)
                    return@main
                }
                tutorialInsertListener!!.onCheckFailure("실패")
            }catch (e:Exception){
                Log.d("로그",e.message!!)
                tutorialInsertListener!!.onCheckFailure(e.message!!)
            }
        }

    }


}
