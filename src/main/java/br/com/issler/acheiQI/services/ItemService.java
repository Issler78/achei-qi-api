package br.com.issler.acheiQI.services;

import br.com.issler.acheiQI.database.models.ItemEntity;
import br.com.issler.acheiQI.database.models.UserEntity;
import br.com.issler.acheiQI.database.repositories.IItemRepository;
import br.com.issler.acheiQI.dtos.CreateItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final IItemRepository itemRepository;
    private final ImageUploaderService imageUploaderService;

    public void save(CreateItemDTO dto, UserEntity user) throws Exception {
        // save image on supabase
        String imageUrl = imageUploaderService.uploadImage(dto.imageBase64());

        try{
            itemRepository.save(ItemEntity.builder()
                    .title(dto.title())
                    .description(dto.description())
                    .location(dto.location())
                    .date(LocalDate.now())
                    .imageUrl(imageUrl)
                    .category(dto.category())
                    .user(user)
                    .build());
        } catch (Exception e){
            throw new Exception("Erro ao tentar salvar item: " + e.getMessage());
        }
    }
}
