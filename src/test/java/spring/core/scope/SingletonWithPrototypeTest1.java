package spring.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean = ac.getBean(PrototypeBean.class);
        bean.addCount();
        Assertions.assertThat(bean.getCnt()).isEqualTo(1);

        PrototypeBean beanCopy = ac.getBean(PrototypeBean.class);
        beanCopy.addCount();
        Assertions.assertThat(beanCopy.getCnt()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int cnt1 = clientBean1.logic();
        Assertions.assertThat(cnt1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int cnt2 = clientBean1.logic();
        Assertions.assertThat(cnt2).isEqualTo(2);
    }

    @Scope("singleton")
    @Component
    static class ClientBean {

        /**
         * provider 스프링 컨테이너에서 스프링 빈을 찾아주는 기능을 가짐
         */
//        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        private Provider<PrototypeBean> provider;

        private int logic() {
//            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
//            prototypeBean.addCount();
//            return prototypeBean.getCnt();

            PrototypeBean prototypeBean = provider.get();
            return prototypeBean.getCnt();
        }
    }

    @Scope("prototype")
    @Component
    static class PrototypeBean {
        private int cnt = 0;

        public void addCount() {
            cnt++;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}
