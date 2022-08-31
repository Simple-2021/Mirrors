package com.example.mirrors.util

import java.util.*

class ErrorModel(status: Any, any: Any?) {
    private var view: String

    init {
        val e = object : TreeMap<Any, Any?>() {init {
            put(status, any)
        }
        }
        val m = CustomModel()
        m.insertWithEntries(e.entries)
        view = m.getHTML()
    }

    fun toHTML(): String {
        return view
    }

    fun toByteArray(): ByteArray {
        return view.encodeToByteArray()
    }
}