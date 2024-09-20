package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import application.model.Plataforma;
import application.repository.PlataformaRepository;

@Controller
@RequestMapping("/plataforma")
public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformaRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAtribute("plataformas", plataformaRepo.findAll());
        return "plataforma/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "plataforma/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert (@RequestParam("nome")String nome){
        plataforma.setNome(nome);

        plataformaRepo.save(plataforma);

        return "redirect:/plataforma/list";
    }

    @RequestMapping("/uptade")
    public String uptade(
        @RequestParam("id") long id,
        Model ui) {
            Optional<Plataforma> plataforma = plataformaRepo.findById(id);

            if(plataforma.isPresent()){
                ui.addAtribute("plataforma", plataforma.get());
                return "plataforma/uptade";
            }

            return "redirect:/plataforma/list";
        }

    @RequestMapping(value = "/uptade", method = RequestMethod.POST)
    public String uptade(
        @RequestParam("id") long id,
        @RequestParam("nome") String nome) {

            Optonal<Plataforma> plataforma = plataformaRepo.findById(id);

            if(plataforma.isPresent()) {
                plataforma.get().setNome(nome);

                plataformaRepo.save(plataforma.get());
            }

            return "redirect:/plataforma/list";
        }

    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui) {

            Optional<Plataforma> plataforma = plataformaRepo.findById(id);

            if(plataforma.isPresent()){
                ui.addAtribute("plataforma", plataforma.get());
                return "plataforma/delete";
            }

            return "redirect:/plataformas/list";
        }
        
    @RequestMapping(value= "/delete", method= RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        plataformaRepo.deleteById(id);

        return "redirect:/plataforma/list";
    }
}