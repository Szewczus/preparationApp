# 1. Użycie obrazu bazowego z Java 21 (slim - oparty na Debianie)
FROM openjdk:21-slim

# 2. Ustawianie zmiennej katalogu roboczego w kontenerze
WORKDIR /app

# 3. Kopiowanie pliku JAR aplikacji do kontenera
# Zakłada, że wcześniej zbudowałeś aplikację i plik JAR znajduje się w folderze `target/`
COPY target/preparationApp-0.0.1-SNAPSHOT.jar preparationApp-0.0.1-SNAPSHOT.jar

# 4. Otwieranie portu aplikacji (np. 8080)
EXPOSE 8080

# 5. Komenda startowa do uruchomienia aplikacji Spring Boot
CMD ["java", "-jar", "preparationApp-0.0.1-SNAPSHOT.jar"]
