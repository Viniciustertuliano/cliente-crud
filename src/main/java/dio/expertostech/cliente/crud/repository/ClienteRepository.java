package dio.expertostech.cliente.crud.repository;

import dio.expertostech.cliente.crud.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {}