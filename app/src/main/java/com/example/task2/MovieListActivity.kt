import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.R

class MovieListActivity : AppCompatActivity() {

    private val movieList = mutableListOf<Movie>()
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnMore = findViewById<Button>(R.id.btnMore)

        // Get username from intent
        val username = intent.getStringExtra("USERNAME")

        // Initialize movie list
        initializeMovies()
        adapter = MovieAdapter(movieList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnMore.setOnClickListener {
            loadMoreMovies()
        }
    }

    private fun initializeMovies() {
        for (i in 1..10) {
            movieList.add(Movie("Movie $i", "Description of Movie $i", "Details $i", "2024-01-$i", 5.0))
        }
    }

    private fun loadMoreMovies() {
        val start = movieList.size + 1
        for (i in start..start + 4) {
            movieList.add(Movie("Movie $i", "Description of Movie $i", "Details $i", "2024-02-$i", 4.5))
        }
        adapter.notifyDataSetChanged()
    }
}
