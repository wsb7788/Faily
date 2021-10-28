package com.project.faily.data.remote.home

interface HomeListener {
    fun onFailure(message:String)
    fun onHomeCallSuccess(result: HomeInfo)


}