package com.VMgarciaRivera.flight_management.servicio;

import com.VMgarciaRivera.flight_management.dao.IUsuarioCrud;
import com.VMgarciaRivera.flight_management.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {

    @Autowired
    IUsuarioCrud curdUser;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) curdUser.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario usuario) {
        curdUser.save(usuario);
    }

    @Transactional
    @Override
    public void eliminar(Usuario usuario) {
        curdUser.delete(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return curdUser.findById(usuario.getCedula()).orElse(null);
    }
}
