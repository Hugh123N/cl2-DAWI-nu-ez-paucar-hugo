package edu.hugo.DAWI_CL2.service.impl;

import edu.hugo.DAWI_CL2.dto.FilmDetailDto;
import edu.hugo.DAWI_CL2.dto.FilmDto;
import edu.hugo.DAWI_CL2.model.Film;
import edu.hugo.DAWI_CL2.repository.FilmRepository;
import edu.hugo.DAWI_CL2.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDto> findAll() {
        List<FilmDto> films= new ArrayList<>();
        try {
            Iterable<Film> iterable=filmRepository.findAll();
            iterable.forEach( film ->{
                FilmDto filmDto=new FilmDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getLanguage().getName(),
                        film.getRentalRate()
                );
                films.add(filmDto);
            });
        }catch (Exception e){
            e.getStackTrace();
        }
        return films;
    }

    @Override
    public FilmDetailDto findById(Integer id) {
        Optional<Film> optional=filmRepository.findById(id);
        return optional.map(
                film -> new FilmDetailDto(film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())
        ).orElse(null);

    }

    @Override
    public Boolean update(FilmDetailDto filmDetailDto) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Boolean save(FilmDetailDto filmDetailDto) {
        return null;
    }
}
