package com.example.mirrors.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import javax.annotation.Resource

@Service
class UploadService {
    @Resource(name = "upload")
    private lateinit var uploads: String

    fun upload(f: MultipartFile) {
        val i = File("$uploads/" + f.originalFilename)
        if (!i.exists()) {
            i.createNewFile()
            i.writeBytes(f.bytes)
        } else {
            throw Exception()
        }
    }

    fun upload(fs: Array<MultipartFile>) {
        for (f in fs) {
            upload(f)
        }
    }

}