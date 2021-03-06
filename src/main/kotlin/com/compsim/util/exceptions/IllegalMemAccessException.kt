package com.compsim.util.exceptions

import com.compsim.core.Word

class IllegalMemAccessException(private val addr: Int) : GenericException() {

    override val exceptionDescription: String
        get() =
            "IllegalMemAccessException accessing address " + Word.toHex(this.addr) + "\n" + "(The MPR and PSR do not permit access to this address)"
}
