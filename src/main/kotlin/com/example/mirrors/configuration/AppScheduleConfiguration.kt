package com.example.mirrors.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.*
import javax.annotation.Resource

@EnableScheduling
@Configuration
class AppScheduleConfiguration {

    @Resource(name = "mirrors")
    private lateinit var mirrors: LinkedList<String>

    @Scheduled(cron = "0 0 12 * * ?")
    fun clearTask() {
        if (mirrors.size > 0x1000000) {

            Thread() {
                kotlin.run {
                    var docs = "Unit"
                    for (i in 1..mirrors.size / 2) {
                        docs += "\n" + mirrors.first
                    }
                    val out = BufferedWriter(OutputStreamWriter(FileOutputStream("txt." + docs.hashCode())))
                    out.write(docs)
                    out.close()
                }
            }.start()
        }
    }

}