package fr.kleecontrib.domain.id;

public record ArticleId(long value) {

	public static ArticleId hydrate(long value) {
		return new ArticleId(value);
	}
}
