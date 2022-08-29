package com.example.mirrors.service

import org.springframework.stereotype.Service
import java.io.File
import java.util.*
import javax.annotation.Resource

@Service
class DownloadService {

    @Resource(name = "upload")
    private lateinit var uploads: String

    fun download(f: String): ByteArray {
        val i = File("$uploads\\$f")
        return i.readBytes()
    }

    fun target(tree: TreeMap<Date, String>): ByteArray {
        var body = String()
        for (i in tree) {
            body += tarModel(i)
        }
        return targetModel(body).encodeToByteArray()
    }

    fun tarModel(e: MutableMap.MutableEntry<Date, String>): String {
        val key = "\t<p>${e.key}</p>\n"
        val value = "\t<p>${e.value}</p>\n"
        return key + value
    }

    fun targetModel(es: String): String {
        val params = arrayOfNulls<String>(17)
        params[0] = "<!DOCTYPE html>"
        params[1] = "<html lang=\"zh-CN\">"
        params[2] = "<head>"
        params[3] = "\t<meta charset=\"UTF-8\">"
        params[4] = "\t<title>Mirrors</title>"
        params[5] = "\t<style>"
        params[6] = "\t\tbody {padding: 25px;}"
        params[7] = "\t\tp {font-size: 20px;margin-top: 0;}"
        params[8] = "\n\t</style>"
        params[9] = "\n</head>"
        params[10] = "<body>"
        params[11] = es.trimEnd('\n')
        params[12] = "\t<script>"
        params[13] = "\t\tdocument.title += \"\\t\" + document.getElementsByTagName(\"p\").length / 2"
        params[14] = "\n\t</script>"
        params[15] = "\n</body>"
        params[16] = "\n</html>"
        var param = ""
        for (i in params) {
            param += "$i\n"
        }
        return param
    }

}