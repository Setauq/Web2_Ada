package tech.ada.livrosgestao.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.livrosgestao.membro.Membro;


import java.util.List;
@RestController
@RequestMapping("/livro")
public class LivroController {


    private LivroService service;

    public LivroController(LivroService service) {this.service = service;}


    @GetMapping("/all")
    public List<Livro> listaLivros(){ return service.getAll();}

    @GetMapping("/{id}")
    public Livro obterLivroPorId(@PathVariable Integer id) {
        return service.obterLivroPorId(id);
    }



    @PostMapping
    public Livro incluirLivro(@RequestBody Livro livro){
        service.salvarLivro(livro);
        return livro;
  }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        return service.atualizarLivro(id, livro);
    }

    @DeleteMapping("/delete/{id}")
    public String excluirLivro(@PathVariable Integer id) {
       service.excluirLivro(id);
        return "Usuário excluído com sucesso";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> atualizarParcialLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        Livro livroExistente = service.obterLivro(id);
        if (livroExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (livro.getIsbn() != null) {
            livroExistente.setIsbn(livro.getIsbn());
        }
        if (livro.getTitulo() != null) {
            livroExistente.setTitulo(livro.getTitulo());
        }
        if (livro.getAutor() != null) {
            livroExistente.setAutor(livro.getAutor());
        }
        if (livro.getGenero() != null) {
            livroExistente.setGenero(livro.getGenero());
        }
        if (livro.getAnoPublicacao() != null) {
            livroExistente.setAnoPublicacao(livro.getAnoPublicacao());
        }

        livroExistente.setEmprestado(livro.isEmprestado());

        service.salvarLivro(livroExistente);
        return ResponseEntity.ok(livroExistente);
    }
}


