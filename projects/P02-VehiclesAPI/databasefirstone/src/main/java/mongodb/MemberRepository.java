package mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {

    public Optional<Member> findByLastName(String lastName);
}
