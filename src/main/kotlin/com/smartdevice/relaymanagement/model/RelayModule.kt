package com.smartdevice.relaymanagement.model

import com.smartdevice.relaymanagement.enums.ModBusFunctionCode
import com.smartdevice.relaymanagement.enums.RelayState
import jssc.SerialPort

class RelayModule {

    private var serialPortConnector = SerialPortConnector()
    private var serialPort: SerialPort? = null
    private val modBusRtu = ModBusRtu()
    private val slaveId: Byte = 0xFF.toByte()

    init {
        serialPort = serialPortConnector.connect()
    }

    fun setOpen(channel: Byte) {
        val serialPort = serialPort ?: return
        val command = modBusRtu.createCommand(slaveId, ModBusFunctionCode.WRITE_SINGLE_COIL, channel, RelayState.ON.value)
        serialPort.writeBytes(command)
    }

    fun setClose(channel: Byte) {
        val serialPort = serialPort ?: return
        val command = modBusRtu.createCommand(slaveId, ModBusFunctionCode.WRITE_SINGLE_COIL, channel, RelayState.OFF.value)
        serialPort.writeBytes(command)
    }

}
