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
        if (i.exists() && i.isFile) {
            return i.readBytes()
        }
        return ByteArray(0)
    }

    fun target(tree: TreeMap<Date, String>): ByteArray {
        var body = String()
        for (i in tree) {
            body += tarModel(i)
        }
        return targetModel(body.trimEnd('\n')).encodeToByteArray()
    }

    fun tarModel(e: MutableMap.MutableEntry<Date, String>): String {
        val key = "\t<p>\n\t\t${e.key}\n\t</p>\n"
        val value = "\t<p>\n\t\t${e.value}\n\t</p>\n"
        return key + value
    }

    fun targetModel(es: String): String {
        val params = arrayOfNulls<String>(19)
        params[0] = "<!DOCTYPE html>"
        params[1] = "<html lang=\"zh-CN\">"
        params[2] = "<head>"
        params[3] = "\t<meta charset=\"UTF-8\">"
        params[4] = "\t<title>Mirrors</title>"
        params[5] = "\t<style>"
        params[6] = "\t\t:root {\n\t\t\t--color: #111;\n\t\t\t--background-color: #fff;\n\t\t}"
        params[7] =
            "\t\t@media (prefers-color-scheme: dark){\n\t\t\t:root {\n\t\t\t\t--color: #eee;\n\t\t\t\t--background-color: #111;\n\t\t\t}\n\t\t}"
        params[8] = "\t\tbody {\n\t\t\tpadding: 25px;\n\t\t\tbackground-color: var(--background-color);\n\t\t}"
        params[9] = "\t\tp {\n\t\t\tfont-size: 20px;\n\t\t\tmargin-top: 0;\n\t\t\tcolor: var(--color)\n\t\t}"
        params[10] = "\n\t</style>"
        params[11] = "\n</head>"
        params[12] = "<body>"
        params[13] = es
        params[14] = "\t<script>"
        params[15] = "\t\tdocument.title += \"\\t\" + document.getElementsByTagName(\"p\").length / 2"
        params[16] = "\n\t</script>"
        params[17] = "\n</body>"
        params[18] = "\n</html>"
        var param = ""
        for (i in params) {
            param += "$i\n"
        }
        return param
    }

}