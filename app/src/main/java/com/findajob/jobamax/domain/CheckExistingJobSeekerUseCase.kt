package com.findajob.jobamax.domain

import com.findajob.jobamax.base.functional.Either
import com.findajob.jobamax.base.interactor.UseCase
import com.findajob.jobamax.data.remote.AuthRepository
import com.findajob.jobamax.model.User
import com.parse.ParseObject

class CheckExistingJobSeekerUseCase constructor(private val repo: AuthRepository) : UseCase<ParseObject, User>() {
    override suspend fun run(params: User): Either<Throwable, ParseObject> = repo.checkExistingJobSeeker(params)

    companion object {
        fun execute(useCase: CheckExistingJobSeekerUseCase, params: User, onSuccess: (parseUser: ParseObject) -> Unit, onError: (Throwable) -> Unit) {
            useCase(params) { either ->
                either.either(
                    { onError.invoke(it) },
                    { onSuccess.invoke(it) })
            }
        }
    }
}