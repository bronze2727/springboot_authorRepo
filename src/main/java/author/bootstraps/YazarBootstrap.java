package author.bootstraps;

import author.beans.Yazar;
import author.repository.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;

@Component

public class YazarBootstrap implements CommandLineRunner {
@Autowired
YazarRepository yazarRepository;


    @Override
    public void run(String... args) throws Exception {
        Yazar yazar1 = new Yazar(1L,"Ahmet","Koc");
        Yazar yazar2 = new Yazar(2L,"Mehmet","Yilmaz");

        yazarRepository.save(yazar1);
        yazarRepository.save(yazar2);

    }
}
