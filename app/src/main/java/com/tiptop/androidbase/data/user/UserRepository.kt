package com.tiptop.androidbase.data.user

import com.tiptop.androidbase.data.BaseRepository
import io.reactivex.Flowable
import javax.inject.Inject

interface UserRepository {

    /**
     * Returns a Flowable with the user data.
     */
    fun fetchUserData(): Flowable<UserData>
}

class UserRepositoryImpl @Inject constructor(
    //Add any injectable dependencies here, i.e. data sources
): UserRepository, BaseRepository() {

    override fun fetchUserData(): Flowable<UserData> {
        return Flowable.just(UserData("user1", "Tip Top"))
    }
}