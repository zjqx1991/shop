package com.lkty.shop.common.po.product.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_spu_comment")
@ApiModel(value="SpuComment对象", description="商品评价")
public class SpuComment extends Model<SpuComment> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "sku_id")
    private String skuId;

    @ApiModelProperty(value = "spu_id")
    private String spuId;

    @ApiModelProperty(value = "商品名字")
    private String spuName;

    @ApiModelProperty(value = "会员昵称")
    private String memberNickName;

    @ApiModelProperty(value = "星级")
    private Boolean star;

    @ApiModelProperty(value = "会员ip")
    private String memberIp;

    @ApiModelProperty(value = "显示状态[0-不显示，1-显示]")
    private Boolean showStatus;

    @ApiModelProperty(value = "购买时属性组合")
    private String spuAttributes;

    @ApiModelProperty(value = "点赞数")
    private Integer likesCount;

    @ApiModelProperty(value = "回复数")
    private Integer replyCount;

    @ApiModelProperty(value = "评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    private String resources;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "用户头像")
    private String memberIcon;

    @ApiModelProperty(value = "评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    private Integer commentType;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "删除标识0未删除1已删除")
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty(value = "版本号")
    @TableField(fill = FieldFill.INSERT)
    @Version
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
