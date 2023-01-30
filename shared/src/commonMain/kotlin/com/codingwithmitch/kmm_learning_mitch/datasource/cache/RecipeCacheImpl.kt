package com.codingwithmitch.kmm_learning_mitch.datasource.cache

import android.widget.Toast
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl.Companion.RECIPE_PAGINATION_PAGE_SIZE
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import com.squareup.sqldelight.logs.LogSqliteDriver
import kotlin.math.log

class RecipeCacheImpl(
    private val recipeDb:RecipeDB,
    private val datetimeUtil: DatetimeUtil
):RecipeCache
{
    private val queries=recipeDb.recipeQueries

    override fun insert(recipe: Recipe)
    {
        queries.insertRecipe(
            id = recipe.id.toLong(),
            title = recipe.title,
            publisher = recipe.publisher,
            featured_image = recipe.featuredImage,
            rating = recipe.rating.toLong(),
            source_url = recipe.sourceUrl,
            ingredients =recipe.ingredients.convertIngeridientToString(),
            date_updated = datetimeUtil.toEpochMilliseconds(recipe.dateUpdated),
            date_added = datetimeUtil.toEpochMilliseconds(recipe.dateAdded)

        )
    }

    override fun insert(recipes: List<Recipe>)
    {
        for (recipe in recipes)
        {
            insert(recipe)
        }
    }

    override fun search(query: String, page: Int): List<Recipe>
    {
        return queries.searchRecipes(
            query=query,
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page-1)* RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toRecipeList()//
    }

    override fun getAll(page: Int): List<Recipe>
    {
        return queries.getAllRecipes(
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page-1)* RECIPE_PAGINATION_PAGE_SIZE).toLong()).executeAsList().toRecipeList()//
    }

    override fun get(recipeId: Int): Recipe?
    {
        return try
        {
            queries.getRecipeById(id = recipeId.toLong())
               .executeAsOne().toRecipe()

        }catch (e:NullPointerException){
            null

        }
    }


}