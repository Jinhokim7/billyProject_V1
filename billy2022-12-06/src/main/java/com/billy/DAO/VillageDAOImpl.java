package com.billy.DAO;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.billy.VO.VillagePageVO;
import com.billy.VO.VillageReplyVO;
import com.billy.VO.VillageVO;

@Repository
public class VillageDAOImpl implements IF_villageDAO {
	
	private static String mapperQuery = "com.billy.DAO.IF_villageDAO";
	
	@Inject	
	private SqlSession sqlSession;

	@Override
	public void insertVillage(VillageVO vvo) {
		sqlSession.insert(mapperQuery + ".insertVillage",vvo);
		System.out.println(vvo.getvId()+"--DAO단 빌리지인서트 디버깅");
	}
	
	@Override
	public void insertAttach_v(String filename) {
		sqlSession.insert(mapperQuery + ".insertAttach_v", filename);
		System.out.println(filename+"--DAO단 빌리지 첨부파일 디버깅");
	}

	@Override
	public List<VillageVO> selectAllVillage(VillagePageVO vpvo) {
		System.out.println("--DAO단 빌리지전체보기 디버깅");
		return sqlSession.selectList(mapperQuery + ".selectAllVillage",vpvo);	
	}

	@Override
	public int selectNum() {
		System.out.println("--DAO단 글번호가져오기 디버깅");
		return sqlSession.selectOne(mapperQuery + ".selectNum");
	}
	@Override
	public VillageVO selectOneVillage(int vNum) {
		System.out.println(vNum+"--DAO단 글자세히보기 디버깅");
		return sqlSession.selectOne(mapperQuery + ".selectOneVillage",vNum);
	}

	@Override
	public List<String> selectAttach_v(int vNum) throws Exception {
		System.out.println(vNum+"--DAO단 첨부파일 자세히보기 디버깅");
		return sqlSession.selectList(mapperQuery + ".selectAttach_v",vNum);
	}

	@Override
	public void insertVillageReply_1(VillageReplyVO vrvo) {
		sqlSession.insert(mapperQuery + ".insertVillageReply_1",vrvo);
		System.out.println(vrvo.getR1Id()+"--DAO단 빌리지댓글 1인서트 디버깅");	
	}

	@Override
	public List<VillageReplyVO> selectVillageReply_1(int vNum) {
		System.out.println(vNum+"--DAO단 빌리지 댓글 자세히보기 디버깅");
		return sqlSession.selectList(mapperQuery + ".selectVillageReply_1",vNum);
	}

	@Override
	public int selectReplyNum(int vNum) {
		System.out.println("--DAO단 댓글번호가져오기 디버깅");
		return sqlSession.selectOne(mapperQuery + ".selectReplyNum",vNum);
	}

	@Override
	public void updateVillageCnt(int vNum) {
		System.out.println("--DAO단 빌리지 조회수 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".updateVillageCnt", vNum);
	}

	@Override
	public int selectVillgeBoardCnt() {
		System.out.println("--DAO단 빌리지 개수 가져오기 디버깅");
		return sqlSession.selectOne(mapperQuery + ".selectVillgeBoardCnt");
	}

	@Override
	public void deleteVillageBoard(int vNum) {
		System.out.println("--DAO단 빌리지 삭제 디버깅");
		sqlSession.update(mapperQuery + ".deleteVillageBoard", vNum);
	}

	@Override
	public void updateVillageBoardMemberId(String id) {
		System.out.println("--DAO단 회원탈퇴시 빌리지 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".updateVillageBoardMemberId", id);
	}

	@Override
	public void updateVillageReply_1MemberId(String id) {
		System.out.println(id+"--DAO단 회원탈퇴시 빌리지 댓글 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".updateVillageReply_1MemberId", id);
		
	}

	@Override
	public void updateVillageBoard(VillageVO vvo) {
		System.out.println("--DAO단 빌리지 게시글 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".updateVillageBoard", vvo);
	}
	
	@Override
	public void deleteVillageAttach(VillageVO vvo) {
		System.out.println("--DAO단 빌리지첨부파일 삭제 디버깅");
		sqlSession.delete(mapperQuery + ".deleteVillageAttach", vvo);
	}

	@Override
	public void updateVillageAttach(Map<String,String> map) {
		System.out.println("--DAO단 빌리지첨부파일 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".updateVillageAttach", map);
	}

	@Override
	public List<VillageVO> selectVillageTitle(VillagePageVO vpvo) {
		System.out.println("--DAO단 빌리지 제목 검색  디버깅");
		return sqlSession.selectList(mapperQuery + ".selectVillageTitle", vpvo);
	}

	@Override
	public List<VillageVO> selectVillageTitleText(VillagePageVO vpvo) {
		System.out.println("--DAO단 빌리지 제목+내용 검색  디버깅");
		return sqlSession.selectList(mapperQuery + ".selectVillageTitleText", vpvo);
	}

	@Override
	public List<VillageVO> selectVillageWriter(VillagePageVO vpvo) {
		System.out.println("--DAO단 빌리지 작성자 검색  디버깅");
		return sqlSession.selectList(mapperQuery + ".selectVillageWriter", vpvo);
	}

	@Override
	public void deleteVillageReply(Map<String, String> map) {
		System.out.println("--DAO단 빌리지첨부파일 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".deleteVillageReply", map);
	}

	@Override
	public void updateVillageReply(VillageReplyVO vrvo) {
		System.out.println("--DAO단 댓글 업데이트 디버깅");
		sqlSession.update(mapperQuery + ".updateVillageReply", vrvo);
	}

	/*
	 * @Override public VillageReplyVO selectVillageReplyOne(VillageReplyVO vrvo) {
	 * System.out.println("--DAO단 댓글하나 검색 디버깅"); return
	 * sqlSession.selectOne(mapperQuery + ".selectVillageReplyOne", vrvo); }
	 */
}
