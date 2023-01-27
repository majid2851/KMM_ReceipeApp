package com.codingwithmitch.kmm_learning_mitch.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.ContentType.Application.Json


actual class KtorClientFactory
{
    actual fun build():HttpClient
    {
        return HttpClient(Android){
            install(JsonFeature)
            {
                serializer=KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys=true//if the server sends extra fileds,ignore
                    }
                )
            }
        }
    }
}
