package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.FoodCategory

@Composable
fun FoodCategoryChip(
    category:String,
    isSelected:Boolean=false,
    onSelectedCategoryChanged:(String)->Unit
)
{
    Surface(modifier = Modifier.padding(8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected==true) Color.LightGray
                else MaterialTheme.colors.primaryVariant,
            )
    {
        Row(Modifier.clickable {
            onSelectedCategoryChanged(category)
        })
        {
            Text(category, style = MaterialTheme.typography.body2,
                color = Color.White, modifier = Modifier.padding(8.dp))
        }


    }





}