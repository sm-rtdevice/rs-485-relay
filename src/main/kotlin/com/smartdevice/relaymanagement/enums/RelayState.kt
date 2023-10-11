package com.smartdevice.relaymanagement.enums

enum class RelayState(val value: Byte) {
    ON(0xFF.toByte()),
    OFF(0x00.toByte())
}
