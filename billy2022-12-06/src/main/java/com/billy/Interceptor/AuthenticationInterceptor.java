package com.billy.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//�α����� ���Ѱ��� �α����� �ϵ��� �Ѵ�.
		//������ �˻���..
		//Ŭ���̾�Ʈ���� ������ �ִ�.. Ŭ���̾�Ʈ�� ���� ��Ű�� ���̵�� ��ġ�ϴ� ������ ��ü�� �����Ͷ�
		HttpSession session = request.getSession();
		//������ ���ǿ��� login ������ ã�Ƽ� ���Ϲ޾ƶ� �׷��� login������ ����Ÿ���� �𸣴� ��纯���� �ֻ����� Object�� ȣ��
		Object obj = session.getAttribute("login");
		if(obj== null) {//�α��� ���� ���
			response.sendRedirect(request.getContextPath()+"/login"); // ��Ʈ�ѷ��� ��� �ٲ�
			return false;
		}
		return true;//������ ����
	}
	
	//��Ʈ�ѷ��� ������ ����
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("PostHandle start");
		System.out.println("PostHandle end");
		super.postHandle(request, response, handler, modelAndView);
	}

}