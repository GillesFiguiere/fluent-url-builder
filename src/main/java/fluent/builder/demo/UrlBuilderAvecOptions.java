package fluent.builder.demo;

public interface UrlBuilderAvecOptions {
    UrlBuilderAvecOptions port(int port);

    UrlBuilderAvecOptions uri(String uri);

    Url build();
}
