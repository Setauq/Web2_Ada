package tech.ada.livrosgestao.membro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.livrosgestao.endereco.EnderecoEntity;
import tech.ada.livrosgestao.endereco.EnderecoRepository;
import tech.ada.livrosgestao.livro.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MembroService {
    @Autowired
    private MembroRepository membroRepository;


    @Autowired
    private EnderecoRepository enderecoRepository;


// Metodos

    public Membro obterMembroPorId(Integer id) {
        Optional<Membro> optionalUsuario = membroRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    public void salvarMembro(MembroRequest membro){
        membroRepository.save(new Membro(membro));
    }

    public List<Membro> getTodos(){ return (List<Membro>) membroRepository.findAll();  }

    public void excluirMembro(Integer id) {
        membroRepository.deleteById(id);
    }

    public Iterable<Membro> getAll(){
        return metodoQueConverteEntidadeParaRequest();
    }

    private List<Membro> metodoQueConverteEntidadeParaRequest() {

        List<Membro> listaDeMembros = new ArrayList<>();

        membroRepository.findAll().forEach(item -> {
            listaDeMembros.add(new Membro(item));
        });

        return listaDeMembros;
    }

    public Membro atualizarMembro(Integer id, Membro novoMembro) {
        Optional<Membro> optionalMembro = membroRepository.findById(id);

        if (optionalMembro.isPresent()) {
            Membro membroExistente = optionalMembro.get();
            membroExistente.setNome(novoMembro.getNome());
            membroExistente.setIdade(novoMembro.getIdade());
            membroExistente.setEmail(novoMembro.getEmail());
            membroExistente.setCelular(novoMembro.getCelular());

            membroRepository.save(membroExistente);
            return membroExistente;
        } else {
            return null;
        }
    }

    public Membro adicionarEnderecoAoMembro(Integer membroId, Integer enderecoId) {
        Membro membro = membroRepository.findById(membroId).orElse(null);
        EnderecoEntity endereco = enderecoRepository.findById(enderecoId).orElse(null);

        if (membro != null && endereco != null) {
            membro.setEndereco(endereco);
            return membroRepository.save(membro);
        } else {
            return null;
        }
    }

    public void salvarMembro2(Membro membro){ membroRepository.save(membro);}


}
