package DestinyBack;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<DestinyItem, Long> {
    @Query(value = "SELECT data" +
            " FROM testing WHERE JSON_EXTRACT(`data`, '$.hash') = :item_hash", nativeQuery = true)
    @JsonCreator
    JSONObject findDestinyItemByHash(@Param("item_hash") long item_hash);

    @Query(value = "SELECT data" +
            " FROM testing;", nativeQuery = true)
    @JsonCreator
    List<JSONObject> findAllDestinyItems();
    @Query(value = "SELECT data FROM testing WHERE JSON_EXTRACT(`data`, '$.itemType') = :item_type", nativeQuery = true)
    @JsonCreator
    List<JSONObject> findAllByItemType(@Param("item_type") int item_type);

    @Query(value = "SELECT data FROM testing WHERE JSON_EXTRACT(`data`, '$.itemTypeDisplayName') = :display_name", nativeQuery = true)
    @JsonCreator
    List<JSONObject> findAllByDisplayName(@Param("display_name") String display_name);
}
