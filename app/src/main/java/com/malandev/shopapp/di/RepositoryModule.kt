package com.malandev.shopapp.di

import com.malandev.shopapp.store.data.repository.ProductRepositoryImpl
import com.malandev.shopapp.store.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(impl:ProductRepositoryImpl):ProductsRepository
}