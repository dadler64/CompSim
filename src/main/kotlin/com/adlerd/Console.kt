package com.adlerd

import java.util.*

class Console {
    init {
        throw UnsupportedOperationException("com.adlerd.Console is meant to be used statically.")
    }

    companion object {
        private val consoles = LinkedList<PrintableConsole>()

        fun registerConsole(printableConsole: PrintableConsole) {
            consoles.add(printableConsole)
        }

        fun println(output: String) {
            if (CompSim.isGraphical) {
                val iterator = consoles.iterator()

                while (iterator.hasNext()) {
                    iterator.next().print("$output\n")
                }
            } else {
                println(output)
            }

        }

        fun clear() {
            if (CompSim.isGraphical) {
                val iterator = consoles.iterator()

                while (iterator.hasNext()) {
                    iterator.next().clear()
                }
            }

        }
    }

    interface PrintableConsole {
        fun print(message: String)

        fun clear()
    }
}