package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.service.ServiceResult;
import com.github.springbootmiaosha.web.dto.HouseDTO;
import com.github.springbootmiaosha.web.form.DatatableSearch;
import com.github.springbootmiaosha.web.form.HouseForm;

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

    /**
     * 新增房源
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> add(HouseForm houseForm);

    /**
     * 更新房源
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> update(HouseForm houseForm);

    /**
     * 房源搜索
     * @param searchBody
     * @return
     */
    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);

    /**
     * 查询完整房源信息
     * @param id
     * @return
     */
    ServiceResult<HouseDTO> findCompleteOne(Long id);

}
