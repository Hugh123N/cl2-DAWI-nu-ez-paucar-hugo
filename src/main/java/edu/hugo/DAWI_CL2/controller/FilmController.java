package edu.hugo.DAWI_CL2.controller;

import edu.hugo.DAWI_CL2.dto.FilmDetailDto;
import edu.hugo.DAWI_CL2.dto.FilmDto;
import edu.hugo.DAWI_CL2.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/list")
    public String inicio(Model model){
        List<FilmDto> films= filmService.findAll();
        model.addAttribute("films",films);
        return "films";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id,Model model){
        FilmDetailDto film=filmService.findById(id);
        model.addAttribute("film",film);
        return "film-detail";
    }

}
