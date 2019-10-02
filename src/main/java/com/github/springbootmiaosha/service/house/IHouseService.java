package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.service.ServiceResult;
import com.github.springbootmiaosha.web.dto.HouseDTO;
import com.github.springbootmiaosha.web.form.DatatableSearch;
import com.github.springbootmiaosha.web.form.HouseForm;
import com.github.springbootmiaosha.web.form.MapSearch;
import com.github.springbootmiaosha.web.form.RentSearch;

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
     * 删除标签
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult deleteTag(Long houseId, String tag);

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

    /**
     * 删除图片
     * @param id
     * @return
     */
    ServiceResult removePhoto(Long id);

    /**
     * 更新封面
     * @param coverId
     * @param targetId
     * @return
     */
    ServiceResult updateCover(Long coverId, Long targetId);

    /**
     * 更新房源状态
     * @param houseId
     * @param status
     * @return
     */
    ServiceResult updateStatus(Long houseId, int status);

    /**
     * 查询房源信息集
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> query(RentSearch rentSearch);

    /**
     * 全地图查询
     * @param mapSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> wholeMapQuery(MapSearch mapSearch);

}
