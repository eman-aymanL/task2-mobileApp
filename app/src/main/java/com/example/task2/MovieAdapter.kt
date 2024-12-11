import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.R

data class Movie(val name: String, val description: String, val details: String, val publishDate: String, val rate: Double)

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.name.text = movie.name
        holder.description.text = movie.description
        holder.details.text = movie.details
        holder.publishDate.text = movie.publishDate
        holder.rate.text = "Rating: ${movie.rate}"
    }

    override fun getItemCount(): Int = movieList.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val details: TextView = itemView.findViewById(R.id.tvDetails)
        val publishDate: TextView = itemView.findViewById(R.id.tvPublishDate)
        val rate: TextView = itemView.findViewById(R.id.tvRate)
    }
}
