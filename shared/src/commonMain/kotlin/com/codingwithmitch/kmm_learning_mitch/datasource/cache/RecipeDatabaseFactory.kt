package com.codingwithmitch.kmm_learning_mitch.datasource.cache

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