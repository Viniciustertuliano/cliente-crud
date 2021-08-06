package dio.expertostech.cliente.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import dio.expertostech.cliente.crud.model.Cliente;
import dio.expertostech.cliente.crud.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping()
    public List<Cliente> ListarTodos(){
        return service.getTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente clientePorId(@PathVariable String id){
        return service.getClientePorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return service.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable String id,
                                            @RequestBody Cliente cliente){
        return service.atualizaCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable String id){
        service.deleteCliente(id);
    }

}
