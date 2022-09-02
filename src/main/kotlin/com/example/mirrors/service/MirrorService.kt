package com.example.mirrors.service

import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.io.IOException
import java.lang.NullPointerException
import java.util.*
import javax.annotation.Resource

@Service
class MirrorService {

    @Resource(name = "mirrors")
    private lateinit var mirrors: JsonObject


    fun get(i: Int?): JsonObject {
        try {
            val temp = mirrors["$i"].asJsonObject
            temp.remove("datetime")
            return temp
        } catch (e: Exception) {
            throw e
        }
    }

    fun getLast(): JsonObject {
        try {
            return mirrors["${mirrors.size() - 1}"].asJsonObject
        } catch (e: Exception) {
            println("call?")
            throw e
        }
    }

    fun getCount(): Int {
        return mirrors.size()
    }

    fun getLastIndex(): Int {
        return if (mirrors.size() != 0) mirrors.size() - 1 else 0
    }

    fun append(param: String) {
        try {
            if (param.isNotEmpty()) {
                synchronized(this) {
                    val json = JsonObject()
                    val position = mirrors.size()
                    json.addProperty("position", position - 1)
                    json.addProperty("datetime", "${Date()}")
                    json.addProperty("param", param)
                    mirrors.add("$position", json)
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }
}