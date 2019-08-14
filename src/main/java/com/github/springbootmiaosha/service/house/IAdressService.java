package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.web.dto.SupportAddressDto;

/**
 * 地址服务接口
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
public interface IAdressService {

    /**
     * 查询所有城市
     * @return
     */
    ServiceMultiResult<SupportAddressDto> findAllCities();

}
