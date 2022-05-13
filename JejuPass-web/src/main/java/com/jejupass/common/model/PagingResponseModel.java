package com.jejupass.common.model;

import lombok.Data;

@Data
public class PagingResponseModel {
    private PagingModel paging;
    private ErrorModel error;
}