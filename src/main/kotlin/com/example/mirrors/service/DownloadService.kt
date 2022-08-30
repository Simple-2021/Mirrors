package com.example.mirrors.service

import com.example.mirrors.util.BundleUtils
import org.springframework.stereotype.Service
import java.io.File
import javax.annotation.Resource

@Service
class DownloadService {

    @Resource(name = "upload")
    private lateinit var uploads: String

    fun download(f: String): ByteArray {
        val i = File("$uploads/$f")
        if (i.exists() && i.isFile) {
            return i.readBytes()
        }
        return ByteArray(0)
    }

    fun target(entries: Set<Map.Entry<Any, Any>>): ByteArray {
        val util = BundleUtils()
        util.lang("zh-CN")
        util.charset("UTF-8")
        util.addHead("<title>Mirrors</title>")
        util.addStyle(
            ":root {\n\t\t\t--color: #111;\n\t\t\t--background-color: #fff;\n\t\t}"
        )
        util.addStyle(
            "@media (prefers-color-scheme: dark){\n\t\t\t:root {\n\t\t\t\t--color: #eee;\n\t\t\t\t--background-color: #111;\n\t\t\t}\n\t\t}"
        )
        util.addStyle(
            "body {\n\t\t\tpadding: 25px;\n\t\t\tbackground-color: var(--background-color);\n\t\t}"
        )
        util.addStyle(
            "p {\n\t\t\tfont-size: 20px;\n\t\t\tmargin-top: 0;\n\t\t\tcolor: var(--color);\n\t\t}"
        )
        util.addScript("document.title += \"\\t\" + document.getElementsByTagName(\"p\").length / 2;")

        for (entry in entries) {
            util.addBody(util.inP(entry))
        }
        util.addBody("")

        return util.toString().toByteArray()
    }

}