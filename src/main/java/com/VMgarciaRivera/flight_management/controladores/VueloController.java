package com.VMgarciaRivera.flight_management.controladores;

import com.VMgarciaRivera.flight_management.servicio.VueloService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.VMgarciaRivera.flight_management.modelo.Vuelo;

import java.util.Optional;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class VueloController {

    private final VueloService vueloService;

    @GetMapping("/vuelos/agregar")
    public String agregarVuelo(@ModelAttribute("vuelo") Vuelo vuelo) {
        return "modificarVuelo";
    }

    @PostMapping("/vuelos/crear")
    public String crearVuelo(@Valid @ModelAttribute("vuelo") Vuelo vuelo, BindingResult result, Errors errores) {

        if (errores.hasErrors() || result.hasErrors()) {
            log.error("Errores de validación al crear vuelo: {}", errores.hasErrors() ? errores.getAllErrors() : result.getAllErrors());
            return "modificarVuelo";
        }
        log.info("Creando vuelo: {}", vuelo);
        vueloService.save(vuelo);
        log.info("Vuelo creado exitosamente: {}", vuelo);
        return "redirect:/";
    }

    @GetMapping("/vuelos/eliminar/{id}")
    public String eliminarVuelo(@PathVariable UUID id) {
        log.info("Eliminando vuelo con ID: {}", id);
        vueloService.deleteById(id);
        log.info("Vuelo eliminado exitosamente: {}", id);
        return "redirect:/";
    }

    @GetMapping("/vuelos/editar/{id}")
    public String editarVuelo(@PathVariable UUID id, Model modelo) {
        log.info("Editando vuelo con ID: {}", id);
        Optional<Vuelo> vuelo = vueloService.findById(id);
        modelo.addAttribute("vuelo", vuelo);
        log.info("Vuelo encontrado para edición: {}", vuelo);
        return "modificarVuelo";
    }
}
