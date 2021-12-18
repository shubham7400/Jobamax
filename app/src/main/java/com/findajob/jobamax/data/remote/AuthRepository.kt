package com.findajob.jobamax.data.remote

import android.content.Context
import com.findajob.jobamax.base.functional.Either
import com.findajob.jobamax.base.interactor.UseCase
import com.findajob.jobamax.base.isNetworkConnected
import com.findajob.jobamax.model.User
import com.findajob.jobamax.util.ParseQueryEmptyThrowable
import com.parse.ParseObject
import com.parse.ParseQuery
import javax.inject.Inject

class NoInternetException : Throwable() {
    companion object {
        const val MSG = "Device is not connected to the internet."
    }

    override val message: String
        get() = MSG
}

interface AuthRepository {
    // Factory is responsible to provide AuthRepository instance
    object Factory {
        fun getInstance(context: Context): Either<Throwable, AuthRepository> =
            AuthRepositoryImpl.getInstance(context)
    }

    suspend fun checkExistingRecruiter(user: User): Either<Throwable, ParseObject>

    suspend fun checkExistingJobSeeker(user: User): Either<Throwable, ParseObject>
}


class AuthRepositoryImpl private constructor(private val context: Context) : AuthRepository {
    companion object {
        //Store in L3 Cache, benefit that any thread will get the same instance. Also, it will be instantiated one time for application life scope
        @Volatile
        private var instance: AuthRepository? = null

        fun getInstance(context: Context): Either<Throwable, AuthRepository> {
            return try {
                if (instance == null) {
                    instance = AuthRepositoryImpl(context)
                }
                Either.Right(instance!!)
            } catch (e: Exception) {
                e.printStackTrace()
                Either.Left(e)
            }
        }
    }

    override suspend fun checkExistingRecruiter(user: User): Either<Throwable, ParseObject> {
        return try {
            if (context.isNetworkConnected()) {
                val query = ParseQuery.getQuery<ParseObject>("Recruiter")
                if (user.phoneNumber.isNotEmpty())
                    query.whereEqualTo("phoneNumber", user.phoneNumber)
                if (user.email.isNotEmpty())
                    query.whereEqualTo("email", user.email)
                query.whereEqualTo("loginType", user.loginType)
                val result = query.find().firstOrNull()
                if (result == null) {
                    Either.Left(ParseQueryEmptyThrowable())
                } else {
                    Either.Right(result)
                }
            } else {
                Either.Left(NoInternetException())
            }
        } catch (e: Exception) {
            Either.Left(e)
        }
    }

    override suspend fun checkExistingJobSeeker(user: User): Either<Throwable, ParseObject> {
        return try {
            if (context.isNetworkConnected()) {
                val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
                if (user.phoneNumber.isNotEmpty())
                    query.whereEqualTo("phoneNumber", user.phoneNumber)
                if (user.email.isNotEmpty())
                    query.whereEqualTo("email", user.email)
                query.whereEqualTo("loginType", user.loginType)
                val list = query.find().firstOrNull()
                if (list == null) {
                    Either.Left(ParseQueryEmptyThrowable())
                } else {
                    Either.Right(list)
                }
            } else {
                Either.Left(NoInternetException())
            }
        } catch (e: Exception) {
            Either.Left(e)
        }
    }
}

