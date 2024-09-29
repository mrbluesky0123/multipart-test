package me.mrbluesky.multipartexample

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File


@RestController
@RequestMapping("/v1")
class MultipartExampleController {
    @PostMapping("/upload")
    fun addSeasonTicketPicture(
        @RequestParam file: MultipartFile,
        @RequestParam name: String,
        request: HttpServletRequest
    ): ResponseEntity<String> {
        println("#### $request ")
        println("#### $name")
        file.transferTo(File("/Users/mrbluesky/aaaaaa.png"))
        return ResponseEntity<String>(HttpStatus.OK)
    }
}