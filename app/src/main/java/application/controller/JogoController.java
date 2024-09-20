package application.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import application.model.Jogo;
import application.model.Plataforma;
import application.repository.CategoriaRepository;
import application.repository.JogoRepository;
import application.repository.PlataformaRepository;


@Controller
@RequestMapping("/jogo")
public class jogoController {
    @Autowired
    private JogoRepository jogoRepo;
    @Autowired
    private CategoriaRepository categoriaRepo;
    @Autowired
    private PlataformaRepository plataformaRepo;


    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAtribute("jogos", jogoRepo.findAll());
        return "jogo/list";
    }

    @RequestMapping("/insert")
    public String insert(Model ui){
        ui.addAtribute("categorias", categoriaRepo.findAll());
        ui.addAtribute("plataformas", plataformaRepo.findAll());
        return "jogo/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("categoria") long idCategoria,
        @RequestParam("plataformas") long[] idsPlataformas) {

            jogo jogo = new Jogo();
            jogo.setTitulo(titulo);
            jogo.setCategoria(categoriaRepo.findById(idCategoria).get());
            for(long p: idsPlataformas) {
                Optional<Plataforma> plataforma = plataformaRepo.findById(p);
                if (plataforma.isPresent()){
                    jogo.getPlataformas().add(plataforma.get());
                }
            }
            jogoRepo.save(jogo);
            return "redirect:/jogo/list";
        }
    @RequestMapping("/uptade")
    public String uptade(
        @RequestParam("id") long id,
        Model ui) {

            Optonal<jogo> jogo = jogoRepo.findById(id);
            if(jogo.isPresent()) {
                ui.addAtribute("jogo", jogo.get());
                ui.addAtribute("categorias", categoriaRepo.findAll());
                ui.addAtribute("plataformas", plataformaRepo.findAll());
                return "jogo/uptade";
            }
            return "redirect:/jogo/list";
        }
    @RequstMapping(value = "/uptade", method = RequestMethod.POST)
    public String uptade(
        @RequestParam("id") long id,
        @RequestParam("titulo") String titulo,
        @RequestParam("categoria") long idCategoria,
        @RequestParam("plataformas") long[] idsPlataformas) {

            Optional<jogo> jogo = jogoRepo.findById(id);

            if(jogo.isPresent()) {
                jogo.get().setTitulo(titulo);
                jogo.get().setCategoria(categoriaRepo.findById(idCategoria),get());
                Set<Plataforma> uptadePlataforma = new HashSet <>();
                for(long p: idsPlataformas) {
                    Optional<Plataforma> plataforma = plataformaRepo.findById(p);
                    if(plataforma.isPresent()) {
                        uptadePlataforma.add(plataforma.get());
                    }
                }
                jogo.get().setPlataformas(uptadePlataforma);
                jogoRepo.save(jogo.get());
            }
            return "redirect:/jogo/list";

        }

    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui) {

        Optional<jogo> jogo = jogoRepo.findById(id);

        if(jogo.isPresent()){
            ui.addAtribute("jogo", jogo.get());
            return "jogo/delete";
        }
        return "redirect:/jogo/list";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        jogoRepo.deleteById(id);

        return "redirect:/jogo/list";
    }
}
