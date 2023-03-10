package com.works.restcontrollers;
import com.works.entities.Basket;
import com.works.services.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@RestController
@RequestMapping("basket")
@Validated
public class BasketRestController {

    final BasketService basketService;

    public BasketRestController(BasketService basketService) {

        this.basketService = basketService;
    }


    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Basket basket){
        return basketService.add(basket);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id){
        return basketService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(Long id,@NotNull(message = "Miktar boş olamaz") @Min(value = 1,message = "En az 1 adet eklemelisiniz") Integer quantity){
        return basketService.update(id,quantity);
    }
    @GetMapping("/user")
    public ResponseEntity getBasketList_by_User(@RequestParam @Email(message = "E-posta Format Hatası") @NotBlank(message = "E-posta boş bırakılamaz") String email){
        return basketService.getBasketList_by_User(email);
    }
    @PostMapping("/bulkdeletebasket")
    public ResponseEntity bulkDeleteBasket(){
        return basketService.bulkDeleteBasket();
    }
}