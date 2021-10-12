package com.team.NewLearn.dto.lectureunit;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "cloud.aws.s3")
public class S3Component {

    private String bucket;

}