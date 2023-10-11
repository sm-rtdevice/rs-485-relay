package com.smartdevice.relaymanagement.model

import jssc.SerialPort
import jssc.SerialPortList

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class SerialPortConnector {
//    fun loadConfig() { // todo: load config
//    }
//
//    fun saveConfig() { // todo: save config
//    }

    fun connect(): SerialPort? {
        val serialPort = SerialPort("COM4") // linux: "/dev/ttyUSB0"

        try {
            serialPort.openPort()
            serialPort.setParams(
                SerialPort.BAUDRATE_9600,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE
            )
        } catch (ex: Exception) {
            logger.warn("Failed connect to com port")
            return null
        }

        logger.info("Success connect to com port")
        return serialPort
    }

    fun disConnect(serialPort: SerialPort?) {
        serialPort?.closePort()
    }

    fun reConnect(serialPort: SerialPort?): SerialPort? {
        disConnect(serialPort)
        return connect()
    }

    companion object {

        fun getAvailablePorts(): List<String> {
            val portNames = SerialPortList.getPortNames()
            if (portNames.isEmpty()) {
                logger.info("No available com ports found")
                return listOf()
            }
            for (portName in portNames) {
                logger.info("Available com port: $portName")
            }
            return portNames.toList()
        }
    }
}
