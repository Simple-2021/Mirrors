package com.example.mirrors.service

import org.apache.commons.logging.LogFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import javax.annotation.Resource

@Service
class UploadService {
    @Resource(name = "upload")
    private lateinit var uploads: String

    fun upload(file: MultipartFile) {
        val temp = File("$uploads/" + file.originalFilename)
        val parent = File(temp.parent)
        if (!parent.exists()) {
            parent.mkdir()
        }
        if (!temp.exists()) {
            temp.createNewFile()
            temp.writeBytes(file.bytes)
        } else {
            val info = LogFactory.getLog(javaClass)
            info.info("Existed:\t${temp.path}")
        }
    }

    fun upload(fs: Array<MultipartFile>) {
        for (f in fs) {
            upload(f)
        }
    }

}