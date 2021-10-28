package com.project.faily.ui.home





import androidx.lifecycle.ViewModel
import com.project.faily.data.entities.User
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.repository.home.HomeRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class HomeViewModel(private val repository: HomeRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){

    var homeListener: HomeListener? = null


    fun callQuestion() {

        Coroutines.main {

            try{

                val response = repository.todayQuestion()

            }catch (e:Exception){
                homeListener!!.onFailure(e.message!!)
            }
        }
    }

    fun startLogin() {

        Coroutines.main {

            try {


                val loginResponse = repository.login(User(user_email = "starku2249@gachon.ac.kr", user_pw = "@@qhsdml35906"))

                if(loginResponse.isSuccess){
                    sharedPreferencesManager.saveJwtToken(loginResponse.jwt_token)
                    if(loginResponse.group_code.isNotEmpty()){
                        sharedPreferencesManager.saveChatCode(loginResponse.group_code)
                        return@main
                    }
                    homeListener!!.onFailure(loginResponse.message)
                    return@main
                }
                homeListener!!.onFailure(loginResponse.message)

            }catch (e:Exception){
                homeListener!!.onFailure(e.message!!)
            }
        }
    }

    fun homeCall() {
        Coroutines.main {

            try{

                val response = repository.home()

                if (response.isSuccess){
                    homeListener!!.onHomeCallSuccess(response.result)
                    return@main
                }
                homeListener!!.onFailure(response.message)

            }catch (e:Exception){
                homeListener!!.onFailure(e.message!!)
            }
        }
    }

}