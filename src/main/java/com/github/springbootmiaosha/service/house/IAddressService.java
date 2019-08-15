package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.web.dto.SubwayDto;
import com.github.springbootmiaosha.web.dto.SubwayStationDto;
import com.github.springbootmiaosha.web.dto.SupportAddressDto;

import java.util.List;

/**
 * 地址服务接口
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
public interface IAddressService {

    /**
     * 查询所有城市
     * @return
     */
    ServiceMultiResult<SupportAddressDto> findAllCities();

    /**
     * 根据城市英文简写获取该城市所有支持的区域信息
     * @param cityName
     * @return
     */
    ServiceMultiResult<SupportAddressDto> findAllRegionsByCityName(String cityName);

    /**
     * 获取该城市的所有地铁线路图
     * @param cityEnName
     * @return
     */
    List<SubwayDto> findAllSubwayByCity(String cityEnName);

    /**
     * 获取地铁线路的所有站点
     * @param subwayId
     * @return
     */
    List<SubwayStationDto> findAllStationBySubway(Long subwayId);

}