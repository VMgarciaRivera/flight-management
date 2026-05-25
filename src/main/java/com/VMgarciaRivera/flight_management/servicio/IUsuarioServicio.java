package com.VMgarciaRivera.flight_management.servicio;

import java.util.List;
import com.VMgarciaRivera.flight_management.modelo.Usuario;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();
    public void guardar (Usuario usuario);
    public void eliminar (Usuario usuario);
    public Usuario encontrarUsuario(Usuario usuario);
}
