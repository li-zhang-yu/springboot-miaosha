package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.entity.SupportAddress;
import com.github.springbootmiaosha.repository.SupportAddressRepository;
import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.web.dto.SupportAddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址服务接口业务层
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
@Service
public class AddressServiceImpl implements IAdressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDto> findAllCities() {
        List<SupportAddress> addresses = supportAddressRepository.findAllByLevel(SupportAddress.Level.CITY.getValue());
        List<SupportAddressDto> addressDtos = new ArrayList<>();
        for (SupportAddress supportAddress : addresses){
            SupportAddressDto target = modelMapper.map(supportAddress, SupportAddressDto.class);
            addressDtos.add(target);
        }
        return new ServiceMultiResult<>(addressDtos.size(), addressDtos);
    }

}
