package com.adlerd.compsim.gui.fx.layout.tabs

import com.adlerd.compsim.core.Machine
import com.adlerd.compsim.gui.fx.layout.DevicesPane
import com.adlerd.compsim.gui.fx.layout.MemoryPane
import com.adlerd.compsim.gui.fx.layout.RegistersPane
import javafx.scene.control.Tab
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

class DebuggerTab(machine: Machine): Tab() {

    val memoryPane = MemoryPane(machine)
    val registersPane = RegistersPane(machine)
    val devicesPane = DevicesPane(machine)

    val leftVBox = VBox()
    val rootPane = BorderPane()

    init {
        this.text = "Debugger"
        this.isClosable = false

        VBox.setVgrow(registersPane, Priority.NEVER)
        VBox.setVgrow(devicesPane, Priority.ALWAYS)

        leftVBox.minWidth = LEFT_VBOX_WIDTH
        leftVBox.prefWidth = LEFT_VBOX_WIDTH
        leftVBox.maxWidth = LEFT_VBOX_WIDTH
        leftVBox.children.addAll(registersPane, devicesPane)

        rootPane.left = leftVBox
        rootPane.center = memoryPane

        this.content = rootPane
    }

    companion object {
        private const val LEFT_VBOX_WIDTH = 260.0
    }
}