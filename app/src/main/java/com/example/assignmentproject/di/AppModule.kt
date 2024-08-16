package com.example.assignmentproject.di


import com.example.assignmentproject.data.api.ApiService
import com.example.assignmentproject.data.mapper.ApiMapper
import com.example.assignmentproject.data.repository.DataRepositoryImpl
import com.example.assignmentproject.domain.repository.DataRepository
import com.example.assignmentproject.domain.usecase.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiMapper(): ApiMapper {
        // Provide an implementation of ApiMapper
        return ApiMapper()
    }

    @Provides
    @Singleton
    fun provideDataRepository(apiService: ApiService, apiMapper: ApiMapper): DataRepository {
        return DataRepositoryImpl(apiService, apiMapper)
    }

    @Provides
    @Singleton
    fun provideGetDataUseCase(dataRepository: DataRepository): GetDataUseCase {
        return GetDataUseCase(dataRepository)
    }

}