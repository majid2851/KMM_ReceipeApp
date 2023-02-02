package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RecipeImgage
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import io.ktor.http.*


@OptIn(ExperimentalStdlibApi::class)
@Composable
fun RecipeView(
    recipe:Recipe
)
{
    LazyColumn(Modifier.fillMaxWidth())
    {
        item()
        {
            RecipeImgage(url = recipe.featuredImage, contentDescription = recipe.title)
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp))
                {
                    Text(text = recipe.title, modifier =
                    Modifier
                        .fillMaxWidth(.85f)
                        .wrapContentWidth(align = Alignment.Start)
                        .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h3)

                    Text(text = recipe.rating.toString(), modifier = Modifier
                        .wrapContentWidth(align = Alignment.End)
                        .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h5)
                }
                val dateTimeUtil= remember {DatetimeUtil()}
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    text="Updated at " +
                            "${dateTimeUtil.humanizeDatetime(recipe.dateUpdated)} by "
                            +recipe.publisher, style = MaterialTheme.typography.caption)

                for (item in recipe.ingredients)
                {
                    Text(text = item, modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth(), style=MaterialTheme.typography.h6)
                }
            }
        }

    }

}





















