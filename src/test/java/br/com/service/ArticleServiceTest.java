package br.com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import br.com.blog.model.entities.Article;
import br.com.blog.model.service.ArticleService;
import br.com.blog.model.service.serviceImpl.ArticleServiceImpl;

@DataJpaTest
@DisplayName("Classe de teste do ArticleService")
@Import(ArticleServiceImpl.class)
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@Test
	@DisplayName("Metodo save persiste um novo aluno no banco de dados quando bem sucedido")
	void save_Persist_WhenSuccessful() {

		final Article result = articleService.save(new Article("article 1", "autor 1", LocalDate.of(1998, 05, 12),
				"O lorem ipsum é um texto bastante conhecido dos profissionais de design e editoração. Trata-se de um poema em latim, escrito por Cícero em 45 a.C, com as letras embaralhadas. É utilizado no mundo todo para preencher espaços em publicações antes da inserção do conteúdo real."));

		assertAll(() -> assertThat(result).isNotNull(), () -> assertThat(result.getAuthor()).isNotBlank(),
				() -> assertThat(result.getTitle()).isNotBlank(), () -> assertThat(result.getText()).isNotBlank(),
				() -> assertThat(result.getText()).hasSizeGreaterThan(200),
				() -> assertThat(result.getDate()).asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE));
	}
}
