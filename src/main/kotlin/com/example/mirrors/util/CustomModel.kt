package com.example.mirrors.util

class CustomModel {
    private val bundle = HtmlBundle()


    fun setLanguage(lang: String) {
        bundle.lang(lang)
    }

    fun setCharset(charset: String) {
        bundle.charset(charset)
    }

    fun insertWithEntries(entries: Set<Map.Entry<Any, Any>>) {
        for (entry in entries) {
            bundle.addBody(bundle.insertAsP(entry.key.toString()))
            bundle.addBody(bundle.insertAsP(entry.value.toString()))
        }
    }

    fun getHtml(): String {
        bundle.lang("zh-CN")
        bundle.charset("UTF-8")
        bundle.addHead("<title>Mirrors</title>")
        bundle.addStyle(
            ":root {\n\t\t\t--color: #111;\n\t\t\t--background-color: #fff;\n\t\t}"
        )
        bundle.addStyle(
            "@media (prefers-color-scheme: dark){\n\t\t\t:root {\n\t\t\t\t--color: #eee;\n\t\t\t\t--background-color: #111;\n\t\t\t}\n\t\t}"
        )
        bundle.addStyle(
            "body {\n\t\t\tpadding: 25px;\n\t\t\tbackground-color: var(--background-color);\n\t\t}"
        )
        bundle.addStyle(
            "p {\n\t\t\tfont-size: 20px;\n\t\t\tmargin-top: 0;\n\t\t\tcolor: var(--color);\n\t\t}"
        )
        bundle.addScript("document.title += \"\\t\" + document.getElementsByTagName(\"p\").length / 2;")

        return bundle.bundle()
    }


}