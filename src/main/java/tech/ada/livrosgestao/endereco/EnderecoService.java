package tech.ada.livrosgestao.endereco;


import org.springframework.stereotype.Service;
import tech.ada.livrosgestao.emprestimo.Emprestimo;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    //Atributos

    private EnderecoRepository enderecoRepository;

    // Construtor
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    // Metodos

    public EnderecoEntity obterEnderecoPorId(Integer id) {
        Optional<EnderecoEntity> optionalEndereco = enderecoRepository.findById(id);
        return optionalEndereco.orElse(null);
    }
    public void salvarEndereco(EnderecoEntity enderecoEntity){
        enderecoRepository.save(enderecoEntity);
    }

    public void excluirEndereco(EnderecoEntity enderecoEntity){
        enderecoRepository.delete(enderecoEntity);
    }

    public List<EnderecoEntity> getEndAll(){
        return (List<EnderecoEntity>) enderecoRepository.findAll();
    }

    public EnderecoEntity atualizarEndereco(Integer id, EnderecoEntity novoEndereco) {
        Optional<EnderecoEntity> optionalEndereco = enderecoRepository.findById(id);

        if (optionalEndereco.isPresent()) {
            EnderecoEntity enderecoExistente = optionalEndereco.get();
            enderecoExistente.setCep(novoEndereco.getCep());
            enderecoExistente.setLogradouro(novoEndereco.getLogradouro());
            enderecoExistente.setNumero(novoEndereco.getNumero());
            enderecoExistente.setBairro(novoEndereco.getBairro());
            enderecoExistente.setCidade(novoEndereco.getCidade());
            enderecoExistente.setEstado(novoEndereco.getEstado());

            enderecoRepository.save(enderecoExistente);
            return enderecoExistente;
        } else {
            return null;
        }
    }

    public void excluirEndereco(Integer id) {
        //Integer codigo = id;
        enderecoRepository.deleteById(id);
    }

    public EnderecoEntity obterEndereco(Integer id) {
        Optional<EnderecoEntity> optionalEndereco = enderecoRepository.findById(id);
        return optionalEndereco.orElse(null);
    }

}
