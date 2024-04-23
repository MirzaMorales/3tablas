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
import mx.utng.sesion26.model.entity.RegistroHorario;
import mx.utng.sesion26.model.service.IRegistroHorarioService;

@Controller
@SessionAttributes("registroHorario")
public class RegistroHorarioController {
    
    @Autowired 
    private IRegistroHorarioService service;


    @GetMapping({"","/","/list"})
    public String list(Model model){

    model.addAttribute("title", "Registro de Horario");
    model.addAttribute("registroHorarios",service.list());
    return "list";

    }

    @GetMapping("/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 
    public String create(Model model){
        model.addAttribute("title","Formulario de Horario");
        model.addAttribute("registroHorario", new RegistroHorario());
        return "form";
    }

    @PostMapping("/form")  
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid RegistroHorario registroHorario,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de Horario");
            return "form";
        }
        service.save(registroHorario);
        return "redirect:list";

    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroHorario registroHorario = null;
        if(id>0){
            registroHorario = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Registro del Horario");
        model.addAttribute("registroHorario", registroHorario);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
