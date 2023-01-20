package DestinyBack;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<DestinyItem, Long> {
    @Query(value = "SELECT data FROM testing WHERE JSON_EXTRACT(`data`, '$.hash') = :item_hash", nativeQuery = true)
    @JsonCreator
    String findDestinyItemByHash(@Param("item_hash") long item_hash);

    @Query(value = "SELECT data FROM testing WHERE JSON_EXTRACT(`data`, '$.hash') IN (:item_hash)", nativeQuery = true)
    @JsonCreator
    List<String> findDestinyItemsByHash(@Param("item_hash") ArrayList<Long> item_hash);

    @Query(value = "SELECT data" +
            " FROM testing;", nativeQuery = true)
    @JsonCreator
    List<String> findAllDestinyItems();
    @Query(value = "SELECT data FROM testing WHERE JSON_EXTRACT(`data`, '$.itemType') = :item_type", nativeQuery = true)
    @JsonCreator
    List<String> findAllByItemType(@Param("item_type") int item_type);

    @Query(value = "SELECT data FROM testing WHERE JSON_EXTRACT(`data`, '$.itemTypeDisplayName') = :display_name", nativeQuery = true)
    @JsonCreator
    List<String> findAllByDisplayName(@Param("display_name") String display_name);
}
