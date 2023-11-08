package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("game_type")
@Schema(title = "游戏类型实体")
public class GameType {

    private Integer id;

    private String typeName;

}