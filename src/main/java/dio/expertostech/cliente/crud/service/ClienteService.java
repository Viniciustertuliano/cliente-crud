package dio.expertostech.cliente.crud.service;

import dio.expertostech.cliente.crud.model.Cliente;
import dio.expertostech.cliente.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getTodosClientes(){
        return repository.findAll();
    }

    public Cliente getClientePorId(String id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Cliente salvarCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente atualizaCliente(String id, Cliente cliente){
        if ( !repository.existsById(id) )
            throw new EntityNotFoundException();
        cliente.setId(id);
        return salvarCliente(cliente);
    }

    public void deleteCliente(String id){
        repository.deleteById(id);
    }
}
