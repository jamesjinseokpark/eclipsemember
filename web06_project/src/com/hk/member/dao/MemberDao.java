package com.hk.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.hk.member.dto.Member;

public class MemberDao {
	// * DB접속정보는 어떻게 하지? 생성시에 전달받은걸로 사용?

	Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection; 
	}



	//  CRUD (Create, Retrieve, Update , Delete)
	//	1. 목록 보기(받을 Parameter: x ) (리턴타입:List<Member> */

	public List<Member> selectList(){

		/*JDBC 3:준비를 하고,4: SQL실행하고 ,5: 값이 있으면 받아오고 */

		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String query = "select mno, email, pwd, mname, cre_date, mod_date from members order by mno asc";
		List<Member> members = new ArrayList<Member>(); //다형성


		try {
			pStmt = connection.prepareStatement(query);

			rs = pStmt.executeQuery();

			while(rs.next()) {
				//1개의 Row씩 꺼내주세요.

				Member member = new Member();
				
				member.setMno(rs.getInt("mno"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("pwd"));
				member.setMname(rs.getString("mname"));
				member.setCre_date(rs.getDate("cre_date"));
				member.setMod_date(rs.getDate("mod_date"));
				members.add(member);

			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs !=null)
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pStmt !=null)
				try {
					pStmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}


		return members;
	}


//		2. 상세 정보보기 (받을 Parameter : no) (리턴타입: Member)*
	public Member selectOne(int no) throws Exception {

		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String query = "select mno, email, mname, cre_date from members" + "where mno=" +no;
		Member member = new Member();
		try {
			pStmt = connection.prepareStatement(query);
			rs = pStmt.executeQuery();    
			rs.next();
										
				member.setMno(rs.getInt("MNO"));
				member.setEmail(rs.getString("EMAIL"));
				member.setMname(rs.getString("MNAME"));
				member.setCre_date(rs.getDate("CRE_DATE"));
			
		}catch(Exception e) {
			throw e;
		}finally {

		}
		return member;
	}
	//	3. 추가하기 Member (받을 Parameter : Member) (리턴타입 : 성공여부)*

	public int insert(Member member) throws Exception {

		PreparedStatement pStmt = null;
		int ret;


		try {

			pStmt = connection.prepareStatement("insert into members(mno,email,pwd,mname,cre_date,mod_date)"
					+ " values ( member_seq.nextval, ? , ? , ? , sysdate,sysdate)");
			

			pStmt.setString(1, member.getEmail());
			pStmt.setString(2, member.getPassword());
			pStmt.setString(3, member.getMname());

			ret = pStmt.executeUpdate();

		}catch(Exception e) {
			throw e;

		}finally {

			if(pStmt !=null) 

				try{
					pStmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}


		}

		return ret;

	}
	//	4. 수정하기  Member (받을Parameter : Member) (리턴타입 : 성공여부)*
	public int update(Member member) throws Exception {

		PreparedStatement pStmt = null;

		try {

			pStmt = connection.prepareStatement("update members set email=?, mname=?, pwd=?, mod_date=sysdate where mno=?");

			pStmt.setString(1, member.getEmail());
			pStmt.setString(2, member.getMname());
			pStmt.setString(3, member.getPassword());
			pStmt.setInt(4, member.getMno());

			pStmt.executeUpdate(); // ResultSet


		}catch(Exception e) {
			throw e;

		}finally {

		}



		return 0;

	}

//
//
//	private ServletContext getServletContext() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	//	5. 삭제하기 (받을Parameter :no) (리턴타입 : 성공여부)

	public int delete(int no) {
		
		PreparedStatement stmt = null;
		
		try {
			
				stmt = connection.prepareStatement("delete from members where mno=?");
				System.out.println("Dao delete1 까지 ");
				stmt.setString(1, ("no"));

				System.out.println("Dao delete2 까지 ");
				stmt.executeUpdate(); //ResultSet
				
			
		}catch(Exception e) {
			
		}
		
		
		
		return 0;

	}



}
