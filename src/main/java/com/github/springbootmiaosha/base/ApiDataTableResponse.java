package com.github.springbootmiaosha.base;

/**
 * Api表格格式封装
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public class ApiDataTableResponse extends ApiResponse {

    private int draw;
    private Long recordsTotal;
    private Long recordsFiltered;

    public ApiDataTableResponse(ApiResponse.Status status){
        this(status.getCode(), status.getStandardMessage(), null);
    }

    public ApiDataTableResponse(int code, String message, Object data) {
        super(code, message, data);
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
