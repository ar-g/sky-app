package arg.skyscanner.features.journeys

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import arg.skyscanner.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_journey.view.*


class JourneyAdapter : RecyclerView.Adapter<JourneyViewHolder>() {
    private val differ = AsyncListDiffer<JourneyVM>(this, object : DiffUtil.ItemCallback<JourneyVM>() {
        override fun areItemsTheSame(oldItem: JourneyVM, newItem: JourneyVM): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JourneyVM, newItem: JourneyVM): Boolean {
            return oldItem.id == newItem.id
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JourneyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_journey, parent, false)
        return JourneyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: JourneyViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    fun submitList(journeys: List<JourneyVM>){
        differ.submitList(journeys)
    }
}

class JourneyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(journeyVM: JourneyVM) {
        itemView.tvOutboundTime.text = journeyVM.outboundLeg.time
        itemView.tvOutboundDescription.text = journeyVM.outboundLeg.description
        itemView.tvOutboundDirection.text = journeyVM.outboundLeg.direction
        itemView.tvOutboundDuration.text = journeyVM.outboundLeg.duration
        Glide.with(itemView.ivOutboundIcon)
            .load(journeyVM.outboundLeg.airlineIcon)
            .into(itemView.ivOutboundIcon)

        itemView.tvInboundTime.text = journeyVM.inboundLeg.time
        itemView.tvInboundDescription.text = journeyVM.inboundLeg.description
        itemView.tvInboundDirection.text = journeyVM.inboundLeg.direction
        itemView.tvInboundDuration.text = journeyVM.inboundLeg.duration
        Glide.with(itemView.ivInboundIcon)
            .load(journeyVM.inboundLeg.airlineIcon)
            .into(itemView.ivInboundIcon)

        itemView.tvPrice.text = journeyVM.price
        itemView.tvSatisfaction.text = journeyVM.satisfaction
        itemView.tvTicketAgent.text = journeyVM.ticketAgent
    }
}