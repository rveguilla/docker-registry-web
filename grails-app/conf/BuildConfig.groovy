grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test   : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
    // configure settings for the run-app JVM
    run    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
    // configure settings for the run-war JVM
    war    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits("global") {
    // specify dependency exclusions here; for example, uncomment this to disable ehcache:
    // excludes 'ehcache'
    excludes "grails-docs"
  }
  log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  checksums true // Whether to verify checksums on resolve
  legacyResolve false
  // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

  repositories {
    inherits true // Whether to inherit repository definitions from plugins

    grailsPlugins()
    grailsHome()
    mavenLocal()
    grailsCentral()
    mavenCentral()
    // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
    //mavenRepo "http://repository.codehaus.org"
    //mavenRepo "http://download.java.net/maven/2/"
    //mavenRepo "http://repository.jboss.com/maven2/"
  }

  environments {
    development {
      plugins {
        build ":tomcat:7.0.55.2" // or ":tomcat:8.0.20"
      }
    }
  }

  dependencies {
    // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
    // runtime 'mysql:mysql-connector-java:5.1.29'
    // runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
    //   test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
    runtime 'org.bouncycastle:bcprov-jdk15on:1.52'
    runtime 'org.bouncycastle:bcpkix-jdk15on:1.52'
    runtime 'org.yaml:snakeyaml:1.8'
    //to prevent org.h2.jdbc.JdbcSQLException: Feature not supported: "isWrapperFor"
    runtime 'com.h2database:h2:1.4.187'
  }

  plugins {
    // plugins for the build system only
    build ':tomcat:8.0.30' // or ":tomcat:7.0.55.3"

    // plugins for the compile step
    //compile ":scaffolding:2.1.2"
    //compile ':cache:1.1.8'
    compile ":asset-pipeline:2.1.5"

    // plugins needed at runtime but not for compilation
    runtime ":hibernate4:4.3.8.1" // or ":hibernate:3.6.10.18"
//    runtime ":database-migration:1.4.0"
    runtime ":jquery:1.11.1"

    compile ":rest-client-builder:2.1.1"
    compile "org.grails.plugins:cache:1.1.8"
    compile "org.grails.plugins:cache-ehcache:1.0.5"

    // Uncomment these to enable additional asset-pipeline capabilities
    //compile ":sass-asset-pipeline:1.9.0"
    //compile ":less-asset-pipeline:1.10.0"
    //compile ":coffee-asset-pipeline:1.8.0"
    //compile ":handlebars-asset-pipeline:1.3.0.3"
    compile ":twitter-bootstrap:3.3.4"

    // for formatting relative timestamps
    compile ":pretty-time:2.1.3.Final-1.0.1"
    compile "org.grails.plugins:spring-security-core:2.0.0"
  }
}

grails.server.port.http = 8080

grails.tomcat.jvmArgs = [
    "-Dorg.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH=true"
]