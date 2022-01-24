package com.rail.road.operations

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.rail.road.operations")
		.start()
}

