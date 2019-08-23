package mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

    @Autowired
    MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(MemberRepository memberRepository) {
        return args -> {
            Member member = new Member();
            member.setFirstName("Alena");
            member.setLastName("Lengyel");
            member.setAge(33);
            member.setGender("female");
            member.setInterests(new String[]{"crossfit", "swimming"});
            member.setBalance(152.35);

            Member m = new Member();
            m.setFirstName("Lukas");
            m.setLastName("Lengyel");
            m.setGender("male");

            memberRepository.save(member);
            memberRepository.save(m);

            for(Member mb : memberRepository.findAll()) {
                Optional<Member> optionalMember = memberRepository.findByLastName("Lengyel");
                if(optionalMember.isPresent()) {
                    System.out.println(optionalMember.get().getFirstName());
                }
            }
        };
    }
}
