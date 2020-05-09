package com.anibalbastias.androidranduser.domain.usecase

import com.anibalbastias.androidranduser.domain.model.DomainUserResult
import com.anibalbastias.androidranduser.domain.repository.DatabaseRepository
import com.anibalbastias.library.base.data.coroutines.ResultUseCase
import kotlinx.coroutines.Dispatchers

open class SaveFavoriteUserUseCase(private val databaseRepository: DatabaseRepository) :
    ResultUseCase<DomainUserResult, Boolean>(
        backgroundContext = Dispatchers.IO,
        foregroundContext = Dispatchers.Main
    ) {
    override suspend fun executeOnBackground(params: DomainUserResult): Boolean? {
        databaseRepository.saveFavoriteUser(user = params)
        return true
    }
}