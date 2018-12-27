package edu.nbut.project_manage.service.admin;

import net.sf.json.JSONObject;

public interface StreetManageService {
    /**
     * 查询所有乡镇街道
     * @return JSONObject 乡镇街道信息
     */
    JSONObject selectAllStreet(Integer page, Integer size, Integer draw);

    /**
     * 增加一条新街道
     * @param streetTitle
     * @param streetCode
     * @param streetRemarks
     * @return 成功 1 ; 失败 0
     */
    int insertStreet(String streetTitle,String streetCode,String streetRemarks);

    /**
     * 删除一条街道
     * @param streetId
     * @return  成功 1 ; 失败 0
     */
    int deleteStreetByStreetId(Integer streetId);

    /**
     * 编辑街道信息
     * @param streetId
     * @param streetTitle
     * @param streetCode
     * @param streetRemarks
     * @return  成功 1 ; 失败 0
     */
    int updateStreet(String streetId,String streetTitle,String streetCode,String streetRemarks);
}
