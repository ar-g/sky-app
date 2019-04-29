package arg.skyscanner.features.journeys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import arg.skyscanner.R
import arg.skyscanner.api.SkyScannerService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_journeys.*
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDateTime
import org.threeten.bp.temporal.TemporalAdjusters

class JourneysActivity : AppCompatActivity() {

    lateinit var adapter: JourneyAdapter
    lateinit var journeyOperations: JourneyOperations
    lateinit var pollJourneysSubscription: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journeys)

        adapter = JourneyAdapter()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        journeyOperations = JourneyOperations(SkyScannerService.instance, JourneyMapper(applicationContext))

        val originPlace = "EDI"
        val destinationPlace = "LHR"
        val cabinclass = "Economy"
        val adults = "1"
        val nextMonday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY))
        val inboundDate = JourneyFormatter.formatApiDate(nextMonday)
        val nextTuesday = nextMonday.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
        val outboundDate = JourneyFormatter.formatApiDate(nextTuesday)
        val datesInterval = JourneyFormatter.formatFilterDates(nextMonday, nextTuesday)

        tvFromTo.text = JourneyFormatter.formatFromTo(originPlace, destinationPlace)
        tvFilter.text = JourneyFormatter.formatFilter(
            datesInterval,
            getString(R.string.journey_adults, adults),
            cabinclass
        )

        pollJourneysSubscription = journeyOperations.pollJourneysStream(originPlace, destinationPlace, inboundDate, outboundDate, adults, cabinclass)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val (journeysVM, updatesComplete) = it
                    adapter.submitList(journeysVM)

                    if (!updatesComplete){
                        tvResults.text = getString(R.string.journey_results_and_loading, journeysVM.size.toString())
                    } else {
                        tvResults.text = getString(R.string.journey_results, journeysVM.size.toString())
                    }
                },
                {
                    showToast(it.toString())
                }
            )
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        pollJourneysSubscription.dispose()
    }
}


