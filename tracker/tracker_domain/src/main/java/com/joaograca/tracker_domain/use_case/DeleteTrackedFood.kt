package com.joaograca.tracker_domain.use_case

import com.joaograca.tracker_domain.model.TrackedFood
import com.joaograca.tracker_domain.repository.TrackerRepository
import javax.inject.Inject

class DeleteTrackedFood @Inject constructor(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        return repository.deleteTrackedFood(trackedFood)
    }
}