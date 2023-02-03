package com.codingwithmitch.kmm_learning_mitch.domain.util

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo

data class DataState<T>(
    val message:GenericMessageInfo?=null,
    val data:T?=null,
    val isLoading:Boolean=false
)
{
    companion object
    {
        fun <T> error(message:GenericMessageInfo,):DataState<T>
        {
            return DataState(message=message)
        }
        fun <T> data(message: GenericMessageInfo ?=null,data:T ?=null):DataState<T>
        {
            return DataState(message=message,data = data)
        }
        fun <T> isLoading():DataState<T>
        {
            return DataState(isLoading =true)
        }
    }

}