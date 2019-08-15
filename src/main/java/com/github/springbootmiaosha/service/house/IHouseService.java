package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.service.ServiceResult;

/**
 * 房屋管理服务相关接口
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
public interface IHouseService {

    /**
     * 新增标签
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult addTag(Long houseId, String tag);

}
