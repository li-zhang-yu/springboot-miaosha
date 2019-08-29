package com.github.springbootmiaosha.service.user;

import com.github.springbootmiaosha.entity.Role;
import com.github.springbootmiaosha.entity.User;
import com.github.springbootmiaosha.repository.RoleRepository;
import com.github.springbootmiaosha.repository.UserRepository;
import com.github.springbootmiaosha.service.IUserService;
import com.github.springbootmiaosha.service.ServiceResult;
import com.github.springbootmiaosha.web.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 用户接口实现类
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);

        if (user == null){
            return null;
        }

        List<Role> roles = roleRepository.findRolesByUserId(user.getId());

        if (roles == null || roles.isEmpty()) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" +  role.getName())));

        user.setAuthorityList(authorities);

        return user;
    }

    @Override
    public ServiceResult<UserDTO> findById(Long userid) {

        Optional<User> userExample = userRepository.findById(userid);
        if (!userExample.isPresent()) {
            return ServiceResult.notFound();
        }
        User user = userExample.get();

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return ServiceResult.of(userDTO);
    }
}
