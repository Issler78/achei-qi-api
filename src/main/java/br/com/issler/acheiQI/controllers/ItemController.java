package br.com.issler.acheiQI.controllers;

import br.com.issler.acheiQI.database.models.UserEntity;
import br.com.issler.acheiQI.dtos.CreateItemDTO;
import br.com.issler.acheiQI.services.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/items")
@RequiredArgsConstructor
@Validated
public class ItemController {
    private final ItemService itemService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody CreateItemDTO dto, @AuthenticationPrincipal UserEntity user) throws Exception {
        itemService.save(dto, user);
    }
}
