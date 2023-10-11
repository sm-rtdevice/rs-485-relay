package com.smartdevice.relaymanagement.enums

enum class ModBusFunctionCode(val value: Byte) {
    READ_COILS(0x01.toByte()),
    READ_DISCRETE_INPUTS(0x02.toByte()),
    READ_HOLDING_REGISTERS(0x03.toByte()),
    READ_INPUT_REGISTERS(0x04.toByte()),
    WRITE_SINGLE_COIL(0x05.toByte()),
    WRITE_SINGLE_REGISTER(0x06.toByte()),
    WRITE_MULTIPLE_COILS(0x0F.toByte()),
    WRITE_MULTIPLE_REGISTERS(0x10.toByte()),
    READ_FILE_RECORD(0x14.toByte()),
    WRITE_FILE_RECORD(0x15.toByte()),
    MASK_WRITE_REGISTER(0x16.toByte()),
    READ_WRITE_MULTIPLE_REGISTERS(0x17.toByte()),
    READ_FIFO_QUEUE(0x18.toByte()),
    ENCAPSULATED_INTERFACE_TRANSPORT(0x2B.toByte()),

    // serial line only
    READ_EXCEPTION_STATUS(0x07.toByte()),
    DIAGNOSTICS(0x08.toByte()),
    GET_COMM_EVENT_COUNTER(0x0B.toByte()),
    GET_COMM_EVENT_LOG(0x0C.toByte()),
    REPORT_SLAVE_ID(0x11.toByte()),

    // not specified in modbus protocol
    UNKNOWN(0xFF.toByte());
}
