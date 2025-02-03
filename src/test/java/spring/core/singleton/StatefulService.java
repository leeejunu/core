package spring.core.singleton;

import org.springframework.stereotype.Component;

public class StatefulService {

//    private int price; //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price; //문제를 해결하기 위한 메소드 수정
    }
}
