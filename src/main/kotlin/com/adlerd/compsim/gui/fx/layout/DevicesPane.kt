package com.adlerd.compsim.gui.fx.layout

import com.adlerd.compsim.core.Machine
import javafx.scene.control.TitledPane


class DevicesPane(machine: Machine): TitledPane() {

    init {
        this.text = "Devices"
        this.isCollapsible = false
        this.isAnimated = false
    }
}