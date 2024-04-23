package mx.utng.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.sesion26.model.entity.ListaEsperaEvento;
import mx.utng.sesion26.model.service.IListaEsperaEventoService;

@Controller
@SessionAttributes("listaEsperaEvento")

public class ListaEsperaEventoController {
  
    @Autowired 
    private IListaEsperaEventoService service;


    @GetMapping({"/listaEsperaEvento","/listaEsperaEvento/","/listaEsperaEvento/list"})
    public String list(Model model){

    model.addAttribute("title", "ListaEsperaEvento");
    model.addAttribute("listasEsperaEventos",service.list());
    return "listaEsperaEvento-list";

    }

    @GetMapping("/listaEsperaEvento/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 
    public String create(Model model){
        model.addAttribute("title","Formulario de la lista de Espera para Eventos");
        model.addAttribute("listaEsperaEvento", new ListaEsperaEvento());
        return "listaEsperaEvento-form";
    }

    @PostMapping("/listaEsperaEvento/form")  
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid ListaEsperaEvento listaEsperaEvento,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de la lista de Espera para Eventos");
            return "listaEsperaEvento-form";
        }
        service.save(listaEsperaEvento);
        return "redirect:/listaEsperaEvento/list";

    }

    @GetMapping("/listaEsperaEvento/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaEsperaEvento listaEsperaEvento = null;
        if(id>0){
            listaEsperaEvento = service.getById(id);
        }else{
            return "redirect:/listaEsperaEvento/list";
        }
        model.addAttribute("title", "Editar la lista de Espera para Eventos");
        model.addAttribute("listaEsperaEvento", listaEsperaEvento);
        return "listaEsperaEvento-form";
    }

    @GetMapping("/listaEsperaEvento/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/listaEsperaEvento/list";
    }



}
