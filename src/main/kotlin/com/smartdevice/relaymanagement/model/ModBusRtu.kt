package com.smartdevice.relaymanagement.model

import com.smartdevice.relaymanagement.enums.ModBusFunctionCode

class ModBusRtu {

    fun createCommand(slaveId: Byte, func: ModBusFunctionCode, channel: Byte, state: Byte): ByteArray {
        val buffer = ArrayList<Byte>()
        buffer.add(slaveId)
        buffer.add(func.value)
        buffer.add(0x00.toByte())
        buffer.add(channel)
        buffer.add(state)
        buffer.add(0x00.toByte())

        val checkSum = ModBusCrc16.crcBytes(buffer.toByteArray())

        buffer.add(checkSum[0])
        buffer.add(checkSum[1])
        return buffer.toByteArray()
    }

}
