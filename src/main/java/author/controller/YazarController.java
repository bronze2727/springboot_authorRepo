package author.controller;

import author.beans.Yazar;
import author.repository.YazarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class YazarController {

    private final YazarRepository yazarRepository;

    public YazarController(YazarRepository yazarRepository) {
        this.yazarRepository = yazarRepository;
    }

    @GetMapping("/yazarlar")

    public List<Yazar> getYazarlar() {

        return yazarRepository.findAll();
    }

    @GetMapping("/yazarlar/{id}")

    public Yazar  getYazarById(@PathVariable Long id) {

       return yazarRepository.findById(id).get();

    }
        @PostMapping("/yazarlar")

        public ResponseEntity<Yazar> createYazar (@RequestBody Yazar yazar){
            Yazar newYazar = yazarRepository.save(yazar);
            return ResponseEntity.created(null).body(newYazar);

        }

        @PutMapping("/yazarlar/{id}")
        public ResponseEntity<Yazar> updateYazar (@PathVariable Long id,  @RequestBody Yazar yazar ){

            Optional<Yazar> existingYazar = yazarRepository.findById(id);
            if (existingYazar.isPresent()) {
                Yazar updatedYazar = yazarRepository.save(yazar);
                return ResponseEntity.ok(updatedYazar);
            } else {
                return ResponseEntity.notFound().build();

            }
        }

        @DeleteMapping("/yazarlar{id}")
        public ResponseEntity<Void> deleteYazar (@PathVariable Long id){
            Optional<Yazar> existingYazar = yazarRepository.findById(id);
            if (existingYazar.isPresent()) {
                yazarRepository.deleteById(id);
                return ResponseEntity.noContent().build();

            } else {
                return ResponseEntity.notFound().build();
            }
        }
}
