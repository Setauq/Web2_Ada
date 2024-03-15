package tech.ada.livrosgestao.endereco;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.livrosgestao.livro.Livro;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {

        this.enderecoService = enderecoService;
    }

    @GetMapping("/allend")
    public List<EnderecoEntity> recuperaEnd(){
        return enderecoService.getEndAll();
    }

    @GetMapping("/{id}")
    public EnderecoEntity obterEnderecoPorId(@PathVariable Integer id) {
        return enderecoService.obterEnderecoPorId(id);
    }

    @PostMapping
    public EnderecoEntity criarEndereco(@RequestBody EnderecoEntity enderecoEntity){
        enderecoService.salvarEndereco(enderecoEntity);
        return enderecoEntity;
    }

    @PutMapping("/{id}")
    public EnderecoEntity atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoEntity enderecoEntity) {
        return enderecoService.atualizarEndereco(id, enderecoEntity);
    }


    @DeleteMapping()
    public ResponseEntity<Void> excluirEndereco(@RequestBody EnderecoEntity enderecoEntity) {
        enderecoService.excluirEndereco(enderecoEntity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public String excluirEndereco(@PathVariable Integer id) {
        enderecoService.excluirEndereco(id);
        return "Endereço excluído com sucesso";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EnderecoEntity> atualizarParcialEndereco(@PathVariable Integer id, @RequestBody EnderecoEntity endereco) {
        EnderecoEntity enderecoExistente = enderecoService.obterEndereco(id);
        if (enderecoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (endereco.getLogradouro() != null) {
            enderecoExistente.setLogradouro(endereco.getLogradouro());
        }
        if (endereco.getNumero() > 0) {
            enderecoExistente.setNumero(endereco.getNumero());
        }
        if (endereco.getBairro() != null) {
            enderecoExistente.setBairro(endereco.getBairro());
        }
        if (endereco.getCidade() != null) {
            enderecoExistente.setCidade(endereco.getCidade());
        }
        if (endereco.getEstado() != null) {
            enderecoExistente.setEstado(endereco.getEstado());
        }
        if (endereco.getCep() != null) {
            enderecoExistente.setCep(endereco.getCep());
        }

        enderecoService.salvarEndereco(enderecoExistente);
        return ResponseEntity.ok(enderecoExistente);
    }


}
