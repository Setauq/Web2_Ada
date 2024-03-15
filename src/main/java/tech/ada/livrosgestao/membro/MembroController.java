package tech.ada.livrosgestao.membro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.ada.livrosgestao.endereco.EnderecoEntity;
import tech.ada.livrosgestao.livro.Livro;

import java.util.List;

@RestController
@RequestMapping("/membro")
public class MembroController {

    private MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @GetMapping("/todos")
    public List<Membro> listaMembros(){ return membroService.getTodos();}

    @GetMapping("/all")
    public Iterable<Membro> getAllMembros(){
        return membroService.getAll();
    }

    @GetMapping("/{id}")
    public Membro obterMembroPorId(@PathVariable Integer id) {
        return membroService.obterMembroPorId(id);
    }

    @PostMapping
    public String incluirMembro(@Validated @RequestBody MembroRequest membro){
        membroService.salvarMembro(membro);
        return HttpStatus.OK.toString();
    }

    @PutMapping("/{id}")
    public Membro atualizarMembro(@PathVariable Integer id, @RequestBody Membro membro) {
        return membroService.atualizarMembro(id, membro);
    }

    @DeleteMapping("delete/{id}")
    public String excluirUsuario(@PathVariable Integer id) {
        membroService.excluirMembro(id);
        return "Membro excluído com sucesso";
    }

    @PatchMapping("/{membroId}/endereco/{enderecoId}")
    public Membro adicionarEnderecoAoMembro(@PathVariable Integer membroId, @PathVariable Integer enderecoId) {
        return membroService.adicionarEnderecoAoMembro(membroId, enderecoId);
    }

    @PatchMapping("atualiza/{id}")
    public ResponseEntity<Membro> atualizarParcialmembro(@PathVariable Integer id, @RequestBody Membro membro) {
        Membro membroExistente = membroService.obterMembroPorId(id);
        if (membroExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (membro.getNome() != null) {
            membroExistente.setNome(membro.getNome());
        }
        if (membro.getIdade() >= 0) {
            membroExistente.setIdade(membro.getIdade());
        }
        if (membro.getCelular() != null) {
            membroExistente.setCelular(membro.getCelular());
        }
        if (membro.getEmail() != null) {
            membroExistente.setEmail(membro.getEmail());
        }

        membroService.salvarMembro2(membroExistente);
        return ResponseEntity.ok(membroExistente);
    }

}
