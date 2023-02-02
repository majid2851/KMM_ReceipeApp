package com.codingwithmitch.kmm_learning_mitch.android.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenericDialog(
    title:String,
    description:String?=null
)
{
    AlertDialog(
        onDismissRequest = {},
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
            Button(modifier = Modifier.padding(3.dp), onClick ={})
            {
                Text(text = "Cancel", style = MaterialTheme.typography.button)
            }

          Button(modifier = Modifier.padding(3.dp), onClick ={})
          {
              Text(text = "OK", style = MaterialTheme.typography.button)
          }


          }



        }
    )
}