package cc.anser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseEntity {
    private Integer testCaseIndex;
    private String testCaseDescription;
    private String testCaseStatus;
    private List<VariableEntity> initVariables;
    private List<ApiRequestEntity> apiRequests;
    private List<AssertionEntity> assertions;
}
