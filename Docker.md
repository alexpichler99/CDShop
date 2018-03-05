**MySQL**

1. Ordner db erstellen und darin create.sql und Dockerfile erstellen
create.sql:
![](./images/1.png) 
Dockerfile:
![](./images/2.png)
create.sql erstellt das Schema und einen User, der von außen darauf zugreifen darf.

2. Das Image für die Datenbank von der Dockerfile builden
![](./images/3.png)
3. Die Datenbank im Hintergrund starten und den Port der DB freigeben.
![](./images/4.png)
4. Überprüfen, ob die DB funktioniert
![](./images/5.png)

**Wildfly**

1. Dockerfile im Root des Projekts erstellen
![](./images/6.png)
2. Customization Ordner erstellen und darin den mysql jdbc connector kopieren
3. execute.sh in den customization Ordner kopieren
4. IP des mysql Containers ermitteln
![](./images/8.png)
![](./images/7.png)
5. DB-Connection Variablen in execute.sh setzen
![](./images/9.png)
6. Dateinamen der war File anpassen
![](./images/10.png)
7. execute.sh ausführbar machen
![](./images/11.png)
8. Image von der Dockerfile builden
![](./images/12.png)
9. Container mit dem wilfly Image im Hintergrund starten und den Port des Wilflies zur Verfügung stellen
![](./images/13.png)
10. Überprüfen, ob alles funktioniert
![](./images/14.png)
11. Die Tabellen der DB wurden automatisch erstellt
![](./images/15.png)

**Compose**
Um nicht jedes mal beide Container starten zu müssen, verwenden wir docker-compose

1. docker-compose.yml im Root des Projekts erstellen
![](./images/16.png)
2. Den Hostname der DB auf den Namen des Services ändern, da wir dank Compose keine IPs mehr verwenden müssen.
![](./images/18.png)
3. Die Images mithilfe von docker-compose builden
![](./images/17.png)
4. Compose starten
![](./images/19.png)

**Ende**
Mithilfe von Docker und Compose können wir unserere Applikationen entwickeln und es wird gewährleistet, dass es auf allen Systemen gleich läuft.