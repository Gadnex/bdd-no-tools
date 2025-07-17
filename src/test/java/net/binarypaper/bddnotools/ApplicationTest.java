package net.binarypaper.bddnotools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ApplicationTest {

  @Test
  void contextLoads() {}

  @Test
  void verifiesModularStructure() {
    ApplicationModules modules = ApplicationModules.of(Application.class);
    modules.verify();
  }

  @Test
  void createModuleDocumentation() {
    ApplicationModules modules = ApplicationModules.of(Application.class);
    new Documenter(modules).writeDocumentation().writeIndividualModulesAsPlantUml();
  }
}
