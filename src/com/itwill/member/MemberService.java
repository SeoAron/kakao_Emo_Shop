package com.itwill.member;

import java.util.ArrayList;

import com.itwill.exception.PasswordMismatchException;
import com.itwill.exception.UserNotFoundException;


public class MemberService {
	private MemberDao memberDao;
	
	public MemberService() throws Exception{
		memberDao = new MemberDao();
	}
	
	/*
	 * create
	 */
	public boolean create(Member member) throws Exception{
		return memberDao.create(member);
	}
	
	/*
	 * read one
	 */
	public Member findMember(String m_id) throws Exception{
		return memberDao.findMember(m_id);
	}
	
	/*
	 * read all
	 */
	public ArrayList<Member> selectAll() throws Exception{
		return memberDao.selectAll();
	}
	
	/*
	 * delete
	 */
	public int remove(String m_id) throws Exception{
		return memberDao.remove(m_id);
	}
	
	/*
	 * update
	 */
	public int update(Member member) throws Exception{
		return memberDao.update(member);
	}
	
	/*
	 * 아이디중복체크
	 * 
	 */
//	public boolean isDuplcateUserId(String userId) throws Exception{
//		boolean isExist = userDao.existedUser(userId);
//		if(isExist) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	/*
	 * 회원 로그인
	 */
	public Member login(String m_id,String m_pass) 
			throws UserNotFoundException,PasswordMismatchException,Exception{
		//1.아이디존재여부
		Member findUser = memberDao.findMember(m_id);
		if(findUser==null) {
			throw new UserNotFoundException(m_id+" 는 존재하지않는 아이디입니다");
		}
		//2.패쓰워드일치여부
		if(!findUser.MatchPass(m_pass)) {
			throw new PasswordMismatchException("패쓰워드가 일치하지않습니다");
		}
		
		return findUser;
	}
	/*
	 * 회원1명보기
	 */
	public Member findUser(String m_id)throws UserNotFoundException,Exception {
		Member findUser = memberDao.findMember(m_id);
		if(findUser==null) {
			throw new UserNotFoundException(m_id+" 는 존재하지않는 아이디입니다.");
		}
		return findUser;
	}

	
}
