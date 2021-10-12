package fluent.builder.demo;

import static java.util.Optional.ofNullable;

public class Url {
    private String hote;
    private String protocole;
    private Integer port;
    private String uri;

    private Url() {}

    public static UrlBuilderAvecProtocole builder() {
        return new UrlBuilder();
    }

    @Override
    public String toString() {
        return protocole + "://"
                + hote
                + ofNullable(port).map(p -> ":" + p).orElse("")
                + ofNullable(uri).orElse("");
    }

    private static class UrlBuilder implements UrlBuilderAvecProtocole, UrlBuilderAvecHote, UrlBuilderAvecOptions {
        private Url url = new Url();

        @Override
        public UrlBuilderAvecHote protocole(String protocole) {
            url.protocole = protocole;
            return this;
        }

        @Override
        public UrlBuilder hote(String hote) {
            url.hote = hote;
            return this;
        }

        @Override
        public UrlBuilderAvecOptions port(int port) {
            url.port = port;
            return this;
        }

        @Override
        public UrlBuilderAvecOptions uri(String uri) {
            url.uri = uri;
            return this;
        }

        @Override
        public Url build() {
            return url;
        }
    }
}
