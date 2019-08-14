package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.entity.Subway;
import com.github.springbootmiaosha.entity.SupportAddress;
import com.github.springbootmiaosha.repository.SubwayRepository;
import com.github.springbootmiaosha.repository.SupportAddressRepository;
import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.web.dto.SubWayDto;
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
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private SubwayRepository subwayRepository;

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

    @Override
    public ServiceMultiResult<SupportAddressDto> findAllRegionsByCityName(String cityName) {
        if (cityName == null) {
            return new ServiceMultiResult<>(0, null);
        }

        List<SupportAddressDto> result = new ArrayList<>();

        List<SupportAddress> regions = supportAddressRepository.findAllByLevelAndBelongTo(SupportAddress.Level.REGION.getValue(), cityName);

        for (SupportAddress region : regions) {
            result.add(modelMapper.map(region, SupportAddressDto.class));
        }
        return new ServiceMultiResult<>(result.size(), result);
    }

    @Override
    public List<SubWayDto> findAllSubwayByCity(String cityEnName) {
        List<SubWayDto> result = new ArrayList<>();
        List<Subway> subways = subwayRepository.findAllByCityEnName(cityEnName);

        if (subways.isEmpty()){
            return result;
        }

        subways.forEach(subway -> result.add(modelMapper.map(subway, SubWayDto.class)));

        return result;
    }
}
