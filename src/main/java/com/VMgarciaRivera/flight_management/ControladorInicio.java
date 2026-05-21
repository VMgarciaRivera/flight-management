package com.VMgarciaRivera.flight_management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.VMgarciaRivera.flight_management.modelo.Usuario;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${mensaje.index}")
    private String mensaje;

    @Value("${mensaje.index}")
    String mensajeDesdeProperties;
    @GetMapping("/")
    public String inicio(Model modelo) {
        String mensaje = "Bienvenido a la gestión de vuelos";
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("mensajeDesdeProperties", mensajeDesdeProperties);
        Usuario usuario = new Usuario();
        usuario.setCedula("1048993511");
        usuario.setEmail("victo.elcatire75@gmail.com");
        usuario.setClave("123456");
        usuario.setNombre("Victor Manuel Garcia Rivera");
        modelo.addAttribute("usuario", usuario);
        log.info("Accediendo a la pagina de inicio");
        return "index";
    }
}
