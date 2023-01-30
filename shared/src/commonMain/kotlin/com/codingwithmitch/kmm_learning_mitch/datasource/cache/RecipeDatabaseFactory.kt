package com.codingwithmitch.kmm_learning_mitch.datasource.cache

import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import com.codingwithmitch.kmmlearningmitch.datasource.cache.Recipe_Entity
import com.squareup.sqldelight.db.SqlDriver

class RecipeDatabaseFactory(
    private val driverFactory:DriverFactory
)
{
    fun createDatabase():RecipeDB
    {
        return RecipeDB(driverFactory.createDriver())
    }


}
expect class DriverFactory{
    fun createDriver():SqlDriver
}

fun Recipe_Entity.toRecipe():Recipe
{
    val datetimeUtil=DatetimeUtil()
    return Recipe(
        id=id.toInt(),
        title=title,
        publisher=publisher,
        featuredImage =featured_image,
        rating=rating.toInt(),
        sourceUrl = source_url,
        ingredients = ingredients.convertIngeridientToList(),
        dateUpdated = datetimeUtil.toLocalDate(date_updated),
        dateAdded = datetimeUtil.toLocalDate(date_added),

    )

}
fun List<Recipe_Entity>.toRecipeList():List<Recipe>
{
    return map{it.toRecipe()}
}
/*"Carrot,Potato,Chicken,...."*/

fun List<String>.convertIngeridientToString():String
{
    val ingridientString=StringBuilder()
    for (ingredient in this)
    {
        ingridientString.append("$ingredient")
    }
    return ingridientString.toString()
}

fun String.convertIngeridientToList():List<String>
{
    val list:ArrayList<String> = ArrayList()
    for (ingeridients in split(","))
    {
        list.add(ingeridients)
    }

    return list
}
