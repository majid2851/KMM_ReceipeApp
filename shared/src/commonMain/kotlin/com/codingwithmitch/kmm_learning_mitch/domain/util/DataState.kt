package com.codingwithmitch.kmm_learning_mitch.domain.util

data class DataState<T>(
    val message:String?=null,
    val data:T?=null,
    val isLoading:Boolean=false
)
{
    companion object
    {
        fun <T> error(message:String,):DataState<T>
        {
            return DataState(message=message)
        }
        fun <T> data(message: String ?=null,data:T ?=null):DataState<T>
        {
            return DataState(message=message,data = data)
        }
        fun <T> isLoading():DataState<T>
        {
            return DataState(isLoading =true)
        }
    }

}