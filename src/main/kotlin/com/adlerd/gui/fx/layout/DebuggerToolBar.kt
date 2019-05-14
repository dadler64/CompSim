package com.adlerd.gui.fx.layout

import com.adlerd.Machine
import com.adlerd.tc.gui.control.ToolbarButton
import com.adlerd.tc.gui.control.ToolbarSeparator
import javafx.scene.control.ToolBar
import javafx.scene.control.Tooltip


class DebuggerToolBar(machine: Machine): ToolBar() {

    val showExecBtn = ToolbarButton("showExecBtn", Tooltip("Scroll to Point of Execution"))
    val stepNextBtn = ToolbarButton("stepNextBtn", Tooltip("Step to Next Line"))
    val stepNextBPBtn = ToolbarButton("stepNextBPBtn", Tooltip("Step to Next BreakPoint"))
    val contExecBtn = ToolbarButton("contExecBtn", Tooltip("Continue With Execution"))

    init {
        this.minHeight = 32.0
        this.prefHeight = 32.0
        this.maxHeight = 32.0


        this.items.addAll(showExecBtn, ToolbarSeparator(), stepNextBtn, stepNextBPBtn, contExecBtn)

//        for (item in this.items) {
//            item.isDisabled = true
//        }
    }
}