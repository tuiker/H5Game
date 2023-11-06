package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("language")
@Schema(title = "语言实体")
public class Language {
    private Integer id;

    private String languageName;

}