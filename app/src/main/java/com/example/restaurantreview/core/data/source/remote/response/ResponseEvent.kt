package com.example.restaurantreview.core.data.source.remote.response

import com.example.restaurantreview.core.data.source.model.ListEventsItem

data class ResponseEvent(
	val listEvents: List<ListEventsItem?>? = null,
	val error: Boolean? = null,
	val message: String? = null
)


