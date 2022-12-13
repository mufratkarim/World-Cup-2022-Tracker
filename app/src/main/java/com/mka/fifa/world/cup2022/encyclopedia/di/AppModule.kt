package com.mka.fifa.world.cup2022.encyclopedia.di

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.WorldCupApi
import com.mka.fifa.world.cup2022.encyclopedia.data.repository.WorldCupRepoImpl
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesWorldCupApi(): WorldCupApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WorldCupApi::class.java)
    }

    @Provides
    @Singleton
    fun providesWorldCupRepository(api: WorldCupApi): WorldCupRepository{
        return WorldCupRepoImpl(api)
    }
}