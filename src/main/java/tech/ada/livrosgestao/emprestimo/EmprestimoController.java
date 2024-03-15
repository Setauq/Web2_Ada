package tech.ada.livrosgestao.emprestimo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.livrosgestao.membro.Membro;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Emprestimo> listarEmprestimos() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Emprestimo obterEmprestimoPorId(@PathVariable Integer id) {
        return service.obterEmprestimoPorId(id);
    }

    @PostMapping
    public Emprestimo incluirEmprestimo(@RequestBody Emprestimo emprestimo) {
        service.salvarEmprestimo(emprestimo);
        return emprestimo;
    }

    @PutMapping("/{id}")
    public Emprestimo atualizarEmprestimo(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        return service.atualizarEmprestimo(id, emprestimo);
    }
    @DeleteMapping("/delete/{id}")
    public String excluirEmprestimo(@PathVariable Integer id) {
        service.excluirEmprestimo(id);
        return "Empréstimo excluído com sucesso";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarParcialEmprestimo(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoExistente = service.obterEmprestimoPorId(id);
        if (emprestimoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (emprestimo.getDataRetirada() != null) {
            emprestimoExistente.setDataRetirada(emprestimo.getDataRetirada());
        }
        if (emprestimo.getDataDevolucao() != null) {
            emprestimoExistente.setDataDevolucao(emprestimo.getDataDevolucao());
        }

        service.salvarEmprestimo(emprestimoExistente);
        return ResponseEntity.ok(emprestimoExistente);
    }

    @PatchMapping("/{emprestimoId}/livro/{livroId}/membro/{membroId}")
    public Emprestimo adicionarEmprestimoDoLivro(@PathVariable Integer emprestimoId, @PathVariable Integer livroId, @PathVariable Integer membroId ) {
        return service.adicionarEmprestimoDoLivro(emprestimoId, livroId, membroId);
    }

}
