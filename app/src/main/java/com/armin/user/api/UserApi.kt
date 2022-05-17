package com.armin.user.api

import com.armin.user.data.UserItem
import retrofit2.http.GET

interface UserApi {

        companion object {
            const val BASE_URL = "http://51.195.19.222:3000/"
        }

        @GET("api/v1/users")
        suspend fun getUser(): List<UserItem>

}