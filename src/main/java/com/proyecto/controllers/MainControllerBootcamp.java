package com.proyecto.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.entities.Bootcamp;
import com.proyecto.services.BootcampService;

@Controller
@RequestMapping("/")
public class MainControllerBootcamp {
    private static final Logger LOG = Logger.getLogger("MainControllerBootcamp");

    @Autowired
    private BootcampService bootcampService;

    /** Muestra la lista de bootcamps */
    @GetMapping("/listar")
    public ModelAndView listar() {
        List<Bootcamp> bootcamps = bootcampService.findAll();

        ModelAndView mav = new ModelAndView("views/listarBootcamp");
        mav.addObject("bootcamps", bootcamps);

        return mav;
    }
    /**
     * Muestra el formulario de alta Bootcamp
     */
    @GetMapping("/frmAltaBootcamp")
    public String formularioAltaEstudiante(Model model) {

        Bootcamp bootcamp = new Bootcamp();

        model.addAttribute("bootcamp", bootcamp);


        return "views/formularioAltaBootcamp";
    }
    @PostMapping("/altaModificacionBootcamp")
    /** Metodo que recibe los datos procedente de los controles del formulario */
    public String altaEstudiante(@ModelAttribute Bootcamp bootcamp,
            @RequestParam(name = "imagen") MultipartFile imagen) { 
 
        if(!imagen.isEmpty()){
            try {

              String rutaAbsoluta ="/home//salma/recursos/images";
                byte[] imagenEnBytes = imagen.getBytes();

                Path rutaCompleta = Paths.get(rutaAbsoluta + "/" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, imagenEnBytes);


                bootcamp.setLogo(imagen.getOriginalFilename());  
            } catch (Exception e) {
                
            }

        }
        bootcampService.save(bootcamp);
        
        return "redirect:/listar";
    }
     
        @GetMapping("/frmActualizar/{id}")
        public String frmActualizaBootcamp(@PathVariable(name = "id") int idBootcamp, Model model) {
        Bootcamp bootcamp = bootcampService.findById(idBootcamp);

        model.addAttribute("bootcamp", bootcamp); 

        return "views/formularioAltaEstudiante"; // quiero que vuelva a la vista
        
    }
    @GetMapping("/borrar/{id}")
        public String borrarBootcamp(@PathVariable(name = "id") int idBootcamp){
           bootcampService.delete(bootcampService.findById(idBootcamp));
            return "redirect:/listar";
        
        }

    // Metodo que muestra los detalles
    @GetMapping("/detalles/{id}")
        public String detallesBootcamp(@PathVariable(name = "id") int idBootcamp, Model model){
          
            Bootcamp bootcamp = bootcampService.findById(idBootcamp);
       
            model.addAttribute("bootcamp", bootcamp); // para que te traiga el formulario con los datos llenos
            
            return "views/detallesBootcamp";
        }  
}
