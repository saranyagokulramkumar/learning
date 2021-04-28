package learning.springboot.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

    @Autowired
    MobileProcessor cpu;

    public void config(){

        System.out.println("Octa core, 4gb ram, 12MP camera");
        cpu.process();
    }
}
