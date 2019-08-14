package com.github.springbootmiaosha.web.controller.house;

import com.github.springbootmiaosha.base.ApiResponse;
import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.service.house.IAdressService;
import com.github.springbootmiaosha.web.dto.SupportAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 房屋控制层
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
@Controller
public class HouseController {

    @Autowired
    private IAdressService adressService;

    /**
     * 获取支持城市列表
     * @return
     */
    @GetMapping("/address/support/cities")
    @ResponseBody
    public ApiResponse getSupportCities(){
        ServiceMultiResult<SupportAddressDto> result = adressService.findAllCities();
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
        ServiceMultiResult<SupportAddressDto> addressResult = adressService.findAllRegionsByCityName(cityEnName);

        if (addressResult.getResult() == null || addressResult.getTotal() < 1) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(addressResult.getResult());
    }


}
