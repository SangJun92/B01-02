package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.b01.domain.Member;
import org.zerock.b01.domain.MemberRole;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private  MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers() {
        // 1~100까지 반복하기 위한 스트림
        IntStream.rangeClosed(1, 100).forEach(i -> {
            // 회원 생성 1~100
            Member member = Member.builder()
                    .mid("member" + i)
                    // 비밀번호 암호화
                    .mpw(passwordEncoder.encode("1111"))
                    .email("email" + i + "@aaa.bbb")
                    .build();

            // 일반회원의 권한 설정
            member.addRole(MemberRole.USER);

            if (i >= 90) {
                // 관리자 권한 설정
                member.addRole(MemberRole.ADMIN);
            }
            // 데이터베이스에 저장
            memberRepository.save(member);
        });
    }
}
