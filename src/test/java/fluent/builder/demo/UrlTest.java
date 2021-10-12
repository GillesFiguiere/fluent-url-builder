package fluent.builder.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UrlTest {
    @Test
    void DevraitConstruireUneUrl() {
        var url = Url.builder()
                .protocole("https")
                .hote("www.google.fr")
                .build()
                .toString();

        assertThat(url).isEqualTo("https://www.google.fr");
    }

    @Test
    void DevraitConstruireUneUrlAvecPort() {
        var url = Url.builder()
                .protocole("https")
                .hote("www.google.fr")
                .port(8080)
                .build()
                .toString();

        assertThat(url).isEqualTo("https://www.google.fr:8080");
    }

    @Test
    void DevraitConstruireUneUrlAvecPortEtUri() {
        var url = Url.builder()
                .protocole("https")
                .hote("www.google.fr")
                .port(8080)
                .uri("/index.html")
                .build()
                .toString();

        assertThat(url).isEqualTo("https://www.google.fr:8080/index.html");
    }
}
