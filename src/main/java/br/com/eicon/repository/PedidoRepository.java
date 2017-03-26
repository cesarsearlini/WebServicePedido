package br.com.eicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eicon.model.Pedido;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByDataCadastro(@Param("dataCadastro") Date dataCadastro);


}
