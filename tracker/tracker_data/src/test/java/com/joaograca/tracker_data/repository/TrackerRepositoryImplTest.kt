package com.joaograca.tracker_data.repository

import com.google.common.truth.Truth.assertThat
import com.joaograca.tracker_data.remote.OpenFoodApi
import com.joaograca.tracker_data.remote.malformedFoodResponse
import com.joaograca.tracker_data.remote.validFoodResponse
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalCoroutinesApi::class)
internal class TrackerRepositoryImplTest {

    private lateinit var repository: TrackerRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: OpenFoodApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(OpenFoodApi::class.java)

        repository = TrackerRepositoryImpl(
            dao = mockk(relaxed = true),
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Search food, valid response, returns results`() = runTest {
        // Given
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validFoodResponse)
        )

        // When
        val result = repository.searchFood("banana", 1, 40)

        // Then
        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Search food, invalid response, returns failure`() = runTest {
        // Given
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(validFoodResponse)
        )

        // When
        val result = repository.searchFood("banana", 1, 40)

        // Then
        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Search food, malformed response, returns failure`() = runTest {
        // Given
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(malformedFoodResponse)
        )

        // When
        val result = repository.searchFood("banana", 1, 40)

        // Then
        assertThat(result.isFailure).isTrue()
    }
}