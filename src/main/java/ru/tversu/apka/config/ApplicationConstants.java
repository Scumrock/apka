package ru.tversu.apka.config;


/**
 * Application constants.
 */
public interface ApplicationConstants {

  /**
   * Constant <code>SPRING_PROFILE_DEVELOPMENT="dev"</code>
   */
  String SPRING_PROFILE_DEVELOPMENT = "dev";
  /**
   * Constant <code>SPRING_PROFILE_TEST="test"</code>
   */
  String SPRING_PROFILE_TEST = "test";
  /**
   * Constant <code>SPRING_PROFILE_PRODUCTION="prod"</code>
   */
  String SPRING_PROFILE_PRODUCTION = "prod";
  /**
   * Spring profile used when deploying with Spring Cloud (used when deploying to CloudFoundry)
   * Constant <code>SPRING_PROFILE_CLOUD="cloud"</code>
   */
  String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
}

