package com.billy.DAO;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.billy.VO.BillyGoodsAttachVO;
import com.billy.VO.BillyGoodsLikeVO;
import com.billy.VO.BillyGoodsRentVO;
import com.billy.VO.BillyGoodsVO;

@Repository
public class BillyDAOImpl implements IF_billyDAO {

	private static String mapperQuery = "com.billy.DAO.IF_billyDAO";

	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertBilly(BillyGoodsVO bvo) throws Exception {
		sqlSession.insert(mapperQuery + ".insertBilly", bvo); // billy맵핑
		System.out.println(bvo.getId() + "-------DAO(billy등록 디버깅)");
	}

	@Override
	public int selectMaxCnt() throws Exception {
		System.out.println(sqlSession.selectOne(mapperQuery + ".selectMaxCnt") + "-------DAO(글번호마지막 디버깅)");
		return sqlSession.selectOne(mapperQuery + ".selectMaxCnt");
	}

	@Override
	public void insertAttach(String filename) throws Exception {
		sqlSession.insert(mapperQuery + ".billyAttach", filename);
		System.out.println(filename + "-------DAO(파일네임 디버깅)");
	}

	@Override
	public List<BillyGoodsVO> selectBillyAll() {
		System.out.println(sqlSession.selectList(mapperQuery+".selectAllBilly")+"---DAO 빌리전체보기 디버깅");		
		return sqlSession.selectList(mapperQuery+".selectAllBilly");
	}

	@Override
	public List<BillyGoodsAttachVO> selectBillyAttach() {
		System.out.println(sqlSession.selectList(mapperQuery+".selectAllBillyAttach")+"DAO단 All빌리첨부파일 디버깅");		
		return sqlSession.selectList(mapperQuery+".selectAllBillyAttach");
	}
	

	@Override
	public BillyGoodsVO selectBillyOne(String vno) {
	System.out.println(sqlSession.selectOne(mapperQuery+".selectOneBilly", vno)+"DAO단 빌리자세히보기 디버깅");
		return sqlSession.selectOne(mapperQuery+".selectOneBilly", vno);
	}


	@Override
	public List<BillyGoodsAttachVO> selectOneBillyAttach(String vno) {
		System.out.println(vno+"----DAO단 빌리자세히보기(파일)글번호값 디버깅");
		return sqlSession.selectList(mapperQuery+".selectOneBillyAttach",vno);
	}

	@Override
	public void updateBilly(BillyGoodsVO bvo) throws Exception {
		System.out.println(bvo.getgNum()+"----DAO단 빌리수정 글번호 디버깅");		
		sqlSession.update(mapperQuery+".updateBilly", bvo);
	
	}

	@Override
	public void updateBillyMemberId(String id) throws Exception {
		System.out.println(id+"----DAO단 탈퇴시 빌리처리 id 디버깅");	
		sqlSession.update(mapperQuery+".updateBillyMemberId", id);		
	}

	@Override
	public int selectCntBillyLike(BillyGoodsLikeVO blvo) throws Exception {
		System.out.println(blvo.getgNum()+"----DAO단 빌리자세히보기(좋아요클릭유무) gNum디버깅");
		return sqlSession.selectOne(mapperQuery+".selectCntBillyLike", blvo);
	}

	@Override
	public void billyLikeUp(BillyGoodsLikeVO blvo) throws Exception {
		sqlSession.insert(mapperQuery+".billyLikeUp", blvo);
		System.out.println(blvo.getgNum()+"---DAO단 likeUp디버깅");		
	}

	@Override
	public void billyLikeDown(BillyGoodsLikeVO blvo) throws Exception {
		sqlSession.delete(mapperQuery+".billyLikeDown", blvo);
		System.out.println(blvo.getgNum()+"---DAO단 likeDown디버깅");				
	}

	@Override
	public String selectOnebillyName(String vno) throws Exception {
		System.out.println(vno+"----DAO단 selectOne name디버깅");
		return sqlSession.selectOne(mapperQuery+".selectOnebillyName", vno);
	}

	@Override
	public void insertBilleyTransaction(BillyGoodsRentVO brvo) throws Exception {
		System.out.println(brvo.getId()+"----DAO단 insertBilleyTransaction 디버깅");
		sqlSession.insert(mapperQuery+".insertBillyTransaction", brvo);		
	}

	@Override
	public List<String> selectBillyRentdate(String gNum) throws Exception {
		System.out.println(gNum+"---DAO단 selectBillyRentdate 디버깅 ");
		return sqlSession.selectList(mapperQuery+".selectBillyRentdate", gNum);
	}

	@Override
	public void deleteBillyAttach(BillyGoodsVO bvo) throws Exception {
		System.out.println("---DAO단 deleteBillyAttach 디버깅 ");
		sqlSession.delete(mapperQuery+".deleteBillyAttach", bvo);	
	}

	@Override
	public void updateBillyAttach(Map<String,String> map) throws Exception {
		System.out.println("---DAO단 updateBillyAttach 디버깅 ");
		sqlSession.delete(mapperQuery+".updateBillyAttach", map);	
	}

	@Override
	public void deleteBillyAttachGnum(String vno) throws Exception {
		System.out.println(vno+"---DAO단 deleteBillyAttachGnum 디버깅 ");
		sqlSession.delete(mapperQuery+".deleteBillyAttachGnum", vno);
	}

	@Override
	public void updateBillyTransactionNo_1(String vno) throws Exception {
		System.out.println(vno+"---DAO단 updateBillyTransactionNo_1 디버깅 ");
		sqlSession.update(mapperQuery+".updateBillyTransactionNo_1", vno);		
	}

	@Override
	public void deleteBillyGoods(String vno) throws Exception {
		System.out.println(vno+"---DAO단 deleteBillyGoods 디버깅 ");
		sqlSession.delete(mapperQuery+".deleteBillyGoods", vno);		
	}

	@Override
	public void deleteBillyBookmark(String vno) throws Exception {
		sqlSession.delete(mapperQuery+".deleteBillyBookmark", vno);		
	}

}