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
import mx.utng.sesion26.model.entity.RegistroHogarGasto;
import mx.utng.sesion26.model.service.IRegistroHogarGastoService;

@Controller
@SessionAttributes("registroHogarGasto")
public class RegistroHogarGastoController {

        
    @Autowired 
    private IRegistroHogarGastoService service;


    @GetMapping({"/registroHogarGasto","/registroHogarGasto/","/registroHogarGasto/list"})
    public String list(Model model){

    model.addAttribute("title", "Registro de Gastos del Hogar");
    model.addAttribute("registroHogarGastos",service.list());
    return "registroHogarGasto-list";

    }

    @GetMapping("/registroHogarGasto/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 
    public String create(Model model){
        model.addAttribute("title","Formulario de Registro de Gastos del Hogar");
        model.addAttribute("registroHogarGasto", new RegistroHogarGastoController());
        return "registroHogarGasto-form";
    }

    @PostMapping("/registroHogarGasto/form")  
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid RegistroHogarGasto registroHogarGasto,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de Registro de Gastos del Hogar");
            return "registroHogarGasto-form";
        }
        service.save(registroHogarGasto); 
        return "redirect:/registroHogarGasto/list";

    }

    @GetMapping("/registroHogarGasto/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroHogarGasto registroHogarGasto = null;
        if(id>0){
            registroHogarGasto = service.getById(id);
        }else{
            return "redirect:/registroHogarGasto/list";
        }
        model.addAttribute("title", "Editar Registro de Gastos del Hogar");
        model.addAttribute("registroHogarGasto", registroHogarGasto);
        return "registroHogarGasto-form";
    }

    @GetMapping("/registroHogarGasto/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/registroHogarGasto/list";
    }
    
}
