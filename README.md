# rejex

Web app for testing Java regular expressions

## Usage
Launch the application by issuing one of the following commands:

```shell
lein run <port>
lein ring server
```

You can generate a standalone jar and run it:

```shell   
lein uberjar
java -jar target/rejex-0.1.0-SNAPSHOT-standalone.jar
```

You can also generate a war to deploy on a server like Tomcat, Jboss...

```shell
lein ring uberwar
```

## License

Copyright © 2013 Eric Prunier

Distributed under the Eclipse Public License, the same as Clojure.
