package tech.ada.livrosgestao.membro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MembroRepository extends JpaRepository<Membro, Integer> {

}
