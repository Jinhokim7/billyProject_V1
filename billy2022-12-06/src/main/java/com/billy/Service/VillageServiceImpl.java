package com.billy.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.billy.DAO.IF_villageDAO;
import com.billy.VO.VillagePageVO;
import com.billy.VO.VillageReplyVO;
import com.billy.VO.VillageVO;

@Service
public class VillageServiceImpl implements IF_villageService{

	@Inject
	private IF_villageDAO villageDao;

	@Override
	public void insertVillage(VillageVO vvo) throws Exception {
		System.out.println("서비스단 시작");
		System.out.println(vvo.getvId()+"서비스단 빌리지 인서트 디버깅");
		villageDao.insertVillage(vvo);
		String [] fname= vvo.getFiles();
		System.out.println(fname+"파일이름");
		if(fname != null) {
	         for(int i = 0 ; i < fname.length; i++) {
	            if(fname[i]!=null) {
	               villageDao.insertAttach_v(fname[i]);
	               System.out.println(fname[i]+"서비스단 빌리지 첨부파일 인서트 디버깅");
	            }            
	         }
	      }
	}

	@Override
	public void insertAttach_v(String filename) {
		villageDao.insertAttach_v(filename);
		System.out.println(filename+"서비스단 파일이름 디버깅");
	}
	
	@Override
	public List<VillageVO> selectAllVillage(VillagePageVO vpvo) {
		System.out.println("서비스단 빌리지 리스트 디버깅");
		return villageDao.selectAllVillage(vpvo);
	}

	@Override
	public int selectNum() {
		System.out.println("서비스단 빌리지 넘버 디버깅");
		return villageDao.selectNum();
	}

	@Override
	public VillageVO selectOneVillage(int vNum) {
		System.out.println(vNum+"서비스단 빌리지 자세히보기 디버깅");
		return villageDao.selectOneVillage(vNum);
	}

	@Override
	public List<String> selectAttach_v(int vNum) throws Exception {
		System.out.println(vNum+"서비스단 첨부파일 자세히보기 디버깅");
		return villageDao.selectAttach_v(vNum);
	}

	@Override
	public void insertVillageReply_1(VillageReplyVO vrvo) {
		villageDao.insertVillageReply_1(vrvo);
		System.out.println("서비스단 빌리지 댓글 1 인서트 디버깅");
	}

	@Override
	public List<VillageReplyVO> selectVillageReply_1(int vNum) {
		System.out.println("서비스단 빌리지 댓글 1 셀렉트 디버깅");
		return villageDao.selectVillageReply_1(vNum);
	}

	@Override
	public int selectReplyNum(int vNum) {
		System.out.println("서비스단 빌리지 댓글 1 넘버 셀렉트 디버깅");
		return villageDao.selectReplyNum(vNum);
	}

	@Override
	public void updateVillageCnt(int vNum) {
		villageDao.updateVillageCnt(vNum);
		System.out.println("서비스단 빌리지 조회수 업데이트 디버깅");
	}

	@Override
	public int selectVillgeBoardCnt() {
		System.out.println("서비스단 빌리지 개수 셀렉트 디버깅");
		return villageDao.selectVillgeBoardCnt();
	}
}
