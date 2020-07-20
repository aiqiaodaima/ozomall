package com.ozomall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ozomall.dao.GoodsAttrMapper;
import com.ozomall.dao.GoodsAttrValMapper;
import com.ozomall.entity.GoodsAttrDto;
import com.ozomall.entity.GoodsAttrValDto;
import com.ozomall.entity.Result;
import com.ozomall.service.GoodsAttrService;
import com.ozomall.utils.ResultGenerate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsAttrServiceImpl implements GoodsAttrService {
    @Resource
    GoodsAttrMapper goodsAttrMapper;

    @Resource
    GoodsAttrValMapper goodsAttrValMapper;

    /**
     * 添加商品属性
     *
     * @param form
     */
    @Override
    public Result addGoodsAttr(GoodsAttrDto form) {
        int rows = goodsAttrMapper.insert(form);
        if (rows > 0) {
            return ResultGenerate.genSuccessResult();
        } else {
            return ResultGenerate.genErroResult("商品属性添加失败，请重试！");
        }
    }

    /**
     * 获取商品属性
     *
     * @param form
     */
    @Override
    public Result getGoodsAttr(GoodsAttrDto form) {
        List<GoodsAttrDto> rows = goodsAttrMapper.goodsAttr(null, form);
        if (rows != null) {
            return ResultGenerate.genSuccessResult(rows);
        } else {
            return ResultGenerate.genErroResult("失败！");
        }
    }


    /**
     * 删除商品属性
     *
     * @param form
     */
    @Override
    public Result delGoodsAttr(GoodsAttrDto form) {
        LambdaQueryWrapper<GoodsAttrDto> wrapper = new LambdaQueryWrapper();
        wrapper.eq(GoodsAttrDto::getGoodsId, form.getGoodsId());
        wrapper.eq(GoodsAttrDto::getName, form.getName());
        int rows = goodsAttrMapper.delete(wrapper);
        if (rows > 0) {
            return ResultGenerate.genSuccessResult("删除成功");
        } else {
            return ResultGenerate.genErroResult("删除失败！");
        }
    }

    /**
     * 添加商品属性值
     *
     * @param form
     */
    @Override
    public Result addGoodsAttrVal(GoodsAttrValDto form) {
        int rows = goodsAttrValMapper.insert(form);
        if (rows > 0) {
            return ResultGenerate.genSuccessResult();
        } else {
            return ResultGenerate.genErroResult("属性值添加失败，请重试！");
        }
    }



    /**
     * 删除商品属性值
     *
     * @param form
     */
    @Override
    public Result delGoodsAttrVal(GoodsAttrValDto form) {
        LambdaQueryWrapper<GoodsAttrValDto> wrapper = new LambdaQueryWrapper();
        wrapper.eq(GoodsAttrValDto::getGoodsAttrId, form.getGoodsAttrId());
        wrapper.eq(GoodsAttrValDto::getValue, form.getValue());
        int rows = goodsAttrValMapper.delete(wrapper);
        if (rows > 0) {
            return ResultGenerate.genSuccessResult("删除成功");
        } else {
            return ResultGenerate.genErroResult("删除失败！");
        }
    }
}