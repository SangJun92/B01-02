package org.zerock.b01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b01.domain.Member2;
import org.zerock.b01.dto.MemberDTO2;
import org.zerock.b01.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class MemberServiceImpl implements MemberService {
  private final ModelMapper modelMapper;
  private final MemberRepository memberRepository;

  @Override
  public void register(MemberDTO2 memberDTO2) {
    memberRepository.save(modelMapper.map(memberDTO2, Member2.class));
  }

  @Override
  public MemberDTO2 login(String member_id, String member_pw) {
    Optional<Member2> result = memberRepository.findByIdAndPw(member_id, member_pw);
    Member2 member2 = result.orElseThrow();
    MemberDTO2 memberDTO2 = modelMapper.map(member2, MemberDTO2.class);
    return memberDTO2;
  }
}
















