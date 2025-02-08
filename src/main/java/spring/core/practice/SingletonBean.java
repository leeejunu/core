package spring.core.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") //default
@RequiredArgsConstructor
public class SingletonBean {

    public final PrototypeBean prototypeBean;

    public PrototypeBean get() {
        return prototypeBean;
    }
}
