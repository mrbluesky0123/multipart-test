package me.mrbluesky.multipartexample

import jakarta.servlet.MultipartConfigElement
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.unit.DataSize
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver

@Configuration
class MultipartConfig(
    @Value("\${file.multipart.maxUploadSize:10485760}")
    val maxUploadSize: Long = 10485760,

    @Value("\${file.multipart.maxUploadSizePerFIle:10485760")
    val maxUploadSizePerFile: Long = 10485760
) {

    @Bean
    fun multipartResolver(): MultipartResolver {
        return StandardServletMultipartResolver()
    }

    fun multipartConfigElement(): MultipartConfigElement {
        val multipartConfigFactory = MultipartConfigFactory()
        multipartConfigFactory.setMaxRequestSize(DataSize.ofBytes(maxUploadSize))
        multipartConfigFactory.setMaxFileSize(DataSize.ofBytes(maxUploadSizePerFile))
        return multipartConfigFactory.createMultipartConfig()
    }



}