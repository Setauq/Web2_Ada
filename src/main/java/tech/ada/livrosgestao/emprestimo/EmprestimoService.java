package tech.ada.livrosgestao.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.livrosgestao.endereco.EnderecoEntity;
import tech.ada.livrosgestao.livro.Livro;
import tech.ada.livrosgestao.livro.LivroRepository;
import tech.ada.livrosgestao.membro.Membro;
import tech.ada.livrosgestao.membro.MembroRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private MembroRepository membroRepository;


    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public void salvarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setDataRetirada(emprestimo.getDataRetirada());
        emprestimo.setDataDevolucao(emprestimo.getDataDevolucao());
        emprestimo.setMulta(emprestimo.getMulta());

        emprestimoRepository.save(emprestimo);
    }


    public Emprestimo obterEmprestimoPorId(Integer id) {
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        return optionalEmprestimo.orElse(null);
    }

    public List<Emprestimo> getAll() {
        return (List<Emprestimo>) emprestimoRepository.findAll();
    }

    public Emprestimo atualizarEmprestimo(Integer id, Emprestimo novoEmprestimo) {
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);

        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimoExistente = optionalEmprestimo.get();
            emprestimoExistente.setDataRetirada(novoEmprestimo.getDataRetirada());
            emprestimoExistente.setDataDevolucao(novoEmprestimo.getDataDevolucao());
            emprestimoExistente.setDiasAtrasados(novoEmprestimo.getDiasAtrasados());
            emprestimoExistente.setMulta(novoEmprestimo.getMulta());

            emprestimoRepository.save(emprestimoExistente);
            return emprestimoExistente;
        } else {
            return null;
        }
    }
    public void excluirEmprestimo(Integer id) {
        emprestimoRepository.deleteById(id);
    }

    public Emprestimo obterEmprestimo(Integer id) {
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        return optionalEmprestimo.orElse(null);
    }


    public Emprestimo adicionarEmprestimoDoLivro(Integer emprestimoId, Integer livroid, Integer membroId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElse(null);
        Livro livro = livroRepository.findById(livroid).orElse(null);
        Membro membro = membroRepository.findById(membroId).orElse(null);

        if (emprestimo != null && livro != null && membro != null) {
            emprestimo.setLivro(livro);
            emprestimo.setMembro(membro);
            return emprestimoRepository.save(emprestimo);
        } else {
            return null;
        }
    }


}
