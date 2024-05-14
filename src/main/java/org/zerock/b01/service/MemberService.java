package org.zerock.b01.service;

import org.zerock.b01.dto.MemberDTO2;

public interface MemberService {
  void register(MemberDTO2 memberDTO2);
  MemberDTO2 login(String memberId, String memberPw);
}
