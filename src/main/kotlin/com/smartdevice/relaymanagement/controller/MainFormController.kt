package com.smartdevice.relaymanagement.controller

import com.smartdevice.relaymanagement.model.RelayModule
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.ToggleGroup

open class MainFormController {

    private val relay: RelayModule = RelayModule()

    @FXML
    private lateinit var infoLabel: Label

    @FXML
    private lateinit var module: ToggleGroup

    @FXML
    protected fun onButtonClick() {
        val selected = module.toggles.indexOf(module.selectedToggle)
        infoLabel.text = "relay channel $selected is on"
        relay.setOpen(selected.toByte())
    }

    @FXML
    protected fun offButtonClick() {
        val selected = module.toggles.indexOf(module.selectedToggle)
        infoLabel.text = "relay channel $selected is off"
        relay.setClose(selected.toByte())
    }
}
