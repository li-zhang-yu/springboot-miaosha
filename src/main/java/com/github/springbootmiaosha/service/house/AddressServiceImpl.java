package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.entity.Subway;
import com.github.springbootmiaosha.entity.SubwayStation;
import com.github.springbootmiaosha.entity.SupportAddress;
import com.github.springbootmiaosha.repository.SubwayRepository;
import com.github.springbootmiaosha.repository.SubwayStationRepository;
import com.github.springbootmiaosha.repository.SupportAddressRepository;
import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.service.ServiceResult;
import com.github.springbootmiaosha.web.dto.SubwayDTO;
import com.github.springbootmiaosha.web.dto.SubwayStationDTO;
import com.github.springbootmiaosha.web.dto.SupportAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private SubwayStationRepository subwayStationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllCities() {
        List<SupportAddress> addresses = supportAddressRepository.findAllByLevel(SupportAddress.Level.CITY.getValue());
        List<SupportAddressDTO> addressDtos = new ArrayList<>();
        for (SupportAddress supportAddress : addresses){
            SupportAddressDTO target = modelMapper.map(supportAddress, SupportAddressDTO.class);
            addressDtos.add(target);
        }
        return new ServiceMultiResult<>(addressDtos.size(), addressDtos);
    }

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllRegionsByCityName(String cityName) {
        if (cityName == null) {
            return new ServiceMultiResult<>(0, null);
        }

        List<SupportAddressDTO> result = new ArrayList<>();

        List<SupportAddress> regions = supportAddressRepository.findAllByLevelAndBelongTo(SupportAddress.Level.REGION.getValue(), cityName);

        for (SupportAddress region : regions) {
            result.add(modelMapper.map(region, SupportAddressDTO.class));
        }
        return new ServiceMultiResult<>(result.size(), result);
    }

    @Override
    public List<SubwayDTO> findAllSubwayByCity(String cityEnName) {
        List<SubwayDTO> result = new ArrayList<>();
        List<Subway> subways = subwayRepository.findAllByCityEnName(cityEnName);

        if (subways.isEmpty()) {
            return result;
        }

        subways.forEach(subway -> result.add(modelMapper.map(subway, SubwayDTO.class)));

        return result;
    }

    @Override
    public List<SubwayStationDTO> findAllStationBySubway(Long subwayId) {
        List<SubwayStationDTO> result = new ArrayList<>();
        List<SubwayStation> subwayStations = subwayStationRepository.findAllBySubwayId(subwayId);

        if (subwayStations.isEmpty()) {
            return result;
        }

        subwayStations.forEach(subwayStation -> result.add(modelMapper.map(subwayStation, SubwayStationDTO.class)));

        return result;
    }

    @Override
    public Map<SupportAddress.Level, SupportAddressDTO> findCityAndRegion(String cityEnName, String regionEnName) {
        Map<SupportAddress.Level, SupportAddressDTO> result = new HashMap<>();

        SupportAddress city = supportAddressRepository.findByEnNameAndLevel(cityEnName, SupportAddress.Level.CITY.getValue());

        SupportAddress region = supportAddressRepository.findByEnNameAndBelongTo(regionEnName, city.getEnName());

        result.put(SupportAddress.Level.CITY, modelMapper.map(city, SupportAddressDTO.class));
        result.put(SupportAddress.Level.REGION, modelMapper.map(region, SupportAddressDTO.class));

        return result;
    }

    @Override
    public ServiceResult<SubwayDTO> findSubway(Long subwayId) {
        if (subwayId == null){
            return ServiceResult.notFound();
        }

        Optional<Subway> subwayExample = subwayRepository.findById(subwayId);
        if (!subwayExample.isPresent()) {
            return ServiceResult.notFound();
        }

        Subway subway = subwayExample.get();

        return ServiceResult.of(modelMapper.map(subway, SubwayDTO.class));
    }

    @Override
    public ServiceResult<SubwayStationDTO> findSubwayStation(Long stationId) {
        if (stationId == null){
            return ServiceResult.notFound();
        }

        Optional<SubwayStation> subwayStationExample = subwayStationRepository.findById(stationId);
        if (!subwayStationExample.isPresent()){
            return ServiceResult.notFound();
        }

        SubwayStation subwayStation = subwayStationExample.get();

        return ServiceResult.of(modelMapper.map(subwayStation, SubwayStationDTO.class));
    }
}
