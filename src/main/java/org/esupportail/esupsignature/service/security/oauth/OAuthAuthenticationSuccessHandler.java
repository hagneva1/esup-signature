package org.esupportail.esupsignature.service.security.oauth;

import org.esupportail.esupsignature.entity.enums.UserType;
import org.esupportail.esupsignature.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OAuthAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Resource
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		DefaultOAuth2User defaultOidcUser = ((DefaultOAuth2User)authentication.getPrincipal());
		String id = defaultOidcUser.getAttributes().get("sub").toString();
		String name = defaultOidcUser.getAttributes().get("family_name").toString();
		String prenom = defaultOidcUser.getAttributes().get("given_name").toString();
		String email = defaultOidcUser.getAttributes().get("email").toString();
		userService.createUser(id, name, prenom, email, UserType.external, true);
		httpServletRequest.getSession().setAttribute("securityServiceName", "OAuthSecurityServiceImpl");
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_FRANCECONNECT"));
		Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), simpleGrantedAuthorities);
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
	}
	
}