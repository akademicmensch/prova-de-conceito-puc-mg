package br.com.sigo.springsecurityjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sigo.springsecurityjwt.models.SampleUser;
import br.com.sigo.springsecurityjwt.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	User retorno = null;
    	
    	List<SampleUser> users = userRepo.getAllUsers();
    	
    	for (SampleUser sampleUser : users) {
    		if(s.equalsIgnoreCase("guilherme.batista")) {
    			return new User("guilherme.batista", "guilherme123", retornarAuthority(sampleUser.getRole()));
        	}else if(s.equalsIgnoreCase("admin")) {
        		return new User("admin", "admin", new ArrayList<>());
        	}else if(s.equalsIgnoreCase("consultoria.um")) {
        		return new User("consultoria.um", "consultoria.um", new ArrayList<>());
        	}else if(s.equalsIgnoreCase("consultoria.dois")) {
        		return new User("consultoria.dois", "consultoria.dois", new ArrayList<>());
        	}else if(s.equalsIgnoreCase("funcionario.generico")) {
        		return new User("funcionario.generico", "funcionario.generico", new ArrayList<>());
        	}
		}

        return retorno;
    }
    
    public GrantedAuthority obterAuthority(String role) {
    	GrantedAuthority a = new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return role;
			}
		};
		return a;
    }
    
    public List<GrantedAuthority> retornarAuthority(String role){
    	GrantedAuthority obterAuthority = obterAuthority(role);
    	List<GrantedAuthority> lst = new ArrayList<>();
    	lst.add(obterAuthority);
    	return lst;
    }
    
    public void inputDefaultUsers(SampleUser user){
    	userRepo.addUser(user);
    }
    
    
    public SampleUser retornarUsuarioERole(String user) {
    	SampleUser u = new SampleUser();
    	if(user.equalsIgnoreCase("admin")) {
    		u = new SampleUser("admin","admin");
    	}else if(user.equalsIgnoreCase("guilherme.batista")) {
    		u = new SampleUser("guilherme.batista","admin");
    	}else if(user.equalsIgnoreCase("consultoria.um")) {
    		u = new SampleUser("consultoria.um","consultoria");
    	}else if(user.equalsIgnoreCase("consultoria.dois")) {
    		u = new SampleUser("consultoria.dois","consultoria");
    	}else if(user.equalsIgnoreCase("funcionario.generico")) {
    		u = new SampleUser("funcionario.generico","funcionario");
    	}
    	return u;
    }
    
    
}