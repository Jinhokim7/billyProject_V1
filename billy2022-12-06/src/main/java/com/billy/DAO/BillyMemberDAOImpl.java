package com.billy.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.billy.VO.BillyMemberVO;

@Repository
public class BillyMemberDAOImpl implements IF_billyMemberDAO {
   
   private static String mapperQuery = "com.billy.DAO.IF_billyMemberDAO";

   @Inject
   private SqlSession sqlSession;
   
   @Override
   public void insertOne(BillyMemberVO bmvo) throws Exception {
      System.out.println(bmvo.getId()+"---dao�� �μ�Ʈüũ");
      sqlSession.insert(mapperQuery+".insertOne",bmvo);
      
   }

   @Override
   public int chkId(String id) throws Exception {   
      System.out.println(id+"---dao�� idüũ");
      return sqlSession.selectOne(mapperQuery+".chkId",id);
   }
   
}