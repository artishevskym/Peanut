package com.artishevskym.peanut.test

import android.os.Bundle

import androidx.test.runner.MonitoringInstrumentation

import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberInstrumentationCore

@CucumberOptions(
    features = ["features"],
    glue = ["com.artishevskym.peanut.test.steps"]
)
class CucumberInstrumentationRunner : MonitoringInstrumentation() {

    private val cucumberInstrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        cucumberInstrumentationCore.create(arguments)
        start()
    }

    override fun onStart() {
        super.onStart()
        waitForIdleSync()
        cucumberInstrumentationCore.start()
    }
}
