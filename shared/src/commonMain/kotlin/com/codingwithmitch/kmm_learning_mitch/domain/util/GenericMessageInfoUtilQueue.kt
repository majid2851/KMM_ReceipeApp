package com.codingwithmitch.kmm_learning_mitch.domain.util

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo

class GenericMessageInfoUtilQueue
{

    fun doesMessageAlready(
        queue:Queue<GenericMessageInfo>,
        messageInfo:GenericMessageInfo
    ):Boolean
    {
        for (item in queue.items)
        {
            if (item.id==messageInfo.id)
            {
                return true
            }
        }
        return false

    }
}
