package com.VMgarciaRivera.flight_management.controladores;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.VMgarciaRivera.flight_management.modelo.Usuario;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String inicio(Model modelo) {
        log.info("ejecutando control de inicio MVC");
        return "index";
    }
}
