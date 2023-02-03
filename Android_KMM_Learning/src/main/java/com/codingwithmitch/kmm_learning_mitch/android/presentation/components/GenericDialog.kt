package com.codingwithmitch.kmm_learning_mitch.android.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkkmm.domain.model.NegativeAction
import com.codingwithmitch.food2forkkmm.domain.model.PositiveAction

@Composable
fun GenericDialog(
    title:String,
    onDismiss:(()->Unit)?,
    description:String?=null,
    positiveAction:PositiveAction?,
    negativeAction:NegativeAction?,
    onRemoveHeadFromQueue:()->Unit
)
{
    AlertDialog(
        onDismissRequest = {
            onDismiss?.invoke()
            onRemoveHeadFromQueue()
        },
        text = {
           if (description!=null)
           {
               Text(text = description, style = MaterialTheme.typography.body1)
           }
        },
        title = {
            if (title!= null)
            {
                Text(text = title, style = MaterialTheme.typography.h5)
            }
        },
        buttons = {
          Row(
              Modifier
                  .fillMaxWidth()
                  .padding(6.dp), horizontalArrangement = Arrangement.End)
          {
            if (negativeAction!=null)
            {
                Button(modifier = Modifier.padding(3.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
                    onClick ={
                    negativeAction.onNegativeAction()
                    onRemoveHeadFromQueue()
                })
                {
                    Text(text = negativeAction.negativeBtnTxt, style = MaterialTheme.typography.button)
                }
            }

            if (positiveAction!=null)
            {
                Button(modifier = Modifier.padding(3.dp), onClick ={
                    positiveAction.onPositiveAction()
                    onRemoveHeadFromQueue()
                })
                {
                    Text(text = positiveAction.positiveBtnTxt, style = MaterialTheme.typography.button)
                }


            }
            }




        }
    )
}