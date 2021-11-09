package tech.jhipster.forge.generator.project.domain;

import static tech.jhipster.forge.common.domain.FileUtils.getPath;
import static tech.jhipster.forge.generator.project.domain.DefaultConfig.BASE_NAME;
import static tech.jhipster.forge.generator.project.domain.DefaultConfig.PACKAGE_NAME;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import tech.jhipster.forge.common.domain.FileUtils;
import tech.jhipster.forge.error.domain.Assert;
import tech.jhipster.forge.error.domain.UnauthorizedValueException;

public class Project {

  private final String folder;
  private final Map<String, Object> config;

  private Project(ProjectBuilder builder) {
    Assert.notBlank("folder", builder.folder);
    Assert.notNull("config", builder.config);

    this.folder = builder.folder;
    this.config = builder.config;
  }

  public static ProjectBuilder builder() {
    return new ProjectBuilder();
  }

  public String getFolder() {
    return folder;
  }

  public Map<String, Object> getConfig() {
    return config;
  }

  public Optional<Object> getConfig(String key) {
    return Optional.ofNullable(config.get(key));
  }

  public void addConfig(String key, Object value) {
    config.putIfAbsent(key, value);
    validateConfig();
  }

  public void addDefaultConfig(String key) {
    DefaultConfig.get(key).ifPresent(value -> addConfig(key, value));
  }

  public Optional<String> getBaseName() {
    return getStringConfig(BASE_NAME);
  }

  public Optional<String> getPackageName() {
    return getStringConfig(PACKAGE_NAME);
  }

  public Optional<String> getPackageNamePath() {
    return getPackageName().map(packageName -> packageName.replaceAll("\\.", File.separator));
  }

  public Optional<String> getStringConfig(String key) {
    Object value = config.get(key);
    if (value == null) {
      return Optional.empty();
    } else if (value instanceof String) {
      return Optional.of((String) value);
    }
    throw new UnauthorizedValueException("The " + key + " is not valid");
  }

  public Optional<Integer> getIntegerConfig(String key) {
    Object value = config.get(key);
    if (value == null) {
      return Optional.empty();
    } else if (value instanceof Integer) {
      return Optional.of((Integer) value);
    }
    throw new UnauthorizedValueException("The " + key + " is not valid");
  }

  private void validateConfig() {
    getBaseName().ifPresent(CheckConfig::validBaseName);
    getPackageName().ifPresent(CheckConfig::validPackageName);
  }

  public boolean isMavenProject() {
    return FileUtils.exists(getPath(getFolder(), "pom.xml"));
  }

  public boolean isGradleProject() {
    return FileUtils.exists(getPath(getFolder(), "build.gradle"));
  }

  public static class ProjectBuilder {

    private String folder;
    private Map<String, Object> config = new HashMap<>();

    public Project build() {
      return new Project(this);
    }

    public ProjectBuilder folder(String folder) {
      this.folder = folder;
      return this;
    }

    public ProjectBuilder config(Map<String, Object> config) {
      if (config != null) {
        this.config = config;
      }
      return this;
    }
  }
}
