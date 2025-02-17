Feature: Springdoc modules

  Scenario: Should add Springdoc for MVC
    When I apply modules to default project
      | maven-java            |
      | spring-boot           |
      | springdoc-mvc-openapi |
    Then I should have "springdoc-openapi-ui" in "pom.xml"
    And I should have files in "src/main/java/tech/jhipster/chips/technical/infrastructure/primary/springdoc"
      | SpringdocConfiguration.java |
    And I should not have "jwt" in "src/main/java/tech/jhipster/chips/technical/infrastructure/primary/springdoc/SpringdocConfiguration.java"
    And I should have files in "src/main/resources/config"
      | application.properties |
    And I should have files in "src/test/resources/config"
      | application.properties |

  Scenario: Should add Springdoc for Webflux
    When I apply modules to default project
      | maven-java                |
      | spring-boot               |
      | spring-boot-webflux-netty |
      | springdoc-webflux-openapi |
    Then I should have "springdoc-openapi-webflux-ui" in "pom.xml"
    And I should have files in "src/main/java/tech/jhipster/chips/technical/infrastructure/primary/springdoc"
      | SpringdocConfiguration.java |
    And I should not have "jwt" in "src/main/java/tech/jhipster/chips/technical/infrastructure/primary/springdoc/SpringdocConfiguration.java"
    And I should have files in "src/main/resources/config"
      | application.properties |
    And I should have files in "src/test/resources/config"
      | application.properties |

  Scenario: Should apply springdoc oauth2 module
    When I apply modules to default project
      | maven-java            |
      | spring-boot           |
      | springdoc-mvc-openapi |
      | springdoc-oauth2      |
    Then I should have files in "src/main/java/tech/jhipster/chips/technical/infrastructure/primary/springdoc/"
      | SpringdocOAuth2Configuration.java |

  Scenario: Should apply springdoc jwt module
    When I apply modules to default project
      | maven-java            |
      | spring-boot           |
      | springdoc-mvc-openapi |
      | springdoc-jwt         |
    Then I should have files in "src/main/java/tech/jhipster/chips/technical/infrastructure/primary/springdoc/"
      | SpringdocJWTConfiguration.java |
