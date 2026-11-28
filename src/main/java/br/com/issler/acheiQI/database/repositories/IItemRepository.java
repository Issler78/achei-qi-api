package br.com.issler.acheiQI.database.repositories;

import br.com.issler.acheiQI.database.models.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IItemRepository extends JpaRepository<ItemEntity, UUID> {
}
