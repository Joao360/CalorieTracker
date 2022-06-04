package com.joaograca.tracker_domain.use_case

import com.joaograca.tracker_domain.model.TrackedFood
import com.joaograca.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class GetFoodsForDate @Inject constructor(
    private val repository: TrackerRepository
) {

    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodForDate(date)
    }
}