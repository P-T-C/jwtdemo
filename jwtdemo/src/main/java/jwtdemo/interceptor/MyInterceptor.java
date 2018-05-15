package jwtdemo.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import io.jsonwebtoken.SignatureException;
import jwtdemo.service.TokenAuthenticationService;

public class MyInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String jwToken = request.getHeader("Authorization");		
		if (jwToken != null) {
			try {
				TokenAuthenticationService.verifyToken(jwToken);
				return true;
			} catch (SignatureException e) {
				System.out.println("token is timeout");
				return false;
			}
			catch (Exception e) {
				System.out.println("Server error");
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoggerInterceptor.postHandler()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoggerInterceptor.afterCompletion()");
	}

}
