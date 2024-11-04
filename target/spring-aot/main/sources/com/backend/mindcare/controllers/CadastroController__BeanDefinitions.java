package com.backend.mindcare.controllers;

import com.backend.mindcare.domain.cadastro.CadastroRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CadastroController}.
 */
@Generated
public class CadastroController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'cadastroController'.
   */
  private static BeanInstanceSupplier<CadastroController> getCadastroControllerInstanceSupplier() {
    return BeanInstanceSupplier.<CadastroController>forConstructor(CadastroRepository.class)
            .withGenerator((registeredBean, args) -> new CadastroController(args.get(0)));
  }

  /**
   * Get the bean definition for 'cadastroController'.
   */
  public static BeanDefinition getCadastroControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CadastroController.class);
    beanDefinition.setInstanceSupplier(getCadastroControllerInstanceSupplier());
    return beanDefinition;
  }
}
