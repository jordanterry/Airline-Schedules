package com.flyingandroid.fsscheduler.planner

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.flyingandroid.fsscheduler.Airlines
import com.flyingandroid.fsscheduler.DaggerFlightAwareComponent
import com.flyingandroid.fsscheduler.billing.DaggerBillingComponent
import com.flyingandroid.fsscheduler.networking.DaggerNetworkingComponent
import com.flyingandroid.schedules.DaggerScheduleComponent
import com.flyingandroid.schedules.Schedules
import com.jakewharton.mosaic.Color
import com.jakewharton.mosaic.Text
import com.jakewharton.mosaic.runMosaic
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.jline.reader.EndOfFileException
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.UserInterruptException
import org.jline.terminal.TerminalBuilder


fun main() = runMosaic {
    val billingComponent = DaggerBillingComponent.factory().create()
    val networkingComponent = DaggerNetworkingComponent.factory().create()
    val flightAwareComponent = DaggerFlightAwareComponent.factory().create(networkingComponent, billingComponent)
    val schedules: Schedules = DaggerScheduleComponent.factory().create(flightAwareComponent).schedules()
    val airlines: Airlines = flightAwareComponent.airlines()

    var airlineName by mutableStateOf<String?>(null)

    val terminal = TerminalBuilder.terminal()
    setContent {
        Text("Enter ICAO Name", Color.White, Color.Green)
        Text("")
        airlineName?.let { Text(it) } ?: Text("No Airline")
    }

    withContext(IO) {
        val lineReader: LineReader = LineReaderBuilder.builder()
            .terminal(terminal)
            .build()
        while (true) {
            var icao: String? = null
            try {
                icao = lineReader.readLine("Enter Airline ICAO > ")
            } catch (e: UserInterruptException) {
                // Ignore
            } catch (e: EndOfFileException) {
                break
            }
            icao?.let { icao ->
                val airline = airlines.byIcao(icao)
                airlineName = airline.name
            }
        }
    }
}