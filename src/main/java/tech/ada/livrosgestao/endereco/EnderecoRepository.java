package tech.ada.livrosgestao.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
}
