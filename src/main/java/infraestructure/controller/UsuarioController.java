package infraestructure.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Usuario;
import services.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsuarioController extends HttpServlet {

    private ObjectMapper mapper;
    private UsuarioService service;

    public UsuarioController() {
        this.mapper = new ObjectMapper();
        this.service = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = mapper.readValue(req.getInputStream(),Usuario.class);
        service.setUser(usuario);

        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
}
