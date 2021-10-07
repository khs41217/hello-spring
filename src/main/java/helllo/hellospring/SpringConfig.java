package helllo.hellospring;

import helllo.hellospring.repository.MemberRepository;
import helllo.hellospring.repository.MemoryMemberRepository;
import helllo.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig{

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();


    }
}
