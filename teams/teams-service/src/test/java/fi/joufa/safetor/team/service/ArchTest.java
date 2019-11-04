package fi.joufa.safetor.team.service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

  @Test
  void dependecyTest() {
    JavaClasses importedClasses =
        new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("fi.joufa.safetor.teams.service", "fi.joufa.safetor.teams.domain");

    noClasses()
        .that()
        .resideInAnyPackage("..service..")
        .or()
        .resideInAnyPackage("..repository..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("..fi.joufa.safetor.teams.service.web..")
        .because("Hep")
        .check(importedClasses);

    noClasses()
        .that()
        .resideInAnyPackage("..domain..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("..fi.joufa.safetor.teams.service..")
        .because("Domain")
        .check(importedClasses);
  }
}
