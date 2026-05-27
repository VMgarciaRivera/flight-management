package com.VMgarciaRivera.flight_management.controladores;

import com.VMgarciaRivera.flight_management.servicio.IUsuarioServicio;
import com.VMgarciaRivera.flight_management.servicio.VueloService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.VMgarciaRivera.flight_management.modelo.Usuario;
import com.VMgarciaRivera.flight_management.modelo.Vuelo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ControladorInicio {

    private final IUsuarioServicio usuarioServicio;
    private final VueloService vueloService;

    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) usuarioServicio.listarUsuarios();
        List<Vuelo> listaVuelos = vueloService.findAll();
        modelo.addAttribute("listaUsuarios", listaUsuarios);
        modelo.addAttribute("listaVuelos", listaVuelos);
        log.info("ejecutando control de inicio MVC");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(@ModelAttribute("usuario") Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar (@Valid Usuario usuario, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        usuarioServicio.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{cedula}")
    public String editar(Usuario usuario, Model modelo) {
        log.info("ejecutando control de editar MVC");
        usuario = usuarioServicio.encontrarUsuario(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminar(Usuario usuario) {
        usuarioServicio.eliminar(usuario);
        return "redirect:/";
    }

}
