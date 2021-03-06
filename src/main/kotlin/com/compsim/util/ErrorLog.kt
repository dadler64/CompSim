package com.compsim.util

import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.util.*

object ErrorLog {
    private var log: PrintWriter? = null
    private const val logDelim = "\n-----\n"
    private var logOpen = false

    private fun logTimeStamp() {
        if (!logOpen) {
            logInit()
        }

        if (log != null) {
            log!!.write(Date(Calendar.getInstance().timeInMillis).toString() + ": ")
        }
    }

    fun logError(message: String) {
        if (!logOpen) {
            logInit()
        }

        if (log != null) {
            logTimeStamp()
            log!!.write(message)
            log!!.write(logDelim)
        }
    }

    fun logError(var0: Exception) {
        if (!logOpen) {
            logInit()
        }

        if (log != null) {
            logTimeStamp()
            var0.printStackTrace(log)
            log!!.write(logDelim)
        }
    }

    private fun logInit() {
        if (!logOpen) {
            try {
                log = PrintWriter(FileWriter("pennsim_errorlog.txt"), true)
                logOpen = true
            } catch (var1: IOException) {
                log = null
                logOpen = false
            }
        }

    }

    fun logClose() {
        if (log != null) {
            log!!.close()
            logOpen = false
        }
    }
}
