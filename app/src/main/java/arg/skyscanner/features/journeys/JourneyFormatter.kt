package arg.skyscanner.features.journeys

import org.threeten.bp.Duration
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

object JourneyFormatter {
    private val timeFormatter by lazy {
        DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH)
    }

    private val sourceFormatter by lazy {
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss")
    }

    private val apiFormatter by lazy {
        DateTimeFormatter.ofPattern("uuuu-MM-dd")
    }

    private val filterDateFormatter by lazy {
        DateTimeFormatter.ofPattern("dd MMM")
    }

    fun formatDepartureArrival(departure: String, arrival: String): String {
        val formattedDeparture = LocalDateTime.parse(departure,
            sourceFormatter
        )
            .format(timeFormatter)
        val formattedArrival = LocalDateTime.parse(arrival, sourceFormatter)
            .format(timeFormatter)
        return "$formattedDeparture - $formattedArrival"
    }

    fun formatDuration(durationInMin: Long): String {
        val duration = Duration.ofMinutes(durationInMin)
        return duration.toString()
            .substring(2)
            .replace("(\\d[HMS])(?!$)".toRegex(), "$1 ")
            .toLowerCase()
    }

    fun formatDescription(originStation: String, destinationStation: String, carrier: String): String {
        return "$originStation-$destinationStation, $carrier"
    }

    fun formatPrice(price: String, currency: String): String {
        return "$currency$price"
    }

    fun formatFromTo(from: String, to: String): String {
        return "$from - $to"
    }

    fun formatFilter(dateInterval: String, adults: String, cabinClass: String): String {
        return "$dateInterval, $adults, $cabinClass"
    }

    fun formatApiDate(monday: LocalDateTime): String {
        return monday.format(apiFormatter)
    }

    fun formatFilterDates(from: LocalDateTime, to: LocalDateTime): String {
        return "${from.format(filterDateFormatter)} - ${to.format(filterDateFormatter)}"
    }

}