package com.project.faily.ui.home





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.repository.home.HomeRepository
import com.project.faily.util.Coroutines

class HomeViewModel(private val repository: HomeRepository): ViewModel(){

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

}