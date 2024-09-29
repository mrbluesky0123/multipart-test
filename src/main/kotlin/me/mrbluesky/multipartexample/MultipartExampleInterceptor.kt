package me.mrbluesky.multipartexample

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class MultipartExampleInterceptor(
    val mapper: ObjectMapper
): HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val exampleMap = mutableMapOf("aaaa" to "11111", "bbbb" to "22222")
        println("@@@@@ ${mapper.writeValueAsString(exampleMap)}")
        val requestMap = mutableMapOf<String, String>()
        request.parameterMap.forEach { key, value ->
            if(value.size > 1) {
                throw RuntimeException("무언가 잘못됨")
            }
            requestMap[key] = value[0]
        }
        println("##### ${mapper.writeValueAsString(request.parameterMap)}")
        println("##### ${mapper.writeValueAsString(requestMap)}")
        println("##### MIME: ${request.contentType}")
        println("##### ${request.parameterMap as MutableMap<*, *>}")
        return super.preHandle(request, response, handler)
    }
}