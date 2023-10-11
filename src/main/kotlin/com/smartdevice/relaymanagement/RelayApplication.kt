package com.smartdevice.relaymanagement

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class RelayApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(RelayApplication::class.java.getResource("main-form-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Relay RS-485 management"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(RelayApplication::class.java)
}
