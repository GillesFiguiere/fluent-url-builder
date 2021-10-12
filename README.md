# Démo d'un builder d'Url fluent

## Tests
- Installer JDK 11 à minima.
- Télécharger les dépendances (junit et assertj) et lancer les tests avec :  
````
mvn install 
````
- Relancer les tests avec :  
````
mvn test
````

## Explications
Url builder permet grâce au patron de conception Builder de créer un objet URL cohérent avec à minima un protocole
et un hôte et éventuellement un port et une URI. Bien que l'on puisse utiliser directement plusieurs constructeurs
pour réaliser la même chose, l'intêret du builder est d'être plus expressif et d'éviter de mélanger les paramêtres
du constructeur qui comporte plusieurs string.

Voici un exemple typique d'utilisation :
````
var url = Url.builder()
        .protocole("https")
        .hote("www.google.fr")
        .build();
````
La classe Url n'a pas de constructeur public il n'est donc pas possible de créer un objet de cette façon :
````
var url = new Url();
````
La construction de l'URL est déléguée au Builder auquel on a accès via une méthode statique de la classe Url
````
var urlBuilder = Url.builder();
````
Cette méthode statique retourne une interface UrlBuilderAvecProtocole qui ne permet d'appeler que la méthode 
protocole() afin de spécifier le protocole de l'URL
````
var urlBuilderAvecProtocole = Url.builder();
urlBuilderAvecProtocole.avecProtocole("http");
````
Cette dernière méthode retourne une interface UrlBuilderAvecHote qui ne permet d'appeler que la méthode hote()
afin de spécifier l'hôte de l'URL
````
var urlBuilderAvecProtocole = Url.builder();
var UrlBuilderAvecHote = urlBuilderAvecProtocole.avecProtocole("http");
UrlBuilderAvecHote.avecHote("www.google.com");
````
Cette dernière méthode retourne une interface UrlBuilderAvecOptions qui permet :
- d'ajouter éventuellement un port, ce qui retourne à nouveau une interface UrlBuilderAvecOptions
- d'ajouter éventuellement une URI, ce qui retourne à nouveau une interface UrlBuilderAvecOptions
- de créer l'URL

Comme toutes ces méthodes retournent une instance de la classe UrlBuilder. Il est possible d'enchainer les appels
de méthodes ce qui donne le caractère "fluent".
