package com.github.springbootmiaosha.web.controller.house;

import com.github.springbootmiaosha.base.ApiResponse;
import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.service.house.IAddressService;
import com.github.springbootmiaosha.web.dto.SubwayDto;
import com.github.springbootmiaosha.web.dto.SubwayStationDto;
import com.github.springbootmiaosha.web.dto.SupportAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 房屋控制层
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
@Controller
public class HouseController {

    @Autowired
    private IAddressService addressService;

    /**
     * 获取支持城市列表
     * @return
     */
    @GetMapping("/address/support/cities")
    @ResponseBody
    public ApiResponse getSupportCities(){
        ServiceMultiResult<SupportAddressDto> result = addressService.findAllCities();
        if (result.getResultSize() == 0) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(result.getResult());
    }

    /**
     * 获取对应城市支持区域列表
     * @param cityEnName
     * @return
     */
    @GetMapping("/address/support/regions")
    @ResponseBody
    public ApiResponse getSupportRegions(@RequestParam(name = "city_name") String cityEnName){
        ServiceMultiResult<SupportAddressDto> addressResult = addressService.findAllRegionsByCityName(cityEnName);

        if (addressResult.getResult() == null || addressResult.getTotal() < 1) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(addressResult.getResult());
    }

    /**
     * 获取具体城市所支持的地铁线路图
     * @param cityEnName
     * @return
     */
    @GetMapping("/address/support/subway/line")
    @ResponseBody
    public ApiResponse getSupportSubwayLine(@RequestParam(name = "city_name") String cityEnName){
        List<SubwayDto> subways = addressService.findAllSubwayByCity(cityEnName);
        if (subways.isEmpty()){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(subways);
    }

    /**
     * 获取对应地铁线路所支持的地铁站点
     * @param subwayId
     * @return
     */
    @GetMapping("/address/support/subway/station")
    @ResponseBody
    public ApiResponse getSupportSubwayStation(@RequestParam(name = "subway_id") Long subwayId){
        List<SubwayStationDto> stationDtos = addressService.findAllStationBySubway(subwayId);
        if (stationDtos.isEmpty()) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(stationDtos);
    }

}
