package com.tiptop.androidbase.data.sample

import com.tiptop.androidbase.data.BaseRepository
import io.reactivex.Flowable
import javax.inject.Inject

interface SampleRepository {

    /**
     * Returns a Flowable with the sample data.
     */
    fun fetchSampleData(): Flowable<SampleData>
}

class SampleRepositoryImpl @Inject constructor(
    //Add any injectable dependencies here, i.e. data sources
): SampleRepository, BaseRepository() {

    override fun fetchSampleData(): Flowable<SampleData> {
        return Flowable.just(SampleData("sampleData1", "Sample Data"))
    }
}