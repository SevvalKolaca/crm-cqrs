package crm.cqrs.crm.cqrs.persistance.category;

import crm.cqrs.crm.cqrs.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByIsActiveTrue();
    Optional<Category> findByName(String name);
    List<Category> findByParentId(Integer parentId);

    /* Subcategory icin islemler */
    // Belirli bir parent ID'ye bağlı tüm alt kategorileri bul
    @Query("SELECT c FROM Category c WHERE c.parent.id = :parentId")
    List<Category> findAllByParentId(@Param("parentId") Integer parentId);

    // Belirli bir isim ve parent ID'ye göre bir kategori bul
    @Query("SELECT c FROM Category c WHERE c.name = :name AND c.parent.id = :parentId")
    Optional<Category> findByNameAndParentId(@Param("name") String name, @Param("parentId") Integer parentId);

    // Belirli bir parent ID'ye bağlı ve aktif olan tüm alt kategorileri bul
    @Query("SELECT c FROM Category c WHERE c.parent.id = :parentId AND c.isActive = :isActive")
    List<Category> findByParentIdAndIsActive(@Param("parentId") Integer parentId, @Param("isActive") Boolean isActive);

    // Sadece aktif olan kategorileri bul
    List<Category> findByIsActive(Boolean isActive);

}
