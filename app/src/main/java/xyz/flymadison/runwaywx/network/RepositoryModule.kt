package xyz.flymadison.runwaywx.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AwcRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAwcRepository(
        impl: AwcRepositoryImpl
    ) : AwcRepository
}