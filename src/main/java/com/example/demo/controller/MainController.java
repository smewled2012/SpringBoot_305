package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.movieRepository.ActorRepository;
import com.example.demo.movieRepository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {


    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;




    @RequestMapping("/")
    public String index(Model model){

        // first create an actor and then a movie
        Actor actor= new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealName("Sandra Mae Bullowski");
        Set<Actor> actors = new HashSet<>();
        actors.add(actor);
        // create a movie
        Movie movie =new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDesciptions("About Emojis......");

        Movie anotherMovie = new Movie();
        anotherMovie.setTitle("Wedding planner ");
        anotherMovie.setYear(2006);
        anotherMovie.setDesciptions("it is about planning a wedding.,...");

        //now we add the movie into an empty list

        Set<Movie> movies = new HashSet<>();
        movies.add(movie);
        movies.add(anotherMovie);

        // we add the list of movies into an actor of movies
        actor.setMovies(movies);
        movie.setCast(actors);
        // save the actor into the database
        actorRepository.save(actor);
        movieRepository.save(movie);

        // now we get all the actors from the database of repository and send them to template using the model attribute
        model.addAttribute("actors",actorRepository.findAll());
        return "index";
    }

  /*  @RequestMapping("/movie")
    public String home(Model model){
        // create a movie
        Movie movie= new Movie();
        movie.setTitle("Game of Thrones");
        movie.setYear(2013);

        // create multiple actors
        Actor actor1= new Actor();
        actor1.setName("Jhon Snow");
        Actor actor2=new Actor();
        actor2.setName("Dragon Queen");

        // define a set which contains set of actors for a movie
        Set<Actor> actors=new HashSet<>();
        actors.add(actor1);
        actors.add(actor2);

        //add the set of actors to movie of set
        movie.setCast(actors);

        // save the movie to the database
        movieRepository.save(movie);

        // now we get all movies in the template
        model.addAttribute("movies",movieRepository.findAll());
        return "home";


    }*/
}
