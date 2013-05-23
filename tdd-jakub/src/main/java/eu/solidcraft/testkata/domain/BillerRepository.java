package eu.solidcraft.testkata.domain;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface BillerRepository extends CrudRepository<Biller, ObjectId> {
}
