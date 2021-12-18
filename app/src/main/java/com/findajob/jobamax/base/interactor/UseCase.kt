package com.findajob.jobamax.base.interactor

import com.findajob.jobamax.base.functional.Either
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    private val mainJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

    abstract suspend fun run(params: Params): Either<Throwable, Type>

    operator fun invoke(params: Params, onResult: (Either<Throwable, Type>) -> Unit = {}) = uiScope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }

    class None
}