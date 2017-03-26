package br.com.eicon.repository;

import br.com.eicon.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
