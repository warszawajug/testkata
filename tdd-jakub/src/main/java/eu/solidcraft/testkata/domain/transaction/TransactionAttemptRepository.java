package eu.solidcraft.testkata.domain.transaction;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface TransactionAttemptRepository extends CrudRepository<TransactionAttempt, ObjectId> {
}
