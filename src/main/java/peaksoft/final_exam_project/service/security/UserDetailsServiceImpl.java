package peaksoft.final_exam_project.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import peaksoft.final_exam_project.model.security.MyUser;
import peaksoft.final_exam_project.model.security.User;
import peaksoft.final_exam_project.repository.security.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUser(user);
    }
}
