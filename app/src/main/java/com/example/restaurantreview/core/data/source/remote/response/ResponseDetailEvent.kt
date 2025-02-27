package com.example.restaurantreview.core.data.source.remote.response

import com.example.restaurantreview.core.data.source.model.Event

data class ResponseDetailEvent(
	val error: Boolean? = null,
	val message: String? = null,
	val event: Event? = null
)


