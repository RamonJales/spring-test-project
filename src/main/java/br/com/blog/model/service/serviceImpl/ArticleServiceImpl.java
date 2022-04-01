package br.com.blog.model.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.entities.Article;
import br.com.blog.model.repository.ArticleRepository;
import br.com.blog.model.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Optional<Article> findById(Integer id) {
		return articleRepository.findById(id);
	}

	@Override
	public Article findByTitle(String title) {
		return articleRepository.findByTitle(title);
	}

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public List<Article> findAllByTitle(String title) {
		return articleRepository.findAllByTitle(title);
	}
}
