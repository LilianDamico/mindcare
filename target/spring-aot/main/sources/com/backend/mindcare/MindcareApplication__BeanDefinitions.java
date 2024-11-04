package com.backend.mindcare;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MindcareApplication}.
 */
@Generated
public class MindcareApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'mindcareApplication'.
   */
  public static BeanDefinition getMindcareApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MindcareApplication.class);
    beanDefinition.setTargetType(MindcareApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(MindcareApplication.class);
    beanDefinition.setInstanceSupplier(MindcareApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
