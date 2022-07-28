FROM gradle:7.1.0-jdk11

COPY . /usr/src/app

WORKDIR /usr/src/app

CMD ["gradle", "bootRun"]

EXPOSE 3000
