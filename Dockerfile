FROM openjdk:17.0.1-jdk-oracle as build

ENV POSTGRESDATABASE=acheibreja
ENV POSTGRESHOST=dpg-chfpbtjhp8u065r2osb0-a
ENV POSTGRESPASSWORD=1135jeLUkOh4Vueb2pIP9ckVKLaYWUxb
ENV POSTGRESPORT=5432
ENV POSTGRESUSER=acheibreja_user

RUN echo "POSTGRESDATABASE=${POSTGRESDATABASE}"
RUN echo "POSTGRESHOST=${POSTGRESHOST}"
RUN echo "POSTGRESPASSWORD=${POSTGRESPASSWORD}"
RUN echo "POSTGRESPORT=${POSTGRESPORT}"
RUN echo "POSTGRESUSER=${POSTGRESUSER}"

RUN echo "definindo pasta de trabalho"
WORKDIR /workspace/app

RUN echo "copiando arquivo mvnw necessario para o build"
COPY achei-breja/mvnw .
RUN echo "copiando arquivo .mvn necessario para o build"
COPY achei-breja/.mvn .mvn
RUN echo "copiando arquivo pom.xml necessario para o build"
COPY achei-breja/pom.xml .
RUN echo "copiando diretorio src necessario para o build"
COPY achei-breja/src src

RUN echo "listando o diretorio"
RUN echo $(ls -l .)

RUN echo "atribuindo permissao maxima para os arquivos"
RUN chmod -R 777 ./mvnw

RUN echo "maven install"
RUN ./mvnw install -DskipTests

RUN echo "criando diretorio de dependencias"
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

RUN echo "inciando docker do Java"
FROM openjdk:17.0.1-jdk-oracle

RUN echo "definindo volume tmp"
VOLUME /tmp

RUN echo "definindo parametro ARGS"
ARG DEPENDENCY=/workspace/app/target/dependency

RUN echo "copiando artefatos para o diretorio de execucao"
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

RUN echo "executando a aplicacao usando comando Java"
#ENTRYPOINT ["java","-cp","app:app/lib/*","tech.afro.pretas.acheibreja.AcheiBrejaApplication"]

RUN echo "executando a aplicacao usando mvn spring-boot"
ENTRYPOINT ["mvn","spring-boot:run"," --debug"]

RUN echo "sucesso"
