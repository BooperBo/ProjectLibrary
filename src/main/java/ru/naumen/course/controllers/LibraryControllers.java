package ru.naumen.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.course.services.LibraryService;

@Controller
@RequestMapping("/libraries")
public class LibraryControllers {

    private final LibraryService libraryService;

    @Autowired
    public LibraryControllers(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("library", libraryService.findAll());
        return "libraries/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("library", libraryService.findOne(id));

        return "libraries/show";
    }
}