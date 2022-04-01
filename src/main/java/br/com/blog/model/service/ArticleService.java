package br.com.blog.model.service;

import java.util.List;
import java.util.Optional;

import br.com.blog.model.entities.Article;

public interface ArticleService {
	Optional<Article> findById(Integer id);
	Article findByTitle(String title);
	List<Article> findAll();
	List<Article> findAllByTitle(String title);
	Article save(Article article);
}
