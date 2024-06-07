package cc.anser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiRequestEntity {
    private String url;
    private String method;
    private List<RequestBodyEntity> requestBody;
    private List<ResponseBodyEntity> responseBody;
    private String responseResult;
}
