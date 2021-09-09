package com.org.security;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import com.org.security.model.Benefits;
import com.org.security.model.Member;
import com.org.security.model.Role;
import com.org.security.repository.BenefitsRepository;
import com.org.security.repository.MemberRepository;
import com.org.security.repository.RoleRepository;
import com.org.security.services.BenefitsService;
import com.org.security.services.MemberService;
import com.org.security.services.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SecurityModuleOauth2ApplicationTests {
	
	@MockBean
	BenefitsRepository benefitsRepository;
	
	@MockBean
	RoleRepository roleRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BenefitsService benefitsService;
	
	@Test
	public void getBenefitsTest() {
		when(benefitsRepository.findAll()).thenReturn(Stream.of(
				new Benefits(1L, "benefit1"), new Benefits(2L, "benefit2")).collect(Collectors.toList()));
		assertEquals(2, benefitsService.getAllBenefits().size());
	}
	
	@Test
	public void getRolesTest() {
		when(roleRepository.findAll()).thenReturn(Stream.of(
				new Role(1, "admin", "description"), new Role(2, "user","description")).collect(Collectors.toList()));
		assertEquals(2,roleService.getAllRoles().size());
	}
	
	@Test
	void contextLoads() {
	}

}
