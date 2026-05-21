package com.VMgarciaRivera.flight_management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.VMgarciaRivera.flight_management.modelo.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Usuario u2 = new Usuario();
        u2.setCedula("983u98237");
        u2.setEmail("cnaindioqndi");
        u2.setClave("qweq3e3qwd");
        u2.setNombre("Vjose ioajsoisaa");
        Usuario u3 = new Usuario();
        u3.setCedula("asodjaijoiw");
        u3.setEmail("lansdlianld");
        u3.setClave("sadmaoisdjaos8");
        u3.setNombre("mhvhhtfy");

        List<Usuario> listaUsuarios = Arrays.asList(u2, u3);
        modelo.addAttribute("listaUsuarios", listaUsuarios);

        log.info("Accediendo a la pagina de inicio");
        return "index";
    }
}
