package me.mrbluesky.multipartexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultipartExampleApplication

fun main(args: Array<String>) {
	runApplication<MultipartExampleApplication>(*args)
}
