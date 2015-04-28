Rakennekuvaus:

Muistipelissä luokka peli hoitaa pelin logiikan. Peli tuntee luokan Pelaaja, joka kertoo pelaajasta tarvittavat tiedot.
Pelaaja-luokka tietää pelaajan nimen, yritysten määrän ja löydetyt parit. Kun uusi peli aloitetaan, pelaajan tiedot nollataan. 

Peli tuntee myös luokan Kortti, jossa on tiedot kortista. Kortit tunnistetaan värien avulla. Kortti asetetaan oletuksellisesti
kääntämättömäksi ja sen väri asetetaan korttia luodessa. 

Käyttöliittymä hoitaa peli-ikkunan, peliin tarvittavien nappuloiden ja pelilaudan piirtämisen pelin logiikan mukaan. 
Käyttöliittymällä on rajapinnat mouselistener, joka kuuntelee hiiren painalluksia ja piirtää sen mukaan pelilautaa uudelleen 
kääntäen kortteja yms, ja actionlistener, joka kuuntelee buttoneiden painamista. Käyttöliittymäluokan sisällä on toinen 
luokka, joka hoitaa pelilaudan piirtämisen. 
