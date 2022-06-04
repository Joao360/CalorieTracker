package com.joaograca.tracker_domain.use_case

import com.joaograca.tracker_domain.model.TrackableFood
import com.joaograca.tracker_domain.repository.TrackerRepository
import javax.inject.Inject

class SearchFood @Inject constructor(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }

        return repository.searchFood(query.trim(), page, pageSize)
    }
}