package com.example.mirrors.util

class BundleUtils {

    private var params = arrayOfNulls<String>(5)
    private var lang: String? = null
    private var charset: String? = null

    override fun toString(): String {
        lang ?: lang()
        charset ?: charset()
        return html(head(params[0] + style(params[1])) + body(params[2] + script(params[3])))
    }

    fun lang(any: String? = null) {
        lang = any ?: "zh-CN"
        lang = "lang=\"$lang\""
    }

    fun charset(any: String? = null) {
        charset = any ?: "UTF-8"
        charset = "\t<meta charset=\"$charset\">\n"
    }

    private fun html(any: String?): String {
        val doc = "<!DOCTYPE html>\n"
        val tag = "<html $lang>\n"
        val end = "\n</html>\n"
        return if (any.isNullOrEmpty()) "" else "$doc$tag$any$end"
    }

    private fun head(any: String?): String {
        val tag = "<head>\n"
        val end = "\n</head>\n"
        return if (any.isNullOrEmpty()) "" else if (charset.isNullOrEmpty()) "$tag$any$end" else "$tag$charset$any$end"
    }

    fun addHead(any: String?) {
        params[0] = params[0] ?: ""
        params[0] += "\t" + any + "\n"
    }

    private fun body(any: String?): String {
        val tag = "<body>\n"
        val end = "\n</body>\n"
        return if (any.isNullOrEmpty()) "" else "$tag$any$end"
    }

    fun addBody(any: String?) {
        params[2] = params[2] ?: ""
        params[2] += "\t" + any + "\n"
    }

    private fun style(any: String?): String {
        val tag = "\t<style>\n"
        val end = "\n\t</style>\n"
        return if (any.isNullOrEmpty()) "" else "$tag$any$end"
    }

    fun addStyle(any: String?) {
        params[1] = params[1] ?: ""
        params[1] += "\t\t" + any + "\n"
    }

    private fun script(any: String?): String {
        val tag = "\t<script>\n"
        val end = "\n\t</script>\n"
        return if (any.isNullOrEmpty()) "" else "$tag$any$end"
    }

    fun addScript(any: String?) {
        params[3] = params[3] ?: ""
        params[3] += "\t\t" + any + "\n"
    }


    fun inP(e: Map.Entry<Any, Any>): String {
        val key = "<p>\n\t\t${e.key}\n\t</p>\n"
        val value = "\t<p>\n\t\t${e.value}\n\t</p>"
        return key + value
    }

}