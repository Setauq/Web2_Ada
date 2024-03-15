package tech.ada.livrosgestao.livro;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void salvarLivro(Livro livro){ livroRepository.save(livro);}

    public Livro obterLivroPorId(Integer id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        return optionalLivro.orElse(null);
    }


    public List<Livro> getAll(){ return (List<Livro>) livroRepository.findAll();  }

    public Livro atualizarLivro(Integer id, Livro novoLivro) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()) {
            Livro livroExistente = optionalLivro.get();
            livroExistente.setIsbn(novoLivro.getIsbn());
            livroExistente.setTitulo(novoLivro.getTitulo());
            livroExistente.setAutor(novoLivro.getAutor());
            livroExistente.setGenero(novoLivro.getGenero());
            livroExistente.setAnoPublicacao(novoLivro.getAnoPublicacao());
            livroExistente.setEmprestado(novoLivro.isEmprestado());

            // Adicione outras propriedades que você deseja atualizar
            livroRepository.save(livroExistente);
            return livroExistente;
        } else {
            return null; // Ou lançar uma exceção indicando que o livro não foi encontrado
        }
    }

    public void excluirLivro(Integer id) {
        livroRepository.deleteById(id);
    }

    public Livro obterLivro(Integer id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        return optionalLivro.orElse(null);
    }
}
