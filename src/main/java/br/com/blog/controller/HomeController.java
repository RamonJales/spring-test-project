package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.blog.model.repository.ArticleRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("articleList", articleRepository.findAll());
		return "/home/index";
	}
	
	@GetMapping("/article/{title}")
	public String getArticleDetails(Model model, @PathVariable("title") String title) {
		model.addAttribute("article", articleRepository.findByTitle(title));
		return "article/articleDetails";
	}
}