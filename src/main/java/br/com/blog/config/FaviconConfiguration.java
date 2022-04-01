package br.com.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration 
public class FaviconConfiguration {
	@Controller
	static class FaviconController {
	 
	    @GetMapping("favicon.ico")
	    @ResponseBody
	    void returnNoFavicon() {
	    }
	}
}
