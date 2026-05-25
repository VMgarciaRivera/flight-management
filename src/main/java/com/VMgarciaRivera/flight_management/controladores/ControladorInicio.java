package com.VMgarciaRivera.flight_management.controladores;

import com.VMgarciaRivera.flight_management.servicio.IUsuarioServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.VMgarciaRivera.flight_management.dao.IUsuarioCrud;
import com.VMgarciaRivera.flight_management.modelo.Usuario;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    IUsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) usuarioServicio.listarUsuarios();
        modelo.addAttribute("listaUsuarios", listaUsuarios);
        log.info("ejecutando control de inicio MVC");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar (Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/";
    }

}
