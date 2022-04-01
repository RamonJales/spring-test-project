package br.com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
	@GetMapping("/about-us")
	public String getAboutUs() {
		return "about-us/about-us";
	}
	
	@GetMapping("/new-article")
	public String getArticleForm() {
		return "article/article-form";
	}
}
