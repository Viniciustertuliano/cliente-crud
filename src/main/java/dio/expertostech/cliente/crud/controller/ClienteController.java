package dio.expertostech.cliente.crud.controller;

import dio.expertostech.cliente.crud.model.Cliente;
import dio.expertostech.cliente.crud.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @GetMapping("/listartodos")
    public ResponseEntity<List<Cliente>> ListarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(repository.save(cliente));
    }
}
