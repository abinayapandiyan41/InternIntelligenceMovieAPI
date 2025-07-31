package com.internintelligence.movieapi.controller;

import com.internintelligence.movieapi.model.Movie;
import com.internintelligence.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    // Optional test endpoint
    @GetMapping("/sample")
    public Movie getSampleMovie() {
        Movie movie = new Movie();
        movie.setTitle("Leo");
        movie.setDirector("Lokesh Kanagaraj");
        movie.setReleaseYear(2023);
        movie.setGenre("Action");
        movie.setImdbRating(8.5);
        return movie;
    }
}
