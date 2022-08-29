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
        val i = File("$uploads\\" + f.originalFilename)
        try {
            println(i.path)
            i.createNewFile()
            i.writeBytes(f.bytes)
        } catch (e: Exception) {
            throw e
        }
    }

    fun upload(fs: Array<MultipartFile>) {
        try {
            for (f in fs) {
                upload(f)
            }
        } catch (e: Exception) {
            throw e
        }
    }

}